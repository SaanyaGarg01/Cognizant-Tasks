-- Schema setup for Control Structures Exercises

-- Drop tables if they already exist (for clean run)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Loans';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Customers';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

-- 1. Create Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100) NOT NULL,
    DOB DATE NOT NULL,
    Balance NUMBER(15, 2) NOT NULL,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

-- 2. Create Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Amount NUMBER(15, 2) NOT NULL,
    InterestRate NUMBER(5, 2) NOT NULL,
    DueDate DATE NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Insert mock data into Customers
INSERT INTO Customers (CustomerID, Name, DOB, Balance)
VALUES (1, 'Alice Smith', TO_DATE('1955-04-12', 'YYYY-MM-DD'), 12000.00); -- Age: 71 (Over 60), Balance > 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance)
VALUES (2, 'Bob Jones', TO_DATE('1982-08-25', 'YYYY-MM-DD'), 8500.00);    -- Age: 43 (Under 60), Balance < 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance)
VALUES (3, 'Charlie Brown', TO_DATE('1960-12-05', 'YYYY-MM-DD'), 15000.00); -- Age: 65 (Over 60), Balance > 10,000

INSERT INTO Customers (CustomerID, Name, DOB, Balance)
VALUES (4, 'Diana Prince', TO_DATE('1995-02-14', 'YYYY-MM-DD'), 3000.00);   -- Age: 31 (Under 60), Balance < 10,000

-- Insert mock data into Loans
-- Assuming today is around 2026-06-29
INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (101, 1, 50000.00, 6.50, TO_DATE('2026-07-15', 'YYYY-MM-DD')); -- Due in 16 days (Under 30 days)

INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (102, 2, 20000.00, 7.20, TO_DATE('2026-08-20', 'YYYY-MM-DD')); -- Due in 52 days

INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (103, 3, 100000.00, 5.80, TO_DATE('2026-07-10', 'YYYY-MM-DD')); -- Due in 11 days (Under 30 days)

INSERT INTO Loans (LoanID, CustomerID, Amount, InterestRate, DueDate)
VALUES (104, 4, 15000.00, 8.00, TO_DATE('2026-09-01', 'YYYY-MM-DD')); -- Due in 64 days

COMMIT;
