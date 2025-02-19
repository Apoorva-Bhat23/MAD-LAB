## Q2: Find the “hello word” text in the XML document and modify the text. 
### activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_text"
        android:textSize="18sp"
        android:textColor="@android:color/black"
        android:layout_centerInParent="true" />

</androidx.appcompat.widget.LinearLayoutCompat>
```

### MainActivity.java
```java
package com.example.q2;  // Make sure this matches your package name

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Link the layout file
    }
}
```

### strings.xml
```xml
<resources>
    <string name="app_name">q2</string>
    <string name="hello_text">Hello, welcome to my Android app!</string> 
</resources>
```
