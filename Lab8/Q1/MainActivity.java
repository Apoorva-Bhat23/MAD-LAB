package com.example.task_manager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTaskName, etDueDate;
    Spinner spPriority;
    Button btnAddTask;
    ListView lvTasks;
    TaskDatabaseHelper dbHelper;
    ArrayList<String> taskList;
    ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaskName = findViewById(R.id.etTaskName);
        etDueDate = findViewById(R.id.etDueDate);
        spPriority = findViewById(R.id.spPriority);
        btnAddTask = findViewById(R.id.btnAddTask);
        lvTasks = findViewById(R.id.lvTasks);

        dbHelper = new TaskDatabaseHelper(this);
        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        lvTasks.setAdapter(taskAdapter);

        loadTasks();

        btnAddTask.setOnClickListener(v -> {
            String name = etTaskName.getText().toString();
            String date = etDueDate.getText().toString();
            String priority = spPriority.getSelectedItem().toString();

            if (!name.isEmpty()) {
                dbHelper.insertTask(name, date, priority);
                loadTasks();
                etTaskName.setText("");
                etDueDate.setText("");
                Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Enter Task Name", Toast.LENGTH_SHORT).show();
            }
        });

        lvTasks.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(this, "Long press to delete", Toast.LENGTH_SHORT).show();
        });

        lvTasks.setOnItemLongClickListener((adapterView, view, i, l) -> {
            dbHelper.deleteTask(i + 1);
            loadTasks();
            Toast.makeText(this, "Task Deleted", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    private void loadTasks() {
        taskList.clear();
        Cursor cursor = dbHelper.getAllTasks();
        while (cursor.moveToNext()) {
            taskList.add(cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getString(3));
        }
        cursor.close();
        taskAdapter.notifyDataSetChanged();
    }
}
