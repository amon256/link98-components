CREATE PROCEDURE `ADD_FIELD_IF_NOT_EXISTS`(IN _table varchar(50),
IN _column varchar(50),
in _desc varchar(200))
BEGIN
	DECLARE _ISEXISTS INT;
	DECLARE _DATABASE VARCHAR(100);
	SELECT DATABASE() INTO _DATABASE;
	SELECT COUNT(*) INTO _ISEXISTS FROM information_schema.`COLUMNS` C,information_schema.`TABLES` T
	WHERE 
		T.TABLE_NAME = C.TABLE_NAME AND C.TABLE_SCHEMA = T.TABLE_SCHEMA
		AND LOWER(C.TABLE_NAME) = LOWER(_table) 
		AND LOWER(C.COLUMN_NAME) = LOWER(_column)
		AND LOWER(T.TABLE_SCHEMA) = LOWER(_DATABASE);
IF (_ISEXISTS = 0) THEN
set @sql = CONCAT('ALTER TABLE ',_table,' ADD ',_column,' ',_desc);
PREPARE stmt FROM @sql;
execute stmt;
END IF;
END