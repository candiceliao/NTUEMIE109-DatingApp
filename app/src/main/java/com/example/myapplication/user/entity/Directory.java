package com.example.myapplication.user.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "directory")
public class Directory {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "userFriend")
    private int userFriend;

    @ColumnInfo(name = "Dialogue")
    private String Dialogue;

    @ColumnInfo(name = "userNumberInf")
    private String userNumberInf;
//
//    public User(String userName) {
//        this.userName = userName;
//    }


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

    public int getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(int userFriend) {
        this.userFriend = userFriend;
    }

    public String getDialogue() {
        return Dialogue;
    }

    public void setDialogue(String Dialogue) {
        this.Dialogue = Dialogue;
    }

    public String getUserNumberInf() {
        return userNumberInf;
    }

    public void setUserNumberInf(String userNumberInf) {
        this.userNumberInf = userNumberInf;
    }
}
