drop table if exists UserTable;
Create table UserTable (
   ID int not null,
   User_login Varchar(128) not null,
   User_password Varchar(128) not null,
   CONSTRAINT User_Table_pk PRIMARY KEY (ID)
);
 
Insert into UserTable(ID, User_login, User_password) values (1, 'Admin', '1234');
Insert into UserTable(ID, User_login, User_password) values (2, 'User1', '1234');
Insert into UserTable(ID, User_login, User_password) values (3, 'User2', '1234');


select * from UserTable