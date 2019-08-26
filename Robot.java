package com.example.myapplication.user.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "robot")
public class Robot {
    @ColumnInfo(name = "presetMessage")
    private  String presetMessage;
}
