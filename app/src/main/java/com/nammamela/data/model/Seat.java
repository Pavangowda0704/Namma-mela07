package com.nammamela.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "seats")
public class Seat {
    @PrimaryKey
    public int seatNumber;
    public boolean isBooked;
    public String bookedBy;

    public Seat(int seatNumber, boolean isBooked, String bookedBy) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.bookedBy = bookedBy;
    }
}
