## Create an Android application to show the demo of displaying text with justifying elements, changing text colors ,fonts etc. 

### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/demo_text"
        android:textSize="18sp"
        android:textColor="@android:color/holo_blue_dark"
        android:fontFamily="serif"
        android:lineSpacingExtra="8dp"
        android:layout_marginBottom="20dp"
        android:justificationMode="inter_word" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/change_text_button"
        android:id="@+id/buttonChangeText"
        android:layout_gravity="center"
        android:layout_marginTop="20dp"/>
</androidx.appcompat.widget.LinearLayoutCompat>
```

### MainActivity.java
```java
package com.example.q1; //q1 is the project name

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
```

### strings.xml
```xml
<resources>
    <string name="app_name">Text Demo</string>
    <string name="demo_text">
        This is a demo of text properties like justification, font styles, and colors in Android.
        TextView provides multiple ways to customize the appearance of the text displayed.
    </string>
    <string name="change_text_button">Change Text</string>
    <string name="changed_text">Hello, World! Text properties have been changed successfully.</string>
</resources>
```

### AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Q1"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

---
