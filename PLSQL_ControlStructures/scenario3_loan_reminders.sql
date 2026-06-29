-- Scenario 3: Send reminders to customers whose loans are due within the next 30 days.

DECLARE
    -- Cursor to select loans due in the next 30 days
    CURSOR c_due_loans IS
        SELECT c.Name, l.LoanID, l.DueDate, l.Amount
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
        
    -- Variables to hold cursor data
    v_customer_name Customers.Name%TYPE;
    v_loan_id       Loans.LoanID%TYPE;
    v_due_date      Loans.DueDate%TYPE;
    v_amount        Loans.Amount%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Loan Payment Reminders ---');
    
    OPEN c_due_loans;
    LOOP
        FETCH c_due_loans INTO v_customer_name, v_loan_id, v_due_date, v_amount;
        EXIT WHEN c_due_loans%NOTFOUND;
        
        -- Print the reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Hello ' || v_customer_name || 
                             ', your loan (ID: ' || v_loan_id || 
                             ') of $' || TO_CHAR(v_amount, '99,999.99') || 
                             ' is due on ' || TO_CHAR(v_due_date, 'YYYY-MM-DD') || 
                             '. Please ensure payment is processed.');
    END LOOP;
    
    CLOSE c_due_loans;
EXCEPTION
    WHEN OTHERS THEN
        IF c_due_loans%ISOPEN THEN
            CLOSE c_due_loans;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
