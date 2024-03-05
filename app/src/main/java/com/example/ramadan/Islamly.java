package com.example.ramadan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Islamly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islamly); // Inflate activity_islamly.xml instead of activity_main.xml

        // Get reference to the ImageButton
        ImageButton urlButton = findViewById(R.id.urlbutton);

        // Set OnClickListener to open URL when the button is clicked
        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL you want to open
                String url = "https://play.google.com/store/apps/details?id=com.islamicly.app";

                // Create an Intent with ACTION_VIEW and the URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Check if there's an app available to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Start the activity (open URL)
                    startActivity(intent);
                } else {
                    // Handle the case where no app is available to handle the URL
                    Toast.makeText(Islamly.this, "No app available to handle this action", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
