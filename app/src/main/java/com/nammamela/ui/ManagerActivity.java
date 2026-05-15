package com.nammamela.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nammamela.R;

public class ManagerActivity extends AppCompatActivity {

    private EditText etPlayName, etDuration, etVenue, etDate, etPosterUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("🎬 ಮ್ಯಾನೇಜರ್ ಪ್ಯಾನಲ್");
        }

        etPlayName = findViewById(R.id.etPlayName);
        etDuration = findViewById(R.id.etDuration);
        etVenue = findViewById(R.id.etVenue);
        etDate = findViewById(R.id.etDate);
        etPosterUrl = findViewById(R.id.etPosterUrl);
        Button btnSave = findViewById(R.id.btnSavePlay);

        SharedPreferences prefs = getSharedPreferences("play_prefs", MODE_PRIVATE);
        etPlayName.setText(prefs.getString("play_name", ""));
        etDuration.setText(prefs.getString("duration", ""));
        etVenue.setText(prefs.getString("venue", ""));
        etDate.setText(prefs.getString("date", ""));
        etPosterUrl.setText(prefs.getString("poster_url", ""));

        btnSave.setOnClickListener(v -> savePlayDetails());
    }

    private void savePlayDetails() {
        String playName = etPlayName.getText().toString().trim();
        if (playName.isEmpty()) { etPlayName.setError("ನಾಟಕದ ಹೆಸರು ನಮೂದಿಸಿ"); return; }

        SharedPreferences.Editor editor = getSharedPreferences("play_prefs", MODE_PRIVATE).edit();
        editor.putString("play_name", playName);
        editor.putString("duration", etDuration.getText().toString().trim());
        editor.putString("venue", etVenue.getText().toString().trim());
        editor.putString("date", etDate.getText().toString().trim());
        editor.putString("poster_url", etPosterUrl.getText().toString().trim());
        editor.apply();

        Toast.makeText(this, "✅ ನಾಟಕದ ವಿವರ ಉಳಿಸಲಾಗಿದೆ!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
