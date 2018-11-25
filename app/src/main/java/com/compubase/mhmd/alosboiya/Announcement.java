package com.compubase.mhmd.alosboiya;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Announcement extends Fragment {
    RecyclerView announceRv;
    RecyclerView.Adapter annRvadapter;
    ArrayList<AnnounceItems>  announceItems;

    public Announcement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ////////////////////////////////////////////////////////////////////////////////////////////////////
        announceRv = view.findViewById(R.id.announcements);
        announceRv.setHasFixedSize(true);
        announceRv.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , true));
        annRvadapter = new AnnounceAdapter(announceItems);
        announceItems = new ArrayList<AnnounceItems>();
        announceItems.add(new AnnounceItems("شقة جديدة","22/10/2018","MhmdTeama","الرياض",R.drawable.omara));
        announceItems.add(new AnnounceItems("شقة جديدة","23/10/2018","MhmdTeama","الرياض",R.drawable.omara));
        announceItems.add(new AnnounceItems("شقة جديدة","24/10/2018","MhmdTeama","الرياض",R.drawable.omara));
        announceItems.add(new AnnounceItems("شقة قديمة","25/10/2018","MhmdTeama","الرياض",R.drawable.omara));
        announceItems.add(new AnnounceItems("شقة حلوة","26/10/2018","MhmdTeama","الرياض",R.drawable.omara));
        annRvadapter = new AnnounceAdapter(announceItems);
        announceRv.setAdapter(annRvadapter);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
