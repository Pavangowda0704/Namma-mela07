package com.nammamela.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.nammamela.R;
import com.nammamela.adapter.SeatAdapter;
import com.nammamela.data.db.AppDatabase;
import com.nammamela.data.model.Seat;

import java.util.List;

public class SeatMapActivity extends AppCompatActivity implements SeatAdapter.SeatClickListener {

    private GridLayout seatGrid;
    private TextView tvAvailable;
    private AppDatabase db;
    private static final int TOTAL_SEATS = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_map);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("🪑 ಆಸನ ನಕ್ಷೆ");
        }

        seatGrid = findViewById(R.id.seatGrid);
        tvAvailable = findViewById(R.id.tvAvailable);
        db = AppDatabase.getInstance(this);

        Button btnReset = findViewById(R.id.btnResetSeats);
        btnReset.setOnClickListener(v -> resetSeats());

        initSeats();
        renderSeats();
    }

    private void initSeats() {
        List<Seat> existing = db.seatDao().getAllSeats();
        if (existing.isEmpty()) {
            for (int i = 1; i <= TOTAL_SEATS; i++) {
                db.seatDao().insertSeat(new Seat(i, false, ""));
            }
        }
    }

    private void renderSeats() {
        seatGrid.removeAllViews();
        List<Seat> seats = db.seatDao().getAllSeats();
        int available = db.seatDao().getAvailableCount();
        tvAvailable.setText("ಲಭ್ಯ ಆಸನಗಳು: " + available + " / " + TOTAL_SEATS);

        for (Seat seat : seats) {
            View seatView = LayoutInflater.from(this).inflate(R.layout.item_seat, seatGrid, false);
            TextView tvSeat = seatView.findViewById(R.id.tvSeatNumber);
            tvSeat.setText(String.valueOf(seat.seatNumber));

            if (seat.isBooked) {
                seatView.setBackgroundResource(R.drawable.bg_seat_booked);
                tvSeat.setTextColor(getResources().getColor(android.R.color.white, null));
            } else {
                seatView.setBackgroundResource(R.drawable.bg_seat_available);
                tvSeat.setTextColor(getResources().getColor(android.R.color.white, null));
            }

            seatView.setOnClickListener(v -> onSeatClicked(seat));
            seatGrid.addView(seatView);
        }
    }

    @Override
    public void onSeatClicked(Seat seat) {
        if (seat.isBooked) {
            Toast.makeText(this, "ಆಸನ " + seat.seatNumber + " - " + seat.bookedBy + " ಅವರಿಂದ ಕಾಯ್ದಿರಿಸಲಾಗಿದೆ", Toast.LENGTH_SHORT).show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_book_seat, null);
        builder.setView(dialogView);

        TextView tvSeatInfo = dialogView.findViewById(R.id.tvSeatInfo);
        EditText etName = dialogView.findViewById(R.id.etBookingName);
        tvSeatInfo.setText("ಆಸನ " + seat.seatNumber + " ಕಾಯ್ದಿರಿಸಿ");

        builder.setTitle("🎟 ಟಿಕೆಟ್ ಬುಕ್ ಮಾಡಿ")
                .setPositiveButton("ಬುಕ್ ಮಾಡಿ", (dialog, which) -> {
                    String name = etName.getText().toString().trim();
                    if (name.isEmpty()) name = "ಪ್ರೇಕ್ಷಕ";
                    seat.isBooked = true;
                    seat.bookedBy = name;
                    db.seatDao().updateSeat(seat);
                    renderSeats();
                    Toast.makeText(this, "✅ " + name + " ಗಾಗಿ ಆಸನ " + seat.seatNumber + " ಬುಕ್ ಆಯ್ತು!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("ರದ್ದು", null)
                .show();
    }

    private void resetSeats() {
        new AlertDialog.Builder(this)
                .setTitle("ಎಲ್ಲ ಬುಕಿಂಗ್ ರಿಸೆಟ್ ಮಾಡಿ?")
                .setMessage("ಎಲ್ಲ ಆಸನ ಬುಕಿಂಗ್ ಅಳಿಸಲಾಗುವುದು.")
                .setPositiveButton("ಹೌದು", (d, w) -> {
                    db.seatDao().deleteAll();
                    initSeats();
                    renderSeats();
                })
                .setNegativeButton("ಇಲ್ಲ", null)
                .show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
