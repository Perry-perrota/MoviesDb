package com.keyname.moviesdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.splashPageEditText) EditText mLocation;
    @BindView(R.id.findMovieButton) Button mFindMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindMovie.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view==mFindMovie) {
            String location = mLocation.getText().toString();
            Log.d(TAG, location);
            Intent intent = new Intent(MainActivity.this, Homepage.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}

