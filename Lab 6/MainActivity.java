package com.example.fitness;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_workout_plans) {
            Toast.makeText(this, "Workout Plans", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_trainers) {
            Toast.makeText(this, "Trainers", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_membership) {
            Toast.makeText(this, "Membership", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_contact) {
            Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_homepage) {
            Toast.makeText(this, "Homepage", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
