package com.nammamela.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nammamela.data.model.FanComment;
import com.nammamela.data.model.Seat;

@Database(entities = {Seat.class, FanComment.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract SeatDao seatDao();
    public abstract FanCommentDao fanCommentDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "namma_mela_db"
            ).allowMainThreadQueries().build();
        }
        return instance;
    }
}
