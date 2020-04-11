package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mad_project.Database.DBHandler;

public class Leaflet_Clone extends AppCompatActivity {

    EditText dDate;
    Button add;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaflet__clone);

        dbHandler = new DBHandler(getApplicationContext());

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerGetingType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.customer_creation_get, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        dDate = findViewById(R.id.editTextCreDelDate);
        add = findViewById(R.id.buttonCreationAdd);

        Bundle bn = getIntent().getExtras();
        final String username = bn.getString("Name");
        final String c_type = bn.getString("creation_type");
        final String qty = bn.getString("Quantity");
        final String price = bn.getString("Price");
        final String url = bn.getString("ImageUrl");
        final String des = bn.getString("Description");

        final double length = 11.7;
        final double width = 16.5;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String len = String.valueOf(length);
                String wid = String.valueOf(width);
                String deliveryDate = dDate.getText().toString();
                String getType = spinner.getSelectedItem().toString();


                long newID = dbHandler.addCreationDetails(username, c_type, len, wid, url, des, qty, price, getType, deliveryDate);
                if (newID > 0){
                    Toast.makeText(Leaflet_Clone.this, "Creation added Successfull", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Leaflet_Clone.this, "Creation not added", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
