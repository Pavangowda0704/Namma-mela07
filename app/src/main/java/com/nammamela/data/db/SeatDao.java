package com.nammamela.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.nammamela.data.model.Seat;

import java.util.List;

@Dao
public interface SeatDao {
    @Query("SELECT * FROM seats ORDER BY seatNumber ASC")
    List<Seat> getAllSeats();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSeat(Seat seat);

    @Update
    void updateSeat(Seat seat);

    @Query("SELECT COUNT(*) FROM seats WHERE isBooked = 0")
    int getAvailableCount();

    @Query("DELETE FROM seats")
    void deleteAll();
}
