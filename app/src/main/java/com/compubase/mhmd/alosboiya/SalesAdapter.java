package com.compubase.mhmd.alosboiya;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesViewHolder> {

    TinyDB tinyDB ;



    private ArrayList<SalesItems> oursalesitems;

    Context context ;
    public SalesAdapter (ArrayList<SalesItems> salesItems)
    {
        oursalesitems = salesItems;
    }




    public class SalesViewHolder extends RecyclerView.ViewHolder {
        TextView location , salesname, salesdate , sallername;
        RecyclerView rv ;
        ImageView salesimage;
       AppCompatActivity appCompatActivity;


        public SalesViewHolder(View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.location_name);
            salesname = itemView.findViewById(R.id.sales_name);
            salesdate = itemView.findViewById(R.id.sales_date);
            sallername = itemView.findViewById(R.id.saller_name);
            salesimage = itemView.findViewById(R.id.sales_image);
            rv = itemView.findViewById(R.id.sales_list);

        }
    }


    @NonNull
    @Override
    public SalesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sales_items,parent,false);
        context = parent.getContext();
        tinyDB = new TinyDB(parent.getContext());
        return new SalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesViewHolder holder, int position) {
        SalesItems salesItems = oursalesitems.get(position);


        holder.location.setText(salesItems.getLocation());
        holder.salesname.setText(salesItems.getSalesname());
        holder.salesdate.setText(salesItems.getSalesdate());
        holder.sallername.setText(salesItems.getSallername());


       //holder.salesimage.setImageURI(Uri.parse(salesItems.getSellseimage()));

        if(salesItems.getSellseimage().equals("Images/imageposting.png"))
        {
            Glide.with(holder.salesimage.getContext()).load(R.drawable.imgposting).into(holder.salesimage);
        }else
            {
                Glide.with(holder.salesimage.getContext()).load(salesItems.getSellseimage()).into(holder.salesimage);
            }

         /*   holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SalesDetails.class);

                    intent.putExtra("item_id","Id");
                    context.startActivity(intent);

                }
            });*/


    }

    @Override
    public int getItemCount() {
        return oursalesitems.size();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////




    private void showMessage(String _s) {
        Toast.makeText(context.getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }

}
