create database employee_management_system ;
use employee_management_system;

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email_ID VARCHAR(255) NOT NULL,
    Salary DOUBLE NOT NULL,
    Age int NOT NULL CHECK (Age >= 21 AND Age <= 50),
    Education VARCHAR(255) NOT NULL
);

