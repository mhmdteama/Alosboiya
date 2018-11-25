package com.compubase.mhmd.alosboiya;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommntsViewHolder>{

    private ArrayList<CommentsItem> usercomments;
    public CommentsAdapter(ArrayList<CommentsItem> commentsItems)
    {
        usercomments =commentsItems;
    }









    public class CommntsViewHolder extends RecyclerView.ViewHolder {
        TextView commentdate, commentuser , commenttext;
        public CommntsViewHolder(View itemView) {
            super(itemView);
            commentdate = itemView.findViewById(R.id.comment_date);
            commentuser = itemView.findViewById(R.id.comment_user);
            commenttext = itemView.findViewById(R.id.comment_content);
        }
    }
    @NonNull
    @Override
    public CommntsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_item,parent,false);

        return new CommntsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CommntsViewHolder holder, int position) {
        CommentsItem commentsItem = usercomments.get(position);
        holder.commentdate.setText(commentsItem.getCommentdate());
        holder.commenttext.setText(commentsItem.getCommenttext());
        holder.commentuser.setText(commentsItem.getCommentuser());


    }

    @Override
    public int getItemCount() {
        return usercomments.size();
    }


}
