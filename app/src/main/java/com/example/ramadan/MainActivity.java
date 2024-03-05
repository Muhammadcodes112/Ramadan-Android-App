package com.example.ramadan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter adapter;
    private Button nextButton;
    private int[] images = {R.drawable.image1, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.islamly};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyReceiver.setAlarm(this);

        viewPager = findViewById(R.id.viewPager);
        adapter = new SliderAdapter(this, images);
        viewPager.setAdapter(adapter);

        // Set up your buttons for navigation if needed
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem > 0) {
                    viewPager.setCurrentItem(currentItem - 1);
                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem < adapter.getCount() - 1) {
                    viewPager.setCurrentItem(currentItem + 1);
                }
            }
        });

        // Set OnClickListener for the "Next Page" button
        Button nextPageButton = findViewById(R.id.next);
        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the action when the "Next Page" button is clicked
                Intent nextPageIntent = new Intent(MainActivity.this, Islamly.class);
                startActivity(nextPageIntent);


                Intent in = new Intent(MainActivity.this, MyReceiver.class);
                // Send broadcast
                sendBroadcast(in);
            }
        });
    }
}