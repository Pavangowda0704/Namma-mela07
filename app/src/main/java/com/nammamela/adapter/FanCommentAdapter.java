package com.nammamela.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nammamela.R;
import com.nammamela.data.model.FanComment;

import java.util.List;

public class FanCommentAdapter extends RecyclerView.Adapter<FanCommentAdapter.ViewHolder> {

    private List<FanComment> comments;

    public FanCommentAdapter(List<FanComment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fan_comment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FanComment c = comments.get(position);
        holder.tvName.setText("👤 " + c.fanName);
        holder.tvComment.setText("\"" + c.comment + "\"");
        holder.tvTime.setText(c.timestamp);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvComment, tvTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCommentFanName);
            tvComment = itemView.findViewById(R.id.tvCommentText);
            tvTime = itemView.findViewById(R.id.tvCommentTime);
        }
    }
}
