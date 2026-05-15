package com.nammamela.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nammamela.R;
import com.nammamela.adapter.FanCommentAdapter;
import com.nammamela.data.db.AppDatabase;
import com.nammamela.data.model.FanComment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FanWallActivity extends AppCompatActivity {

    private EditText etFanName, etComment;
    private RecyclerView rvComments;
    private FanCommentAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_wall);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("👏 ಫ್ಯಾನ್ ವಾಲ್");
        }

        etFanName = findViewById(R.id.etFanName);
        etComment = findViewById(R.id.etComment);
        rvComments = findViewById(R.id.rvComments);
        Button btnSubmit = findViewById(R.id.btnSubmitApplause);

        db = AppDatabase.getInstance(this);

        rvComments.setLayoutManager(new LinearLayoutManager(this));
        loadComments();

        btnSubmit.setOnClickListener(v -> submitComment());
    }

    private void loadComments() {
        List<FanComment> comments = db.fanCommentDao().getAllComments();
        adapter = new FanCommentAdapter(comments);
        rvComments.setAdapter(adapter);
    }

    private void submitComment() {
        String name = etFanName.getText().toString().trim();
        String comment = etComment.getText().toString().trim();

        if (name.isEmpty()) { etFanName.setError("ನಿಮ್ಮ ಹೆಸರು ನಮೂದಿಸಿ"); return; }
        if (comment.isEmpty()) { etComment.setError("ಅಭಿಪ್ರಾಯ ಬರೆಯಿರಿ"); return; }

        String timestamp = new SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()).format(new Date());
        FanComment fc = new FanComment(name, comment, timestamp);
        db.fanCommentDao().insertComment(fc);

        etFanName.setText("");
        etComment.setText("");
        loadComments();
        rvComments.smoothScrollToPosition(0);
        Toast.makeText(this, "👏 ನಿಮ್ಮ ಚಪ್ಪಾಳೆ ಸ್ವೀಕರಿಸಲಾಗಿದೆ!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
