package com.example.modify;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, emailInput, updateNameInput, deleteEmailInput;
    Button insertBtn, updateBtn, deleteBtn, viewBtn;
    TextView resultView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        updateNameInput = findViewById(R.id.updateNameInput);
        deleteEmailInput = findViewById(R.id.deleteEmailInput);
        insertBtn = findViewById(R.id.insertBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        viewBtn = findViewById(R.id.viewBtn);
        resultView = findViewById(R.id.resultView);

        // Insert User
        insertBtn.setOnClickListener(view -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            if (dbHelper.insertUser(name, email)) {
                Toast.makeText(MainActivity.this, "User Inserted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Update User
        updateBtn.setOnClickListener(view -> {
            String email = emailInput.getText().toString();
            String newName = updateNameInput.getText().toString();
            if (dbHelper.updateUser(email, newName)) {
                Toast.makeText(MainActivity.this, "User Updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete User
        deleteBtn.setOnClickListener(view -> {
            String email = deleteEmailInput.getText().toString();
            if (dbHelper.deleteUser(email)) {
                Toast.makeText(MainActivity.this, "User Deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // View Users
        viewBtn.setOnClickListener(view -> {
            Cursor cursor = dbHelper.getAllUsers();
            StringBuilder result = new StringBuilder();
            if (cursor.moveToFirst()) {
                do {
                    result.append("ID: ").append(cursor.getInt(0))
                            .append(", Name: ").append(cursor.getString(1))
                            .append(", Email: ").append(cursor.getString(2)).append("\n");
                } while (cursor.moveToNext());
            }
            cursor.close();
            resultView.setText(result.toString());
        });
    }
}
