CREATE TABLE  IF NOT EXISTS t_upload_file (
	f_id varchar(40) not null,
	f_create_time DATETIME,
	f_last_update_time DATETIME,
	f_file_name varchar(200),
	f_file_path varchar(500),
	PRIMARY KEY (f_id)
);

CALL ADD_FIELD_IF_NOT_EXISTS('t_upload_file','f_create_time','DATETIME');
CALL ADD_FIELD_IF_NOT_EXISTS('t_upload_file','f_last_update_time','DATETIME');
CALL ADD_FIELD_IF_NOT_EXISTS('t_upload_file','f_file_name','varchar(200)');
CALL ADD_FIELD_IF_NOT_EXISTS('t_upload_file','f_file_path','varchar(500)');
