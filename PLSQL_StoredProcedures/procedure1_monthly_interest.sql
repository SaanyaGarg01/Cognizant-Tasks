-- Scenario 1: Process monthly interest for all savings accounts.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update all savings accounts by applying a 1% interest rate to current balance
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/
