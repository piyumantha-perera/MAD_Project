package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_project.Database.DBHandler;

public class Admin_Login extends AppCompatActivity {

    Button adlog;
    EditText name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);

        adlog = findViewById(R.id.buttonAdminLogin);
        name=findViewById(R.id.empIDW);
        password=findViewById(R.id.empNameW);


        adlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String user = name.getText().toString();
                String pwd  = password.getText().toString();

                if (user.equals("admin") && pwd.equals("123")){
                    Intent intent = new Intent(Admin_Login.this,Admin_Choose.class);
                    startActivity(intent);
                    Toast.makeText(Admin_Login.this, "Login Successfull.", Toast.LENGTH_SHORT).show();
                }
               else {
                    Toast.makeText(Admin_Login.this, "Login unsuccessfully.", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
