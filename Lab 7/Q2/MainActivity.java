package com.example.mymenu;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare ImageView to display the selected image
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the icon ImageView (which will trigger the menu)
        ImageView iconImage = findViewById(R.id.iconImage);
        // Initialize the ImageView that will display selected images
        imageView = findViewById(R.id.displayImage);

        // Set a click listener for the icon ImageView
        iconImage.setOnClickListener(view -> {
            // Step 1: Instantiate PopupMenu and link it to the iconImage
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);

            // Step 2: Inflate the menu resource
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.my_menu, popupMenu.getMenu());

            // Step 3: Handle the menu item selection using if-else
            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.image_one) {
                    // Show Image 1
                    imageView.setImageResource(R.drawable.icon1); // Replace with your actual drawable resource
                    Toast.makeText(MainActivity.this, "Image - 1 Selected", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.image_two) {
                    // Show Image 2
                    imageView.setImageResource(R.drawable.icon2); // Replace with your actual drawable resource
                    Toast.makeText(MainActivity.this, "Image - 2 Selected", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false; // Return false if no item matches
            });

            // Step 4: Show the PopupMenu
            popupMenu.show();
        });
    }
}
