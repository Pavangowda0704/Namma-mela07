package com.nammamela.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nammamela.R;

public class CastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("🎭 ನಟರ ಪಟ್ಟಿ");
        }

        // Lead Actor
        ImageView ivActor = findViewById(R.id.ivLeadActor);
        TextView tvActorName = findViewById(R.id.tvLeadActorName);
        TextView tvActorRole = findViewById(R.id.tvLeadActorRole);
        Glide.with(this).load("https://i.pravatar.cc/300?img=11").circleCrop().into(ivActor);
        tvActorName.setText("ರಾಜಶೇಖರ್ ಕುಮಾರ್");
        tvActorRole.setText("ಮುಖ್ಯ ನಟ · ರಾಜ ಪಾತ್ರ");

        // Comedian
        ImageView ivComedian = findViewById(R.id.ivComedian);
        TextView tvComedianName = findViewById(R.id.tvComedianName);
        TextView tvComedianRole = findViewById(R.id.tvComedianRole);
        Glide.with(this).load("https://i.pravatar.cc/300?img=15").circleCrop().into(ivComedian);
        tvComedianName.setText("ಚಂದ್ರು ಹಾಸ್ಯಗಾರ");
        tvComedianRole.setText("ಹಾಸ್ಯ ನಟ · ಸೇವಕ ಪಾತ್ರ");

        // Singer
        ImageView ivSinger = findViewById(R.id.ivSinger);
        TextView tvSingerName = findViewById(R.id.tvSingerName);
        TextView tvSingerRole = findViewById(R.id.tvSingerRole);
        Glide.with(this).load("https://i.pravatar.cc/300?img=47").circleCrop().into(ivSinger);
        tvSingerName.setText("ಮಲ್ಲಿಕಾ ದೇವಿ");
        tvSingerRole.setText("ಮುಖ್ಯ ಗಾಯಕಿ · ರಾಣಿ ಪಾತ್ರ");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
