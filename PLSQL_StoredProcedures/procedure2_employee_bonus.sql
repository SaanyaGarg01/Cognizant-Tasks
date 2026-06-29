-- Scenario 2: Implement employee bonus scheme based on performance.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Validate bonus percentage parameter
    IF p_bonus_percentage < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage cannot be negative.');
    END IF;
    
    -- Update the salary of employees in the specified department
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salaries updated with a ' || p_bonus_percentage || 
                         '% bonus for all employees in department: ' || p_department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/
