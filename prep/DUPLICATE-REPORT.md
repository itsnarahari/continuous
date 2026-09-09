# Interview Preparation Cleanup Report

Generated from the HTML files currently under `prep/`.

## Inventory

- HTML files scanned: 29
- Other files found: 1 PDF and 1 PNG
- Question buttons detected: approximately 2,603
- Exact normalized question-title duplicate groups: 452
- Entries belonging to those groups: 976

## Important Qualification

The duplicate count is a candidate count, not a final deletion list. Some repeated titles are intentionally repeated
inside the same file, some are template or category cards, and some answers may contain different examples. Before
merging, compare the complete answer body and preserve the most complete version.

## Strong Duplicate Candidates

These questions appear across multiple Java preparation files and are good candidates for one canonical answer:

- `How does HashMap work internally in Java?`
  - `prep/java/companies/paypal.html`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `CrudRepository vs JpaRepository?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `How does SpringApplication.run() method work internally?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `How does Map work internally in Java?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `How does Spring Boot Assign Memory in JVM?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `What Happens If JVM Memory Limit is Reached?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `What is Metaspace in JVM and How Does It Affect Spring Boot?`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/general/mixOf.html`
  - `prep/java/coding.html`
- `API Optimizations: Best Practices & Examples`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `Microservices Resilience Patterns & Examples`
  - `prep/java/companies/paypal.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `What Were We Using Before Kubernetes?`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `What is Infrastructure as Code (IaC) in DevOps?`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `Exception Hierarchy in Java`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `Efficient File Reading and Writing in Java`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `Exception Handling in Java parallelStream()`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `What Happens If You Use synchronized (this) Instead?`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `Key Components of LinkedHashSet in Java`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `What are subqueries, and how do they differ from joins?`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`
- `How do you handle NULL values in SQL queries?`
  - `prep/java/java.html`
  - `prep/java/javaqns.html`
  - `prep/java/coding.html`

## Repeated Content Inside Individual Files

The scan also found repeated titles within the same file, especially in `java.html`, `javaqns.html`, and `coding.html`.
Examples include generic output-question cards, CORS, SSL/HTTPS, AWS DevOps tools, and numbered Java basics. These
should be reviewed separately because they may be accidental duplicated markup rather than separate study questions.

## Likely Canonical File Strategy

Use `prep/java/interviews/qns.html` as the canonical combined file because it already has:

- Technology filters
- Search
- Accordion navigation
- The latest interview questions at the top
- Manual category metadata

Recommended source handling:

1. Compare complete question-and-answer bodies, not titles alone.
2. Keep the most complete answer and merge unique examples from shorter copies.
3. Add one canonical category to each question.
4. Preserve company-specific context as a tag or separate section when it adds value.
5. Keep original files unchanged until the combined file is reviewed.
6. Move superseded files to an archive only after the combined file is verified.

## Known Cleanup Risk

Some recent top additions had malformed nested accordion wrappers, which caused the filter to show a count without
showing the questions. That structure has been corrected in `qns.html`. Any future merge should validate accordion
nesting and filter behavior after each batch.

## Next Safe Step

The next step should be a staged merge of the strongest duplicate candidates into `qns.html`, followed by a second scan
for remaining duplicate titles and incomplete answers. No source files were deleted or moved as part of this report.
