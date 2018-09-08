package com.nanodegree.android.javajokeslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TheJoker extends AppCompatActivity {

    public static final String THE_JOKE = "theJoke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_joker_display);

        //REQUIRED: receive joke from Intent and set as string variable.
        String theJoke = getIntent().getStringExtra(THE_JOKE);

        //declare and set TextView text to display joke.
        TextView jokerTextView = findViewById(R.id.jokerTv);
        jokerTextView.setText(theJoke);

    }
}
