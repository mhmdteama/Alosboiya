package com.compubase.mhmd.alosboiya;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class IteamListAdapter extends RecyclerView.Adapter<IteamListAdapter.ItemViewHolder> {
    private ArrayList<ItemList> ourItemList ;
    public IteamListAdapter(ArrayList<ItemList> itemLists)
    {
        ourItemList = itemLists;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public  ImageView itemimage;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemimage = itemView.findViewById(R.id.item_img);
        }
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list,parent,false);
        //ItemViewHolder itv = new ItemViewHolder(view);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemList myitemList = ourItemList.get(position);
        holder.itemimage.setImageResource(myitemList.getImguri());
    }

    @Override
    public int getItemCount() {
        return ourItemList.size() ;
    }
}
