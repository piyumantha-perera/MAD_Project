package com.example.mad_project.Database;

import android.provider.BaseColumns;

public class ProjectTables {

    public ProjectTables() {
    }

    protected static class Users implements BaseColumns {
        //User Details table
        public static final String TABLE_USERS = "UserDetails";
        public static final String COULMN_USERNAME = "Name";
        public static final String COULMN_CONTACTNO = "ContactNo";
        public static final String COULMN_EMAIL = "Email";
        public static final String COULMN_ADDRESS = "Address";
        public static final String COULMN_PASSWORD = "Password";
        public static final String COULMN_CNFPASSWORD = "Cnf_Password";
    }

    public static class Employee implements BaseColumns {
        //Employee Salary Details table
        public static final String TABLE_NAME = "EmployeeDetails";
        public static final String COLUMN_NAME = "UserName";
        public static final String COLUMN_BASICSALARY = "BasicSalary";
        public static final String COLUMN_ALLOWANCE = "TravellingAllowance";
        public static final String COLUMN_OT = "OverTime";
        public static final String COLUMN_SALARYADVANCE = "SalaryAdvance";
        public static final String COLUMN_NETSALARY = "NetSalary";
        public static final String COLUMN_DATE = "Date";

    }

    protected static class Creations implements BaseColumns {
        //Creation Details table
        public static final String TABLE_CREATION = "CreationDetails";
        public static final String COLUMN_USERNAME = "Name";
        public static final String COLUMN_CREATION = "Creation_Type";
        public static final String COLUMN_LENGTH = "Length";
        public static final String COLUMN_WIDTH = "Width";
        public static final String COLUMN_URL = "Sample_Images";
        public static final String COLUMN_DESCRIPTION = "Description";
        public static final String COLUMN_QUANTITY = "Quantity";
        public static final String COLUMN_AMOUNT = "Total_Amount";
        public static final String COLUMN_TYPE = "Get_Type";
        public static final String COLUMN_DATE = "Del_Date";

    }
     public static class EmployeeAdd implements BaseColumns {
       //employee add table
        public static final String  TABLE_EMPLOYEEADD = "EmployeeAddDetails";
        public static final String COLUMN_EMPLOYEEFNAME = "First_Name";
        public static final String COLUMN_EMPLOYEELNAME = "Last_Name";
        public static final String COLUMN_EMAIL = "Email";
        public static final String COLUMN_ADDRESS = "Address";
        public static final String COLUMN_CONTACT = "Contact";
        public static final String COLUMN_NIC = "NIC";
        public static final String COLUMN_EMPLOYEETYPE = "Employee_Type";

     }


    protected static class Thoughts implements BaseColumns {
        //Thought Details table
        public static final String TABLE_Thought = "ThoughtDetails";
        public static final String COULMN_EMAIL = "Email";
        public static final String COULMN_RATING = "Rating";
        public static final String COULMN_FEEDBACK = "FeedBack";

    }

    public static class EMPWorks implements BaseColumns {
        //work table
        public static final String TABLE_EMPWORKS = "EMPWorkDetails";
        public static final String COLUMN_NIC = "NIC";
        public static final String COLUMN_EMPName = "Employee_Name";
        public static final String COLUMN_Work_Description = "Work_Description";
        public static final String COLUMN_Location = "Location";
        public static final String COLUMN_Date = "Date";
    }
    }


