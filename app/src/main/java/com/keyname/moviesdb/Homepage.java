package com.keyname.moviesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {
private TextView movieSearchTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        movieSearchTextView=(TextView) findViewById(R.id.homepageTextView);
        Intent intent=getIntent();
        String location=intent.getStringExtra("location");
        movieSearchTextView.setText("matching close to "+ location);
    }
}