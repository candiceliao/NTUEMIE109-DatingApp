package com.example.myapplication.user.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "interface")
public class Interface {
    @PrimaryKey
    private String userNumberInf;

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
