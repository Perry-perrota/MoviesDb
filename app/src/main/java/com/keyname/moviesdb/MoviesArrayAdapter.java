package com.keyname.moviesdb;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MoviesArrayAdapter extends ArrayAdapter {
    public Context mContext;
    public String[] mMovies;
    public String[] mGenres;
    public MoviesArrayAdapter(Context mContext,int resource,String[] mMovies,String[] mGenres){
        super(mContext,resource);
        this.mContext=mContext;
        this.mGenres=mGenres;
        this.mMovies=mMovies;

    }
    @Override
    public Object getItem(int position){
        String movies=mMovies[position];
        String genres=mGenres[position];
        return String.format("%s \n is a type of genre known as %s",movies,genres);
    }
    @Override
    public int getCount(){
        return mMovies.length;
    }

}
