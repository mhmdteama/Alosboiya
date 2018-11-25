package com.compubase.mhmd.alosboiya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyAccount extends AppCompatActivity {
    Button logeout , credit , setting , myprofile , announce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        final MyCridet card = new MyCridet();
        final  Setting settingFragment = new Setting();
        final Announcement announcement = new Announcement();
        final AccountFragment accountFragment = new AccountFragment();





////////////////////////////////////////////////////////////////////////////////////////////////////
        logeout = findViewById(R.id.el5orog);
        logeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAccount.this , MainActivity.class);
                startActivity(intent);
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        credit = findViewById(R.id.cridet);
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.account_container ,card);
                fragmentTransaction.commit();
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setting = findViewById(R.id.settingaccount);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.account_container ,settingFragment);
                fragmentTransaction.commit();
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////
        announce = findViewById(R.id.announcepage);
        announce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.account_container ,accountFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
