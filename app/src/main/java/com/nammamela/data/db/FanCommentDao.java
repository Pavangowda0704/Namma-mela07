package com.nammamela.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.nammamela.data.model.FanComment;

import java.util.List;

@Dao
public interface FanCommentDao {
    @Query("SELECT * FROM fan_comments ORDER BY id DESC")
    List<FanComment> getAllComments();

    @Insert
    void insertComment(FanComment comment);

    @Query("DELETE FROM fan_comments")
    void deleteAll();
}
