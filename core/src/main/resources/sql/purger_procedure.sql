USE CUSTOMERDB;
#

DROP PROCEDURE IF EXISTS drop_all_tables ##
CREATE PROCEDURE drop_all_tables(IN scheme VARCHAR(255))
BEGIN
    DECLARE v_done INT DEFAULT FALSE;
    DECLARE v_tableName VARCHAR(255);
    DECLARE v_cursor CURSOR FOR
        SELECT table_name 
        FROM   information_schema.TABLES
        WHERE  table_schema = scheme;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = TRUE;

    SET FOREIGN_KEY_CHECKS = 0;

    OPEN v_cursor;
    REPEAT FETCH v_cursor INTO v_tableName;

    IF NOT v_done THEN
        SET @stmt_sql = CONCAT('DROP TABLE ', v_tableName);
        PREPARE stmt1 FROM @stmt_sql;
        EXECUTE stmt1;
        DEALLOCATE PREPARE stmt1;
    END IF;

    UNTIL v_done END REPEAT;

    CLOSE v_cursor;
    SET FOREIGN_KEY_CHECKS = 1;
END

#