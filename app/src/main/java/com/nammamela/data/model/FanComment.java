package com.nammamela.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fan_comments")
public class FanComment {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String fanName;
    public String comment;
    public String timestamp;

    public FanComment(String fanName, String comment, String timestamp) {
        this.fanName = fanName;
        this.comment = comment;
        this.timestamp = timestamp;
    }
}
