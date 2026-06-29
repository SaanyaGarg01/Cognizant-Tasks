# PL/SQL Control Structures Exercises

This project contains SQL and PL/SQL scripts that implement business logic workflows for a banking application using control structures (loops, conditional logic, cursors).

---

## Project Structure

```text
PLSQL_ControlStructures/
│
├── README.md                           # Documentation and explanation of solutions
├── schema.sql                          # Creates tables and inserts mock data
├── scenario1_loan_discount.sql         # PL/SQL block applying interest rate discounts
├── scenario2_vip_status.sql            # PL/SQL block promoting customers to VIP
└── scenario3_loan_reminders.sql        # PL/SQL block generating loan due reminders
```

---

## 1. Relational Schema Setup (`schema.sql`)

To run the PL/SQL blocks, the following tables are set up:
- **Customers**: Contains customer demographic details, account balances, and VIP indicators.
- **Loans**: Stores loan records associated with customers, containing principal amounts, interest rates, and due dates.

---

## 2. Business Scenarios & PL/SQL Blocks

### Scenario 1: Apply Loan Interest Discount for Seniors
- **Objective**: Loop through all customers, check if they are above 60 years old, and apply a 1% discount to their loan interest rates.
- **Implementation**:
  - Uses a cursor-based `FOR` loop to iterate through all customers.
  - Calculates age using Oracle's `MONTHS_BETWEEN(SYSDATE, DOB) / 12`.
  - Performs an `UPDATE` statement on the `Loans` table if the age criterion is satisfied (> 60).
  - Handles changes with a local transaction `COMMIT` or `ROLLBACK` on errors.

### Scenario 2: Promote VIP Customers Based on Balance
- **Objective**: Promote customers with account balances exceeding $10,000 to VIP status by setting the `IsVIP` flag to `'TRUE'`.
- **Implementation**:
  - Uses conditional `IF-THEN-ELSE` logic inside a cursor loop.
  - Updates the `IsVIP` state to `'TRUE'` if the balance exceeds 10,000, otherwise updates or maintains it as `'FALSE'`.

### Scenario 3: Send Loan Due Reminders
- **Objective**: Print reminder messages for customers with loans due within the next 30 days.
- **Implementation**:
  - Uses an explicit `CURSOR` to fetch names, loan IDs, amounts, and due dates.
  - Filters records where `DueDate` lies between `SYSDATE` and `SYSDATE + 30`.
  - Loops over active cursor items and prints alerts using `DBMS_OUTPUT.PUT_LINE`.

---

## 3. How to Execute

You can execute these scripts in any SQL command client connected to an Oracle Database (e.g., SQL*Plus, SQL Developer, or DBeaver).

### Step 1: Enable Console Output
Ensure console outputs are enabled in your Oracle SQL command interface:
```sql
SET SERVEROUTPUT ON;
```

### Step 2: Initialize the Database Schema
Run the schema setup script to construct the tables and populate mock datasets:
```sql
@schema.sql
```

### Step 3: Run the PL/SQL Blocks
Run each script sequentially:
```sql
-- Run Interest Rate Discount block
@scenario1_loan_discount.sql

-- Run VIP Status Promotion block
@scenario2_vip_status.sql

-- Run Loan Reminders block
@scenario3_loan_reminders.sql
```
