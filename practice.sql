SELECT *
FROM practice.emp;

# Highest Salary
select max(salary)
from emp;

# Get highest and second, third salary details.
SELECT *
FROM practice.emp
where salary
order by salary DESC
limit 1,1;

# SQL Query to find Max Salary from each department.
select deptId, max(salary)
from emp
group by deptId;

# Write SQL Query to display the current date?
SELECT current_date();

# Get duplicate records.
select name, count(name) as counts
from emp
group by name
having count(name) > 1;

# Get maximum salary from each department.
select deptId, max(salary) salary
from emp
group by deptId;

# Second Highest Salary based on limit first arg is to which data you want and 2nd is how much data you need wheather 1 or 2
select salary
from emp
order by salary desc
limit 0,1;

# Question 2: SQL Query to find Max Salary from each department.
select deptId, MAX(salary)
from emp
group by deptId;
select d.name, MAX(e.salary)
from emp e,
     dept d
where d.id = e.deptId
group by e.deptId;

# find all Employee records containing the word "Joe", regardless of whether it was stored as JOE, Joe, or joe
select *
from emp
where upper(name) like '%M%';

# Write SQL Query to find duplicate rows in a database? and then write SQL query to delete them?
select name, count(name) as counts
from emp
group by name
having count(name) > 1;
