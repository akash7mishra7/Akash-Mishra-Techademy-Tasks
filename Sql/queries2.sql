/* A-1*/
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(10),
    department VARCHAR(10),
    experience_years INT,
    salary INT
);

INSERT INTO employees (employee_id, name, experience_years, salary, department) VALUES
(1, 'Akash', 10, 60000, 'IT'),
(2, 'Rohan', 5, 50000, 'HR'),
(3, 'Mohan', 8, 55000, 'Sales'),
(4, 'Sakshi', 2, 35000, 'HR'),
(5, 'Saurbh', 2, 35000, 'IT'),
(6, 'Karan', 2, 35000, 'Finance'),
(7, 'Omkar', 12, 70000, 'Sales'),
(8, 'Roshan', 5, 50000, 'Finance'),
(9, 'Vaibhav', 6, 52000, 'Sales'),
(10, 'Kush', 4, 48000, 'Sales');
SELECT * FROM employees;

/* A-2*/
UPDATE employees
SET salary = salary + 5000
WHERE experience_years > 5;
SELECT * FROM employees;

/*A-3*/
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(10),
    last_login DATETIME
);

INSERT INTO customers (customer_id, name, last_login) VALUES
(1, 'Rahul', '2023-05-10 10:15:00'),
(2, 'Sneha', '2022-01-01 09:30:00'),
(3, 'Amit', '2021-11-15 14:45:00'),
(4, 'Priya', '2024-12-20 08:00:00');
SELECT * FROM customers;

DELETE FROM customers
WHERE last_login < CURRENT_DATE - INTERVAL 3 YEAR;
SELECT * FROM customers;

/*A-4*/
SELECT employee_id, name, department, salary
FROM employees e
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
    WHERE department = e.department
);

/*A-5*/
SELECT department, SUM(salary) AS total_expense, AVG(salary) AS avg_expense
FROM employees
GROUP BY department;
SELECT 
    SUM(salary) AS total_company_expense
FROM employees;


/*A-6*/
SELECT employee_id, name, department, salary,
  CASE 
    WHEN salary >= 65000 THEN 'Senior'
    WHEN salary >= 40000 THEN 'Mid-Level'
    ELSE 'Junior'
  END AS salary_category
FROM employees;

/*A-9.1*/
SELECT employee_id, name, department, salary
FROM employees
WHERE salary > 50000 AND department = 'Sales'
ORDER BY name;

/*A-9.2*/
SELECT employee_id, name, department, salary
FROM employees
WHERE salary > 50000 AND department = 'Sales'
ORDER BY salary DESC;

/*A-10.1*/
SELECT employee_id, name, department, salary
FROM employees
ORDER BY salary DESC
LIMIT 3;

/*A-10.2*/
SELECT employee_id, name, department, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees
);

/*A-7*/
EXPLAIN SELECT * 
FROM employees 
WHERE department = 'Sales' AND salary > 50000;

CREATE INDEX idx_dept_salary ON employees(department, salary);

EXPLAIN SELECT * 
FROM employees 
WHERE department = 'Sales' AND salary > 50000;

/*A-8*/
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(50),
    department_location VARCHAR(100)
);
CREATE TABLE employees2 (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100),
    salary DECIMAL(10, 2),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO departments (department_id, department_name, department_location) VALUES
(1, 'IT', 'Mumbai'),
(2, 'HR', 'Delhi'),
(3, 'Sales', 'Bangalore'),
(4, 'Finance', 'Chennai');
SELECT * from departments;

INSERT INTO employees2 (employee_id, name, salary, department_id) VALUES
(1, 'Akash', 60000, 1),
(2, 'Rohan', 50000, 2),
(3, 'Mohan', 55000, 3),
(4, 'Sakshi', 35000, 2),
(5, 'Saurabh', 35000, 1),
(6, 'Karan', 35000, 4),
(7, 'Omkar', 70000, 3),
(8, 'Roshan', 50000, 4);
SELECT * from employees2;

SELECT e.name, d.department_name, d.department_location, e.salary
FROM employees2 e
JOIN departments d ON e.department_id = d.department_id;

SELECT e.name, d.department_name, e.salary
FROM employees2 e
JOIN departments d ON e.department_id = d.department_id
WHERE (e.department_id, e.salary) IN (
    SELECT department_id, MAX(salary)
    FROM employees2
    GROUP BY department_id
);

/*A-11*/
CREATE TABLE authors (
    author_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(50),
    birth_year INT
);

CREATE TABLE publishers (
    publisher_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(50),
    founding_year INT
);

CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author_id INT,
    publisher_id INT,
    genre VARCHAR(50),
    publication_year INT,
    pages INT,
    FOREIGN KEY (author_id) REFERENCES authors(author_id),
    FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id)
);

INSERT INTO authors VALUES
(1, 'J.K. Rowling', 'United Kingdom', 1965),
(2, 'George R.R. Martin', 'United States', 1948),
(3, 'Agatha Christie', 'United Kingdom', 1890),
(4, 'Haruki Murakami', 'Japan', 1949),
(5, 'Chimamanda Ngozi Adichie', 'Nigeria', 1977);

INSERT INTO publishers VALUES
(101, 'Bloomsbury Publishing', 'London', 1986),
(102, 'Bantam Books', 'New York', 1945),
(103, 'William Collins, Sons', 'London', 1819),
(104, 'Shinchosha', 'Tokyo', 1896),
(105, 'Alfred A. Knopf', 'New York', 1915);

INSERT INTO books VALUES
(1001, 'Harry Potter and the Philosopher''s Stone', 1, 101, 'Fantasy', 1997, 223),
(1002, 'A Game of Thrones', 2, 102, 'Fantasy', 1996, 694),
(1003, 'Murder on the Orient Express', 3, 103, 'Mystery', 1934, 256),
(1004, 'Norwegian Wood', 4, 104, 'Literary Fiction', 1987, 296),
(1005, 'Half of a Yellow Sun', 5, 105, 'Historical Fiction', 2006, 433),
(1006, 'Harry Potter and the Chamber of Secrets', 1, 101, 'Fantasy', 1998, 251),
(1007, 'Kafka on the Shore', 4, 104, 'Magical Realism', 2002, 505),
(1008, 'And Then There Were None', 3, 103, 'Mystery', 1939, 272);


SELECT b.title, a.name AS author, p.name AS publisher, b.publication_year
FROM books b
JOIN authors a ON b.author_id = a.author_id
JOIN publishers p ON b.publisher_id = p.publisher_id
ORDER BY b.publication_year;

SELECT a.name, COUNT(b.book_id) AS book_count
FROM authors a
LEFT JOIN books b ON a.author_id = b.author_id
GROUP BY a.name
ORDER BY book_count DESC;

SELECT title, name AS author, publication_year
FROM books b
JOIN authors a ON b.author_id = a.author_id
WHERE genre = 'Mystery';
