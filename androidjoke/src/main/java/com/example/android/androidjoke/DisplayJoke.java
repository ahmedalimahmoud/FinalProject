package com.example.android.androidjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke=getIntent().getExtras().getString("joke");
        TextView textView=(TextView)findViewById(R.id.joke);
        textView.setText(joke);
    }
}
