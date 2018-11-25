package com.compubase.mhmd.alosboiya;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AccountFragment extends Fragment {
    TextView allannounces , endedannounces, commentsannounces;


    final Announcement announcement = new Announcement();
    final Comments comments = new Comments();
    final Profile profile = new Profile();


    public AccountFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.announce_container ,profile);
        fragmentTransaction.commit();


        allannounces = view.findViewById(R.id.all_announces);
        allannounces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.announce_container ,announcement);
                fragmentTransaction.commit();

            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        endedannounces = view.findViewById(R.id.ended_announces);

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        commentsannounces = view.findViewById(R.id.comentes_announces);
        commentsannounces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.announce_container ,comments);
                fragmentTransaction.commit();
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
