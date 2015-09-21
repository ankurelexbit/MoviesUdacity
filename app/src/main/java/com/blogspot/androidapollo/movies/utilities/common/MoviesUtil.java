package com.blogspot.androidapollo.movies.utilities.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ankur on 20/09/15.
 */
public class MoviesUtil {

    public static String getPosterWidth(){
        String width = "w185";
        int widthPixel = MoviesApplication.getInstance().getContext().getResources().getDisplayMetrics().widthPixels;
        if (widthPixel <= 185) {
            width = "w154";
        } else if (widthPixel >= 500) {
            width = "w500";
        }
        return width;
    }

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date).toString();
    }

    public static String getPastDate(int numberOfDays){
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date date = new Date(System.currentTimeMillis() - (numberOfDays * DAY_IN_MS));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date).toString();
    }
}
