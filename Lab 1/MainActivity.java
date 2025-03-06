package com.example.q1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button changeTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        textView = findViewById(R.id.textView);
        changeTextButton = findViewById(R.id.buttonChangeText);

        // Set up button click listener to change the text dynamically
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the TextView with new text from strings.xml
                textView.setText(R.string.changed_text);  // Use the string from strings.xml
                textView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));  // Change text color
                textView.setTextSize(20);  // Change text size
                textView.setTypeface(null, android.graphics.Typeface.BOLD);  // Change text to bold
            }
        });
    }
}
