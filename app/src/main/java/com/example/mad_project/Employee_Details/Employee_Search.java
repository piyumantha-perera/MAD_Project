package com.example.mad_project.Employee_Details;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mad_project.Admin_Choose;
import com.example.mad_project.Database.DBHandler;
import com.example.mad_project.R;

import java.util.ArrayList;
import java.util.List;

public class Employee_Search extends AppCompatActivity {
    private Spinner spinner;

    Button delete;
    ImageView search;
    TextView test;

    EditText salaryID;
    ImageView home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__search);

        DBHandler dbHandler = new DBHandler(getApplicationContext());

        search = findViewById(R.id.btnSalaryNameSearch);
        spinner = findViewById(R.id.spinnerSalSearch);
        delete=findViewById(R.id.btnSalaryDelete);

        salaryID = findViewById(R.id.editTextID);
        //test = findViewById(R.id.textView2);

        home = findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Employee_Search.this, Admin_Choose.class);

                startActivity(intent);
            }
        });


       final List<String> names = new ArrayList<>();
        names.add(0, "View Employee Names");

        Cursor cursor = dbHandler.readEmpspinNme();
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            String id = cursor.getString(0);
            names.add("Name "+name + " "+ "ID " +id);
        }

        ArrayAdapter<String> adapter;
        adapter = new  ArrayAdapter(Employee_Search.this, android.R.layout.simple_spinner_item, names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                //String name = spinner.getSelectedItem().toString();
               // salaryID.setError("please enter the ID");

                String getId = salaryID.getText().toString();


                /*Cursor check = dbHandler.readEmployeeSalary();
                while (check.moveToNext()){
                    String empName = check.getString(1);
                    if (empName.equals(name)){

                        salaryID = check.getString(0);
                    }
                }*/
                //test.setText(salaryID);

                List user = dbHandler.readEmployeeDetails(getId);




            if(getId.isEmpty()){
                    salaryID.setError("please enter the ID");

            }

           else {

                Intent i = new Intent(Employee_Search.this, Employee_SalaryUpdate.class);

                String userName=(user.get(0).toString());
                String basicSalary=(user.get(1).toString());
                String travellingAllowance=(user.get(2).toString());
                String overTime=(user.get(3).toString());
                String salaryAdvance=(user.get(4).toString());
                String netSalary=(user.get(5).toString());

                i.putExtra("ID", getId);
                i.putExtra("UserName", userName);
                i.putExtra("BasicSalary", basicSalary);
                i.putExtra("TravellingAllowance", travellingAllowance);
                i.putExtra("OverTime", overTime);
                i.putExtra("SalaryAdvance", salaryAdvance);
                i.putExtra("NetSalary", netSalary);

                startActivity(i);
            }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Employee_Search.this);
                alertDialogBuilder.setTitle("Delete Salary!");
                alertDialogBuilder.setMessage("Are you Sure, You want to Delete?");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    DBHandler dbHandler = new DBHandler(getApplicationContext());

                //String salaryName = spinner.getSelectedItem().toString();

                String getId = salaryID.getText().toString();

                /*Cursor check = dbHandler.readEmployeeSalary();
                while (check.moveToNext()){
                    String empName = check.getString(1);
                    if (empName.equals(salaryName)){

                        salaryID = check.getString(0);
                    }
                }*/

                Boolean delete = dbHandler.deleteEmployeeInfo(getId);
                        salaryID.setText(null);

                        if (delete){
                            Toast.makeText(Employee_Search.this, "Salary Deleted", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Employee_Search.this,Employee_Search.class);
                            startActivity(intent);
                            //spinner.setAdapter((SpinnerAdapter) names);

                        }
                        else {
                            Toast.makeText(Employee_Search.this, "Salary not Deleted", Toast.LENGTH_SHORT).show();
                            salaryID.setError("please enter the ID");

                        }
            }
        });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Delete Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });


    }
}
