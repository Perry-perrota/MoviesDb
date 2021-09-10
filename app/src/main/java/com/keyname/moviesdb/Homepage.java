package com.keyname.moviesdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Homepage extends AppCompatActivity {
    public static final String TAG=Homepage.class.getSimpleName();
@BindView(R.id.homepageListView) ListView moviesListView;
@BindView(R.id.homepageTextView) TextView movieSearchTextView;

private String[] movies=new String[]{
        "toy story","terminator","riddick","Im legend","money heist","toy story","terminator","riddick","Im legend","money heist", "toy story","terminator","riddick","Im legend","money heist","toy story","terminator","riddick","Im legend","money heist"
};
private String[] genres=new String[]{"animation","action","thriller","epic","exciting","animation","action","thriller","epic","exciting","animation","action","thriller","epic","exciting","animation","action","thriller","epic","exciting"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);


        MoviesArrayAdapter adapter=new MoviesArrayAdapter(this, android.R.layout.simple_list_item_1,movies,genres);
        moviesListView.setAdapter(adapter);
        
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String movie=((TextView)view).getText().toString();
                Log.v(TAG,"on click item listener");
                Toast.makeText(Homepage.this, movie, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent=getIntent();
        String location=intent.getStringExtra("location");
        movieSearchTextView.setText("matching close to "+ location);
        Log.d(TAG,"On create method executes properly");

    }
}