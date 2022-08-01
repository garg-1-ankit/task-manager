# task-manager
Create task manager backend service

# Entitites

# Task Table Schema

All fields are NOT NULL

Task_id  - integer  primary auto_increment

Task_title - varchar(100)

Task_description - varchar(200)

Customer_id - int  foreign key

Created_at - date

updated_at   -date

Task_Priority  -  int

# Customer Table Schema 

All fields are NOT NULL

Customer_ID -  integer  primary auto_increment

Customer_Name  - varchar(50)

Customer_DOB  - date 

Customer_Email  - varchar(30)

Customer_Phone_no -  unique integer(10)
