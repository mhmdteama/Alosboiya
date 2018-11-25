package com.compubase.mhmd.alosboiya;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SugesstionAdapter extends RecyclerView.Adapter<SugesstionAdapter.SuggestionViewHolder>{
    private ArrayList<SuggestionItems> oursuggestionItems;
    public SugesstionAdapter (ArrayList<SuggestionItems> suggestionItems)
    {
        oursuggestionItems =suggestionItems;
    }


    public class SuggestionViewHolder extends RecyclerView.ViewHolder {
        ImageView sugimg ;
        TextView sugdis , sugloc;
        public SuggestionViewHolder(View itemView) {
            super(itemView);
            sugimg = itemView.findViewById(R.id.sug_img);
            sugdis = itemView.findViewById(R.id.sug_dis);
            sugloc= itemView.findViewById(R.id.sug_location);
        }
    }


    @NonNull
    @Override
    public SuggestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sugesstionitems,parent,false);

        return new SuggestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionViewHolder holder, int position) {
        SuggestionItems suggestionItems = oursuggestionItems.get(position);
        holder.sugimg.setImageResource(suggestionItems.getSugimg());
        holder.sugdis.setText(suggestionItems.getSugdis());
        holder.sugloc.setText(suggestionItems.getSuglocatoin());
    }

    @Override
    public int getItemCount() {
        return oursuggestionItems.size();
    }


}
