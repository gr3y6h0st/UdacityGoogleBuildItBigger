package com.nanodegree.android.javajokeslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TheJoker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker_display);

        String theJoke = getIntent().getStringExtra("theJoke");

        TextView jokerTextView = findViewById(R.id.jokerTv);

        jokerTextView.setText(theJoke);

    }
}
