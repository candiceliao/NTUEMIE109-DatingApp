package com.example.myapplication.member.dao;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myapplication.member.entity.MemberEntity;


@Dao
public interface MemberDao {

//    @Query("SELECT * FROM memberentity")
//    List<Member> getAllUsers();

    @Insert
    void insert(MemberEntity... memberEntities);

    @Update
    void update(MemberEntity... memberEntities);

    @Delete
    void delete(MemberEntity... memberEntities);

}
