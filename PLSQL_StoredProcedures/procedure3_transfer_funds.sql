-- Scenario 3: Transfer funds between accounts with validation checks.

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_dest_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance Accounts.Balance%TYPE;
    v_dest_exists NUMBER;
BEGIN
    -- 1. Validate that the transfer amount is positive
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero.');
    END IF;

    -- 2. Lock and retrieve source account balance to prevent concurrent race conditions
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_source_account_id
    FOR UPDATE;

    -- 3. Verify source account has sufficient balance
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient balance in source account ID: ' || p_source_account_id || 
                                         ' (Available: $' || TO_CHAR(v_source_balance, '99,999.99') || ').');
    END IF;

    -- 4. Verify destination account exists
    SELECT COUNT(*) INTO v_dest_exists
    FROM Accounts
    WHERE AccountID = p_dest_account_id;

    IF v_dest_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20004, 'Destination account ID ' || p_dest_account_id || ' does not exist.');
    END IF;

    -- 5. Perform the transfer (deduct from source, add to destination)
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_source_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_dest_account_id;

    -- 6. Commit the entire unit of work
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Transferred $' || TO_CHAR(p_amount, '99,999.99') || 
                         ' from Account ' || p_source_account_id || ' to Account ' || p_dest_account_id || '.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source account ID ' || p_source_account_id || ' not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction failed and was rolled back. Details: ' || SQLERRM);
END TransferFunds;
/
