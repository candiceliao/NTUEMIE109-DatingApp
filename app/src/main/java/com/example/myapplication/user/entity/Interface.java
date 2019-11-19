package com.example.myapplication.user.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "interface")
public class Interface {
    @PrimaryKey
    @ColumnInfo(name = "userNumberInf")
    private  String userNumberInf;

    @ColumnInfo(name = "Picture")
    private  String Picture;


    public String getUserNumberInf() {
        return userNumberInf;
    }

    public void setUserNumberInf(String userNumberInf) {
        this.userNumberInf = userNumberInf;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

}
