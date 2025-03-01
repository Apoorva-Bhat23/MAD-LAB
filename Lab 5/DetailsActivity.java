package com.example.q1_vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {

    private TextView textDetails;
    private Button buttonConfirm, buttonEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textDetails = findViewById(R.id.text_details);
        buttonConfirm = findViewById(R.id.button_confirm);
        buttonEdit = findViewById(R.id.button_edit);

        // Retrieve data from intent
        Intent intent = getIntent();
        String vehicleType = intent.getStringExtra("vehicleType");
        String vehicleNumber = intent.getStringExtra("vehicleNumber");
        String rcNumber = intent.getStringExtra("rcNumber");

        // Display the details
        String details = "Vehicle Type: " + vehicleType + "\n"
                + "Vehicle Number: " + vehicleNumber + "\n"
                + "RC Number: " + rcNumber;
        textDetails.setText(details);

        // Confirm action
        buttonConfirm.setOnClickListener(v -> {
            int serialNumber = new Random().nextInt(9000) + 1000; // Generate 4-digit random number
            Toast.makeText(DetailsActivity.this, "Parking Confirmed! Serial No: " + serialNumber, Toast.LENGTH_LONG).show();
        });

        // Edit action (return to main screen)
        buttonEdit.setOnClickListener(v -> {
            Intent editIntent = new Intent(DetailsActivity.this, MainActivity.class);
            startActivity(editIntent);
            finish();
        });
    }
}
