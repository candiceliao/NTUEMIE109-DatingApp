package com.example.myapplication.robot;
//import android.arch.persistence.room.ColumnInfo;
//import android.arch.persistence.room.Entity;
//import android.arch.persistence.room.PrimaryKey;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "robot")
public class Robot {
    @ColumnInfo(name = "presetMessage")
    private  String presetMessage;
}
