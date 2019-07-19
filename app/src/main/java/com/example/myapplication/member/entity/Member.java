package com.example.myapplication.member.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Member {

    public static final String TABLE_NAME = "member";

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "nick_name")
    private String nickName;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "interest")
    private String interest;

    @ColumnInfo(name = "mask_number")
    private int mask_number;

    @ColumnInfo(name = "friend_number")
    private int friend_number;

    @ColumnInfo(name = "state") //是否在線上，用Y與N表示
    private String state;

    @ColumnInfo(name = "number_inf")
    private  String number_inf;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String firstName) {
        this.nickName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public int getMask_number() {
        return mask_number;
    }

    public void setMask_number(int mask_number) {
        this.mask_number = mask_number;
    }

    public int getFriend_number() {
        return friend_number;
    }

    public void setFriend_number(int friend_number) {
        this.friend_number = friend_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNumber_inf() {
        return number_inf;
    }

    public void setNumber_inf(String number_inf) {
        this.number_inf = number_inf;
    }
}