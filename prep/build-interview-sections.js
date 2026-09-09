const fs = require("fs");
const path = require("path");
const childProcess = require("child_process");

const root = path.resolve(__dirname);
const sourceRoot = path.join(root, "java", "interviews");
const outputRoot = path.join(sourceRoot, "topics");
const templatePath = path.join(sourceRoot, "qns.html");

const categories = [
  { id: "java", label: "Java" },
  { id: "java8", label: "Java 8 Coding" },
  { id: "springboot", label: "Spring Boot" },
  { id: "hibernate", label: "Hibernate" },
  { id: "microservices", label: "Microservices" },
  { id: "sql", label: "SQL" },
  { id: "devops", label: "DevOps" },
  { id: "frontend", label: "Frontend" },
  { id: "other", label: "Other" }
];

const categoryRules = [
  ["java8", ["java 8", "java8", "streams", "stream api", "completablefuture", "optional", "lambda", "collectors", "stringjoiner", "partitioningby", "groupingby", "tomap", "flatmap", "reduce"]],
  ["hibernate", ["hibernate", "jpa", "@entity", "entitymanager", "lazy loading", "dirty checking", "fetchtype", "n+1", "hikari", "manytomany", "onetomany"]],
  ["springboot", ["spring boot", "spring framework", "@transactional", "@restcontroller", "@controller", "@service", "@repository", "@bean", "actuator", "spring security", "bean lifecycle", "applicationcontext", "multipartfile", "feign"]],
  ["microservices", ["microservice", "microservices", "service discovery", "api gateway", "circuit breaker", "resilience4j", "saga", "cqrs", "sidecar", "strangler", "distributed", "event-driven", "kafka", "rabbitmq", "idempotency", "bulkhead", "sharding", "replication"]],
  ["devops", ["docker", "kubernetes", "jenkins", "pipeline", "deployment", "deploy", "cloud", "aws", "azure", "gcp", "helm", "terraform", "autoscaling", "hpa", "vpa", "cluster", "pod", "node", "ingress", "nexus", "s3", "ci/cd", "canary"]],
  ["sql", ["sql", "mysql", "postgres", "oracle", "query", "join", "index", "normalization", "denormalization", "rdbms", "database", "stored procedure"]],
  ["frontend", ["javascript", "typescript", "react", "angular", "vue", "html", "css"]],
  ["java", ["java", "jvm", "garbage collector", "reflection", "multithreading", "thread", "collection", "exception", "singleton", "constructor", "classloader", "concurrenthashmap", "generics"]]
];

function allHtmlFiles(directory) {
  return childProcess.execFileSync("rg", ["--files", directory], { encoding: "utf8" })
    .trim()
    .split("\n")
    .filter(Boolean)
    .filter((file) => file.endsWith(".html") && !file.includes(`${path.sep}topics${path.sep}`));
}

function stripHtml(value) {
  return value
    .replace(/<[^>]*>/g, " ")
    .replace(/&nbsp;/g, " ")
    .replace(/&amp;/g, "&")
    .replace(/&lt;/g, "<")
    .replace(/&gt;/g, ">")
    .replace(/&quot;/g, '"')
    .replace(/&#39;/g, "'")
    .replace(/\s+/g, " ")
    .trim();
}

function normalizeQuestion(value) {
  return stripHtml(value)
    .replace(/^[^a-zA-Z0-9]+/, "")
    .replace(/^\d+[.)]?\s*/, "")
    .toLowerCase()
    .replace(/[^a-z0-9]+/g, " ")
    .trim();
}

function findMatchingDiv(html, start) {
  const divToken = /<\/?div\b[^>]*>/gi;
  divToken.lastIndex = start;
  let depth = 0;
  let match;
  while ((match = divToken.exec(html))) {
    if (match[0][1] === "/") {
      depth -= 1;
      if (depth === 0) return match.index + match[0].length;
    } else if (!match[0].endsWith("/>") && !match[0].toLowerCase().includes("</div")) {
      depth += 1;
    }
  }
  return html.length;
}

