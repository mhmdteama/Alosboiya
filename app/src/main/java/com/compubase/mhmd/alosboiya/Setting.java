package com.compubase.mhmd.alosboiya;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Setting extends Fragment {

    Spinner elmadenaaspinner ;
    private static final String[] elmadena ={"الرياض" ,"مكة المكرمة" ,  "الدمام","جدة"};



    public Setting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        elmadenaaspinner =v.findViewById(R.id.elmadenaaedit);
        ArrayAdapter<String> elmadenaAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, elmadena);
        elmadenaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elmadenaaspinner.setAdapter(elmadenaAdapter);
        return v;
    }















}
