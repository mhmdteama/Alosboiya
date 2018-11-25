package com.compubase.mhmd.alosboiya;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AnnounceAdapter extends RecyclerView.Adapter<AnnounceAdapter.AnnounceViewHolder> {
    private ArrayList<AnnounceItems> ourannounceItems;
    public AnnounceAdapter(ArrayList<AnnounceItems> announceItems)
    {
        ourannounceItems =announceItems;
    }




    public static class  AnnounceViewHolder extends RecyclerView.ViewHolder {
        TextView annname , anntime ,annername , annlocattion;
        ImageView annimage;

        public AnnounceViewHolder(View itemView) {
            super(itemView);
         annname = itemView.findViewById(R.id.announce_name);
         anntime = itemView.findViewById(R.id.announce_time);
         annername = itemView.findViewById(R.id.annuncer_name);
         annlocattion = itemView.findViewById(R.id.announce_location);
         annimage = itemView.findViewById(R.id.announce_image);


        }
    }
    {

    }


    @NonNull
    @Override
    public AnnounceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announc_item,parent,false);
        return new AnnounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnounceViewHolder holder, int position) {
        AnnounceItems myannounceItems = ourannounceItems.get(position);
        holder.annname.setText(myannounceItems.getAnnouncename());
        holder.anntime.setText(myannounceItems.getAnnouncetime());
        holder.annlocattion.setText(myannounceItems.getAnnouncelocation());
        holder.annername.setText(myannounceItems.getAnnouncername());
        holder.annimage.setImageResource(myannounceItems.getAnnounceimage());

    }

    @Override
    public int getItemCount() {
        return ourannounceItems.size();
    }


}
