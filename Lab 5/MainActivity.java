package com.example.q1_vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerVehicleType;
    private EditText editVehicleNumber, editRcNumber;
    private Button buttonSubmit;
    private String selectedVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerVehicleType = findViewById(R.id.spinner_vehicle_type);
        editVehicleNumber = findViewById(R.id.edit_vehicle_number);
        editRcNumber = findViewById(R.id.edit_rc_number);
        buttonSubmit = findViewById(R.id.button_submit);

        // Spinner data
        String[] vehicleTypes = {"Car", "Bike", "Truck", "Bus"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vehicleTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(adapter);

        spinnerVehicleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVehicleType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedVehicleType = "Car";
            }
        });

        buttonSubmit.setOnClickListener(v -> {
            String vehicleNumber = editVehicleNumber.getText().toString();
            String rcNumber = editRcNumber.getText().toString();

            if (vehicleNumber.isEmpty() || rcNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                return;
            }

            // Pass data to the next activity
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("vehicleType", selectedVehicleType);
            intent.putExtra("vehicleNumber", vehicleNumber);
            intent.putExtra("rcNumber", rcNumber);
            startActivity(intent);
        });
    }
}
