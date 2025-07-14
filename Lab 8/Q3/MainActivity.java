package com.example.moviereview;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editName, editYear, editRating, editReview;
    Button btnSave;
    ListView listViewMovies;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editYear = findViewById(R.id.editYear);
        editRating = findViewById(R.id.editRating);
        editReview = findViewById(R.id.editReview);
        btnSave = findViewById(R.id.btnSave);
        listViewMovies = findViewById(R.id.listViewMovies);
        dbHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString();
            int year = Integer.parseInt(editYear.getText().toString());
            int rating = Integer.parseInt(editRating.getText().toString());
            String review = editReview.getText().toString();

            if (dbHelper.addMovie(name, year, rating, review)) {
                Toast.makeText(MainActivity.this, "Review Saved!", Toast.LENGTH_SHORT).show();
                loadMovies();
            } else {
                Toast.makeText(MainActivity.this, "Error Saving Review!", Toast.LENGTH_SHORT).show();
            }
        });

        listViewMovies.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMovie = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
            intent.putExtra("movieName", selectedMovie);
            startActivity(intent);
        });

        loadMovies();
    }

    private void loadMovies() {
        List<String> movies = dbHelper.getAllMovies();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movies);
        listViewMovies.setAdapter(adapter);
    }
}
