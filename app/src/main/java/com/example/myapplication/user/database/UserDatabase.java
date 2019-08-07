package com.example.myapplication.user.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.myapplication.user.dao.UserDao;
import com.example.myapplication.user.entity.User;


@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DB_NAME = "UserDatabase.db";
    private static volatile UserDatabase instance;

    public static UserDatabase getInstance(Context context) {

        if (instance == null) {
            instance = create(context);
        }

        return instance;
    }

    private static UserDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                UserDatabase.class,
                DB_NAME).build();
    }


    public abstract UserDao getUserDao();

//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            // 因為資料表沒改變，所以這裡甚麼也沒做
//        }
//    };
//
//    database = Room.databaseBuilder(context.getApplicationContext(),
//    UsersDatabase.class, "Sample.db")
//                 .addMigrations(MIGRATION_1_2)
//                 .build();
}
