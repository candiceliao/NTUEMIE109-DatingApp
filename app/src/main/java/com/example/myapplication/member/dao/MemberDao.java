package com.example.myapplication.member.dao;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.myapplication.member.entity.Member;


@Dao
public interface MemberDao {

//    @Query("SELECT * FROM memberentity")
//    List<Member> getAllUsers();

    @Insert
    void insert(Member... member);

    @Update
    void update(Member... member);

    @Delete
    void delete(Member... member);

}
