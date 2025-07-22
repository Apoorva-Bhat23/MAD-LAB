mmmmmmmmmmmpackage com.example.moviereview;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {
    TextView txtDetails;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        txtDetails = findViewById(R.id.txtDetails);
        dbHelper = new DatabaseHelper(this);

        String movieName = getIntent().getStringExtra("movieName");
        displayMovieDetails(movieName);
    }

    private void displayMovieDetails(String movieName) {
        Cursor cursor = dbHelper.getMovieDetails(movieName);
        if (cursor.moveToFirst()) {
            String details = "Movie Name: " + cursor.getString(1) + "\n" +
                    "Year: " + cursor.getInt(2) + "\n" +
                    "Rating: " + cursor.getInt(3) + "/5\n" +
                    "Review: " + cursor.getString(4);
            txtDetails.setText(details);
        }
        cursor.close();
    }
}
