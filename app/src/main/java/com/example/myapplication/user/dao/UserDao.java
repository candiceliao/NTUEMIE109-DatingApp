package com.example.myapplication.user.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myapplication.user.entity.User;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert
    void insert(User... member);

    @Update
    void update(User... member);

    @Delete
    void delete(User... member);

}
