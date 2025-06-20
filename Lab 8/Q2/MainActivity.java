package com.example.grocery;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerItems;
    private Button btnAddItem;
    private TextView tvTotalCost;
    private MyDatabaseHelper dbHelper;

    private HashMap<String, Integer> groceryItems; // Stores item names and costs
    private String selectedItem; // Stores selected item name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerItems = findViewById(R.id.spinnerItems);
        btnAddItem = findViewById(R.id.btnAddItem);
        tvTotalCost = findViewById(R.id.tvTotalCost);

        dbHelper = new MyDatabaseHelper(this);

        // Add grocery items (predefined items)
        groceryItems = new HashMap<>();
        groceryItems.put("Apple", 50);
        groceryItems.put("Banana", 30);
        groceryItems.put("Milk", 60);
        groceryItems.put("Eggs", 100);
        groceryItems.put("Rice", 80);

        // Populate spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groceryItems.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItems.setAdapter(adapter);

        // Handle spinner selection
        spinnerItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Handle "Add Item" button click
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cost = groceryItems.get(selectedItem); // Get cost of selected item
                dbHelper.insertItem(selectedItem, cost); // Add item to database
                updateTotalCost(); // Update total cost
            }
        });

        // Display initial total cost
        updateTotalCost();
    }

    // Update total cost from database
    private void updateTotalCost() {
        int total = dbHelper.getTotalCost();
        tvTotalCost.setText("Total Cost: ₹" + total);
    }
}
