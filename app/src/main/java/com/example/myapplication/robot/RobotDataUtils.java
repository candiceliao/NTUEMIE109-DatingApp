package com.example.myapplication.robot;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RobotDataUtils {
    @SuppressLint("SimpleDateFormat")
    public static String fromDateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return df.format(date);
    }
}
