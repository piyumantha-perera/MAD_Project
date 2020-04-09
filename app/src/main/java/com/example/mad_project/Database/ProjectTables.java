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
        public static final String TABLE_NAME = "EmployeeDetails";
        public static final String COLUMN_NAME = "UserName";
        public static final String COLUMN_BASICSALARY = "BasicSalary";
        public static final String COLUMN_ALLOWANCE = "TravellingAllowance";
        public static final String COLUMN_OT = "OverTime";
        public static final String COLUMN_SALARYADVANCE = "SalaryAdvance";
        public static final String COLUMN_NETSALARY = "NetSalary";

    }
}