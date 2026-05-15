package com.nammamela.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nammamela.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvPlayName, tvDuration, tvVenue, tvDate;
    private ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPlayName = findViewById(R.id.tvPlayName);
        tvDuration = findViewById(R.id.tvDuration);
        tvVenue = findViewById(R.id.tvVenue);
        tvDate = findViewById(R.id.tvDate);
        ivPoster = findViewById(R.id.ivPoster);

        Button btnCast = findViewById(R.id.btnCast);
        Button btnSeats = findViewById(R.id.btnSeats);
        Button btnFanWall = findViewById(R.id.btnFanWall);
        Button btnManager = findViewById(R.id.btnManager);

        btnCast.setOnClickListener(v -> startActivity(new Intent(this, CastActivity.class)));
        btnSeats.setOnClickListener(v -> startActivity(new Intent(this, SeatMapActivity.class)));
        btnFanWall.setOnClickListener(v -> startActivity(new Intent(this, FanWallActivity.class)));
        btnManager.setOnClickListener(v -> startActivity(new Intent(this, ManagerActivity.class)));

        loadPlayDetails();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPlayDetails();
    }

    private void loadPlayDetails() {
        SharedPreferences prefs = getSharedPreferences("play_prefs", MODE_PRIVATE);
        String playName = prefs.getString("play_name", "ರಾಜ-ರಾಣಿ ಮಹಾ ನಾಟಕ");
        String duration = prefs.getString("duration", "3 ಗಂಟೆ 30 ನಿಮಿಷ");
        String venue = prefs.getString("venue", "ಗ್ರಾಮ ಚಾವಡಿ, ಹಾವೇರಿ");
        String date = prefs.getString("date", "ಇಂದು ರಾತ್ರಿ 8:00 ಗಂಟೆಗೆ");
        String posterUrl = prefs.getString("poster_url", "");

        tvPlayName.setText(playName);
        tvDuration.setText("⏱ " + duration);
        tvVenue.setText("📍 " + venue);
        tvDate.setText("🕗 " + date);

        if (!posterUrl.isEmpty()) {
            Glide.with(this).load(posterUrl).placeholder(R.drawable.ic_poster_placeholder).into(ivPoster);
        } else {
            ivPoster.setImageResource(R.drawable.ic_poster_placeholder);
        }
    }
}
