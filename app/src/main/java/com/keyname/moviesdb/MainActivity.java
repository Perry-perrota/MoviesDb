package com.keyname.moviesdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindMovie;
    private EditText mlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlocation=(EditText)findViewById(R.id.splashPageEditText);
        mFindMovie=(Button)findViewById(R.id.findMovieButton);
        mFindMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location=mlocation.getText().toString();
                Log.d(TAG,location);
                Intent intent= new Intent(MainActivity.this,Homepage.class);
                intent.putExtra("location",location);
                startActivity(intent);

            }
        });
    }
}