function extractTopLevelItems(html, source) {
  const starts = [];
  const startPattern = /<div\b[^>]*class=["'][^"']*\baccordion-item\b[^"']*["'][^>]*>/gi;
  let match;
  while ((match = startPattern.exec(html))) {
    starts.push({ start: match.index, end: findMatchingDiv(html, match.index) });
  }

  return starts
    .filter((candidate) => !starts.some((other) => other !== candidate && other.start < candidate.start && other.end >= candidate.end))
    .map((candidate) => {
      const block = html.slice(candidate.start, candidate.end);
      const button = block.match(/<button\b[^>]*accordion-button[^>]*>([\s\S]*?)<\/button>/i);
      if (!button) return null;
      const question = stripHtml(button[1]);
      if (!question) return null;
      const manual = block.match(/data-manual-category=["']([^"']+)["']/i)?.[1];
      return {
        block,
        question,
        key: normalizeQuestion(question),
        manual,
        source,
        priority: source.endsWith("/qns.html") ? 3 : source.includes("/interviews/") ? 2 : 1
      };
    })
    .filter(Boolean);
}

function detectCategory(item) {
  if (categories.some((category) => category.id === item.manual)) {
    return item.manual;
  }
  const text = stripHtml(item.block).toLowerCase();
  for (const [category, keywords] of categoryRules) {
    if (keywords.some((keyword) => text.includes(keyword))) return category;
  }
  return "other";
}

function chooseBest(items) {
  return items.sort((a, b) => {
    if (b.block.length !== a.block.length) return b.block.length - a.block.length;
    return b.priority - a.priority;
  })[0];
}

function templateParts(template) {
  const accordionStart = template.indexOf('<div class="accordion" id="accordionSeniorJava">');
  const accordionEnd = template.indexOf('\n    </div>\n\n  </div>\n  <!-- Bootstrap', accordionStart);
  if (accordionStart < 0 || accordionEnd < 0) throw new Error("Unable to find qns.html template boundaries");
  const beforeAccordion = template.slice(0, accordionStart);
  const afterAccordion = template.slice(accordionEnd + '\n    </div>'.length);
  return { beforeAccordion, afterAccordion };
}

function topicHtml(parts, category, items) {
  const buttons = category.id === "other"
    ? `<button class="tech-filter-btn active" type="button" data-category="all">All</button>`
    : `<button class="tech-filter-btn active" type="button" data-category="${category.id}">${category.label}</button>`;
  const filterBar = `<div class="tech-filter-container" id="techFilterBar">\n      ${buttons}\n    </div>`;
  const before = parts.beforeAccordion.replace(/<div class="tech-filter-container" id="techFilterBar">[\s\S]*?<\/div>/, filterBar);
  const body = items.map((item) => item.block).join("\n\n");
  return `${before}<div class="accordion" id="accordionSeniorJava">\n\n${body}\n\n    </div>${parts.afterAccordion}`;
}

function indexHtml() {
  const links = categories.map((category) => `      <li><a href="${category.id}.html">${category.label}</a></li>`).join("\n");
  return `<!doctype html>\n<html lang="en">\n<head>\n  <meta charset="UTF-8">\n  <meta name="viewport" content="width=device-width, initial-scale=1">\n  <title>Interview Preparation</title>\n  <style>body{font-family:system-ui,sans-serif;max-width:720px;margin:40px auto;padding:0 20px;background:#212529;color:#f8f9fa}a{color:#7dc4ff}li{margin:12px 0}</style>\n</head>\n<body>\n  <h1>Interview Preparation</h1>\n  <p>Canonical topic files generated from the existing preparation material.</p>\n  <ul>\n${links}\n  </ul>\n</body>\n</html>\n`;
}

fs.mkdirSync(outputRoot, { recursive: true });
const template = fs.readFileSync(templatePath, "utf8");
const parts = templateParts(template);
const sourceFiles = allHtmlFiles(root);
const allItems = sourceFiles.flatMap((file) => extractTopLevelItems(fs.readFileSync(file, "utf8"), file));
const byKey = new Map();
for (const item of allItems) {
  if (!item.key) continue;
  if (!byKey.has(item.key)) byKey.set(item.key, []);
  byKey.get(item.key).push(item);
}

const selected = new Map();
for (const group of byKey.values()) {
  const best = chooseBest(group);
  const category = detectCategory(best);
  if (!selected.has(category)) selected.set(category, []);
  selected.get(category).push(best);
}

for (const category of categories) {
  const items = (selected.get(category.id) || []).sort((a, b) => a.question.localeCompare(b.question));
  fs.writeFileSync(path.join(outputRoot, `${category.id}.html`), topicHtml(parts, category, items));
}
fs.writeFileSync(path.join(outputRoot, "index.html"), indexHtml());

const summary = categories.map((category) => `${category.label}: ${(selected.get(category.id) || []).length}`).join(" | ");
console.log(`Generated ${categories.length} topic files and index.html in ${outputRoot}`);
console.log(summary);
