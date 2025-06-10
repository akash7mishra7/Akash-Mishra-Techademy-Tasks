SELECT first_name, country FROM Customers
WHERE age>25;

SELECT item FROM Orders
ORDER BY amount;

SELECT * FROM Customers
WHERE first_name LIKE 'J%';

SELECT order_id, item, amount, first_name, last_name, country FROM Orders
INNER JOIN Customers on orders.customer_id = Customers.customer_id

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100)
);
CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

INSERT INTO employees (employee_id, name) VALUES
(1, 'Akash'),
(2, 'Benerje'),
(3, 'Ram'),
(4, 'Sakshi');

INSERT INTO projects (project_id, project_name, employee_id) VALUES
(101, 'Website Redesign', 1),
(102, 'Mobile App', 2),
(103, 'Database Migration', 4);

SELECT employees.employee_id, employees.name, projects.project_name
FROM employees
LEFT JOIN projects ON employees.employee_id = projects.employee_id;

CREATE TABLE suppliers (
    supplier_id INT PRIMARY KEY,
    supplier_name VARCHAR(100)
);

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    supplier_id INT
);

INSERT INTO suppliers (supplier_id, supplier_name) VALUES
(1, 'Amazon Traders'),
(2, 'Global Supplies'),
(3, 'Sunrise Corp');

INSERT INTO products (product_id, product_name, supplier_id) VALUES
(101, 'Notebook', 1),
(102, 'Pen', 2),
(103, 'Stapler', NULL),     
(104, 'Folder', 4);         

SELECT 
    suppliers.supplier_id, 
    suppliers.supplier_name,
    products.product_id, 
    products.product_name
FROM suppliers
FULL OUTER JOIN products ON suppliers.supplier_id = products.supplier_id;

