package com.example.mad_project.Customer_Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_project.Database.DBHandler;
import com.example.mad_project.R;

import static com.example.mad_project.Notification.CHANNEL_ID;

public class Banner_Clone extends AppCompatActivity {

    TextView full;
    EditText delDate;
    Button add;

    DBHandler dbHandler;

    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner__clone);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerGetingType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.customer_creation_get, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        full = findViewById(R.id.textViewBannerTotal);
        delDate = findViewById(R.id.editTextCreDelDate);
        add = findViewById(R.id.buttonCreationAdd);

        dbHandler = new DBHandler(getApplicationContext());

        Bundle bn = getIntent().getExtras();
        final String username = bn.getString("Name");
        final String c_type = bn.getString("creation_type");
        final String amount = bn.getString("Price");
        final String length = bn.getString("Length");
        final String width = bn.getString("Width");
        final String imageUrl = bn.getString("Url");
        final String description = bn.getString("Description");
        final String quantity = bn.getString("Quantity");

        full.setText("Rs."+String.valueOf(amount));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String deliveryDate = delDate.getText().toString();
                String getType = spinner.getSelectedItem().toString();

                long newID = dbHandler.addCreationDetails(username, c_type, length, width, imageUrl, description, quantity, "Rs."+amount, getType, deliveryDate);
                if (newID > 0){
                    Toast.makeText(Banner_Clone.this, "Creation added Successfull", Toast.LENGTH_SHORT).show();

                    String full_total = full.getText().toString();

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Banner_Clone.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                            .setContentTitle("RUSH Advertising Notification")
                            .setContentText("Your creations' total amount is " + full_total)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE);

                    notificationManagerCompat.notify(1, builder.build());

                }
                else {
                    Toast.makeText(Banner_Clone.this, "Creation not added", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}