# PL/SQL Stored Procedures Exercises

This project contains SQL scripts defining stored procedures that execute business logic transactions for a banking application (applying monthly interest, granting employee performance bonuses, and transferring funds).

---

## Project Structure

```text
PLSQL_StoredProcedures/
│
├── README.md                           # Documentation and usage instructions
├── schema.sql                          # Creates tables and inserts mock data
├── procedure1_monthly_interest.sql     # ProcessMonthlyInterest procedure
├── procedure2_employee_bonus.sql       # UpdateEmployeeBonus procedure
└── procedure3_transfer_funds.sql        # TransferFunds procedure
```

---

## 1. Stored Procedures Reference

### 1. `ProcessMonthlyInterest`
- **Purpose**: Applies a monthly interest rate of 1% to all active **Savings** accounts.
- **Parameters**: None.
- **Transaction Rule**: Commits changes on successful updates, rolls back on exceptions.
- **SQL Execution**:
  ```sql
  EXEC ProcessMonthlyInterest;
  ```

### 2. `UpdateEmployeeBonus`
- **Purpose**: Updates salaries of employees within a designated department by a specified bonus percentage.
- **Parameters**:
  - `p_department` (IN, VARCHAR2): The target department name (e.g., `'IT'`).
  - `p_bonus_percentage` (IN, NUMBER): The bonus percentage (e.g., `5` representing 5%).
- **Transaction Rule**: Validates that the bonus rate is non-negative.
- **SQL Execution**:
  ```sql
  EXEC UpdateEmployeeBonus('IT', 5);
  ```

### 3. `TransferFunds`
- **Purpose**: Performs a secure transfer of funds between two user accounts, validating that the source account contains a sufficient balance.
- **Parameters**:
  - `p_source_account_id` (IN, NUMBER): Source account primary key.
  - `p_dest_account_id` (IN, NUMBER): Destination account primary key.
  - `p_amount` (IN, NUMBER): Dollar amount to transfer.
- **Security & Integrity**:
  - Locks the source account row during retrieval using `FOR UPDATE` to protect against race conditions.
  - Validates transfer limits ($> 0$), account existence, and sufficient funds.
- **SQL Execution**:
  ```sql
  EXEC TransferFunds(201, 202, 500.00);
  ```

---

## 2. How to Execute

### Step 1: Initialize Database Tables
Establish the mock tables and seed records in your Oracle DB client:
```sql
@schema.sql
```

### Step 2: Compile the Procedures
Run the scripts to register the stored procedures inside the database:
```sql
@procedure1_monthly_interest.sql
@procedure2_employee_bonus.sql
@procedure3_transfer_funds.sql
```

### Step 3: Run Tests
Run the procedures using the following test cases in your PL/SQL console:

```sql
SET SERVEROUTPUT ON;

-- 1. Apply Interest
EXEC ProcessMonthlyInterest;

-- 2. Award 10% Bonus to IT department
EXEC UpdateEmployeeBonus('IT', 10);

-- 3. Perform a Successful Transfer
EXEC TransferFunds(201, 202, 1000.00);

-- 4. Test Error Handling (Insufficient Balance)
EXEC TransferFunds(204, 201, 500.00);
```
