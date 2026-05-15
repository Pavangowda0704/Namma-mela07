package com.nammamela.adapter;

import com.nammamela.data.model.Seat;

public class SeatAdapter {
    public interface SeatClickListener {
        void onSeatClicked(Seat seat);
    }
}
