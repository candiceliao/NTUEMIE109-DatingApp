package com.example.myapplication.member.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.myapplication.member.dao.MemberDao;
import com.example.myapplication.member.entity.Member;


@Database(entities = {Member.class}, version = 1, exportSchema = false)
public abstract class MemberDatabase extends RoomDatabase {

    private static final String DB_NAME = "MemberDatabase.db";
    private static volatile MemberDatabase instance;

    public static MemberDatabase getInstance(Context context) {

        if(instance == null) {
            instance = create(context);
        }

        return instance;
    }

    private static MemberDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                MemberDatabase.class,
                DB_NAME).build();
    }


    public abstract MemberDao getMemberDao();
}
