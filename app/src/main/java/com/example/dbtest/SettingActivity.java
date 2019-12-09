package com.example.dbtest;

import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    ImageView btnclose;
    Button onBack, offBack, onSound, offSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btnclose = (ImageView) findViewById(R.id.btnclose);
       onBack = (Button)findViewById(R.id.onBack);
       offBack =(Button) findViewById(R.id.offBack);
       onSound = (Button) findViewById(R.id.onSound);
       offSound = (Button) findViewById(R.id.offSound);

       btnclose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });


    }
}
