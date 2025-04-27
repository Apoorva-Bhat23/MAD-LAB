package com.example.digitrans;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the filter options in a PopupMenu when the button is clicked
                showPopupMenu(v);
            }
        });
    }

    // Method to show the PopupMenu
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, popupMenu.getMenu());

        // Set click listener for each menu item
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                // Handle the actions when each menu item is clicked
                if (id == R.id.search_keywords) {
                    Toast.makeText(MainActivity.this, "Search Keywords clicked", Toast.LENGTH_SHORT).show();
                    // Add logic for search functionality here
                    return true;
                } else if (id == R.id.highlight) {
                    Toast.makeText(MainActivity.this, "Highlight clicked", Toast.LENGTH_SHORT).show();
                    // Add logic for highlighting text here
                    return true;
                } else if (id == R.id.sort) {
                    Toast.makeText(MainActivity.this, "Sort clicked", Toast.LENGTH_SHORT).show();
                    // Add logic for sorting content here
                    return true;
                }

                return false;
            }
        });

        // Show the PopupMenu
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu, menu);  // Make sure filter_menu.xml is in the res/menu folder
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_keywords) {
            Toast.makeText(this, "Search Keywords", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.highlight) {
            Toast.makeText(this, "Highlight", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.sort) {
            Toast.makeText(this, "Sort", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
