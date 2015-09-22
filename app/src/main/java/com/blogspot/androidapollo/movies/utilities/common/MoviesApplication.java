package com.blogspot.androidapollo.movies.utilities.common;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by ankur on 16/09/15.
 */
public class MoviesApplication extends Application {

    private static MoviesApplication instance;
    private static Context context;

    public MoviesApplication() {};

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public Context getContext(){
        return context;
    }

    public static MoviesApplication getInstance(){
        if (instance == null){
            instance = new MoviesApplication();
        }
        return instance;
    }

    public void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void loadImage(String imgPath, ImageView view){
        Picasso.with(getContext()).load("http://image.tmdb.org/t/p/" + MoviesUtil.getPosterWidth() + imgPath).into(view);
    }
}
