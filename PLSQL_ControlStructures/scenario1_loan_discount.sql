-- Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.

DECLARE
    v_age NUMBER;
BEGIN
    FOR r_customer IN (SELECT CustomerID, DOB, Name FROM Customers) LOOP
        -- Calculate current age in years
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_customer.DOB) / 12);
        
        -- Check if the customer is older than 60
        IF v_age > 60 THEN
            -- Apply a 1% discount to their current loan interest rates (subtracting 1 percentage point, e.g., 6.5% -> 5.5%)
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = r_customer.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Discount Applied: Customer ' || r_customer.Name || 
                                 ' (Age: ' || v_age || ') received a 1% interest rate discount.');
        END IF;
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
