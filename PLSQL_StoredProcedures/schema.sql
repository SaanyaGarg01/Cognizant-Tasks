-- Schema setup for Stored Procedures Exercises

-- Drop tables if they already exist (for clean run)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- 1. Create Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER NOT NULL,
    AccountType VARCHAR2(20) CHECK (AccountType IN ('Savings', 'Checking')),
    Balance NUMBER(15, 2) NOT NULL
);

-- 2. Create Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    Department VARCHAR2(50) NOT NULL,
    Salary NUMBER(15, 2) NOT NULL
);

-- Insert mock data into Accounts
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance)
VALUES (201, 10, 'Savings', 5000.00);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance)
VALUES (202, 10, 'Checking', 1500.00);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance)
VALUES (203, 11, 'Savings', 12000.00);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance)
VALUES (204, 12, 'Checking', 200.00);

-- Insert mock data into Employees
INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (501, 'John Doe', 'IT', 60000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (502, 'Jane Smith', 'HR', 55000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (503, 'Michael Johnson', 'IT', 80000.00);

INSERT INTO Employees (EmployeeID, Name, Department, Salary)
VALUES (504, 'Emily Davis', 'Finance', 70000.00);

COMMIT;
