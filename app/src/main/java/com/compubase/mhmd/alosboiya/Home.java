package com.compubase.mhmd.alosboiya;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Home extends Fragment {
    ImageButton do5ol , gareda , harag ;
    Uri pictureUri;
    public static final String TAG = "fragmentname";


    public Home() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
          view =inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView logo = (ImageView) view.findViewById(R.id.logo);
        Glide.with(getContext()).load(R.drawable.logo2).into(logo);
        do5ol = view.findViewById(R.id.do5ol);
        do5ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Home2.class);
                startActivity(intent);
            }
        });
        harag = view.findViewById(R.id.harage);
        harag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Harag.class);
                startActivity(intent);
            }
        });
    }
}
