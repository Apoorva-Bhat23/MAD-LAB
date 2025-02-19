## Develop a "Test App" that includes a layout with a Button and a ToggleButton. When each button is clicked, a custom Toast message should be displayed with different images as their content.

### Activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:gravity="center">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click Me"
        android:padding="10dp"
        android:layout_marginBottom="16dp" />

    <ToggleButton
        android:id="@+id/toggleButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOn="Toggle On"
        android:textOff="Toggle Off"
        android:padding="10dp" />
</LinearLayout>

### Mainactivity.java
```java
package com.example.q1_test_toast;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    // Array of images to cycle through when ToggleButton is ON
    private int[] imageArray = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3};
    private int imageIndex = 0; // Keeps track of which image to show next
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
    ToggleButton toggleButton = findViewById(R.id.toggleButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check ToggleButton state
                if (toggleButton.isChecked()) {
                    // ToggleButton is ON: show a new image each time
                    showCustomToast(imageArray[imageIndex]);
                    imageIndex = (imageIndex + 1) % imageArray.length; // Cycle through images
                } else {
                    // ToggleButton is OFF: always show the first image
                    showCustomToast(imageArray[imageIndex - 1]);
                }
            }
        });
    }
    private void showCustomToast(int imageResId) {
        // Create a Toast with a custom layout
        Toast toast = new Toast(getApplicationContext());
        // Create an ImageView for the image
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(imageResId);
        // Add the ImageView to the Toast layout
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);
        // Set Toast properties
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
```
