package com.example.myapplication.user.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mask")
public class Mask {
    @PrimaryKey
    private int userMask;

    @ColumnInfo(name = "Picture")
    private  String Picture;


    public int getUserMask() {
        return userMask;
    }

    public void setUserMask(int userMask) {
        this.userMask = userMask;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

}
