package com.example.myapplication.user.entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "score")
public class Score {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "userFriend")
    private int userFriend;

    @ColumnInfo(name = "scoreSend")
    private int scoreSend;

    @ColumnInfo(name = "scoreReceive")
    private int scoreReceive;

    @ColumnInfo(name = "Average")
    private int Average;

    @ColumnInfo(name = "Light")
    private  String Light;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(int userFriend) {
        this.userFriend = userFriend;
    }

    public int getScoreSend() {
        return scoreSend;
    }

    public void setScoreSend(int scoreSend) {
        this.scoreSend = scoreSend;
    }

    public int getScoreReceive() {
        return scoreReceive;
    }

    public void setScoreReceive(int scoreReceive) {
        this.scoreReceive = scoreReceive;
    }

    public int getAverage() {
        return Average;
    }

    public void setAverage(int Average) {
        this.Average = Average;
    }

    public String getLight() {
        return Light;
    }

    public void setLight(String Light) {
        this.Light = Light;
    }
}
