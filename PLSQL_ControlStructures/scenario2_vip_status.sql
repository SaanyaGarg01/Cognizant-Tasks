-- Scenario 2: Promote customers to VIP status based on their balance.

BEGIN
    FOR r_customer IN (SELECT CustomerID, Balance, Name FROM Customers) LOOP
        -- Check if balance is over $10,000
        IF r_customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_customer.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('VIP Promotion: Customer ' || r_customer.Name || 
                                 ' promoted to VIP (Balance: $' || TO_CHAR(r_customer.Balance, '99,999.99') || ').');
        ELSE
            -- Optional: Ensure non-VIP status if balance drops below threshold
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = r_customer.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
