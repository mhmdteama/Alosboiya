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


public class Comments extends Fragment {
    RecyclerView commentsRv;
    RecyclerView.Adapter commentsRvAdapter;
    ArrayList<CommentsItem> commentsItems;

    public Comments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_comments, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ////////////////////////////////////////////////////////////////////////////////////////////////////
        commentsRv = view.findViewById(R.id.allRv_comments);
        commentsRv.setHasFixedSize(true);
        commentsRv.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL, true));
        commentsRvAdapter = new CommentsAdapter(commentsItems);
        commentsItems = new ArrayList<CommentsItem>();
        commentsItems.add(new CommentsItem("22/72019","mhmd","عظيم"));
        commentsItems.add(new CommentsItem("22/72019","ali","جمبل"));
        commentsItems.add(new CommentsItem("22/72019","hassnan","ممتاز"));
        commentsItems.add(new CommentsItem("22/72019","taha","رائع"));
        commentsItems.add(new CommentsItem("22/72019","ameer","جيد جدا"));
        commentsRvAdapter= new CommentsAdapter(commentsItems);
        commentsRv.setAdapter(commentsRvAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
