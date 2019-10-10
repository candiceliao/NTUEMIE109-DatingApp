package com.example.myapplication.user.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "userGender")
    private String userGender;

    @ColumnInfo(name = "userCountry")
    private String userCountry;

    @ColumnInfo(name = "userInterest")
    private String userInterest;

    @ColumnInfo(name = "userMask")
    private int userMask;

    @ColumnInfo(name = "userFriendCount")
    private int userFriendCount;

    @ColumnInfo(name = "userState") //是否在線上，用Y與N表示
    private String userState;

    @ColumnInfo(name = "userNumberInf")
    private String userNumberInf;

    public User(String userName) {
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public int getUserMask() {
        return userMask;
    }

    public void setUserMask(int userMask) {
        this.userMask = userMask;
    }

    public int getUserFriendCount() {
        return userFriendCount;
    }

    public void setUserFriendCount(int userFriendCount) {
        this.userFriendCount = userFriendCount;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserNumberInf() {
        return userNumberInf;
    }

    public void setUserNumberInf(String userNumberInf) {
        this.userNumberInf = userNumberInf;
    }
}

