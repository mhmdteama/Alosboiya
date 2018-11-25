package com.compubase.mhmd.alosboiya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home2 extends AppCompatActivity {
    ImageButton a3daa , regest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        a3daa = findViewById(R.id.do5olAla3daa);
        regest = findViewById(R.id.tasgelGeded);
        a3daa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2.this , Login.class);
                startActivity(intent);
            }
        });
        regest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home2.this , Registration.class);
                startActivity(intent);
            }
        });
    }
}
