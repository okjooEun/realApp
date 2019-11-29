package com.example.dbtest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class TalkActivity extends AppCompatActivity {
    ImageView imgCalender, imgTime, guest;
    Button btnSetting, btnKitchen;
    TextView txttalk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        imgCalender = (ImageView) findViewById(R.id.imgCalendar);
        imgTime = (ImageView) findViewById(R.id.imgTime);
        guest = (ImageView) findViewById(R.id.guest);

        txttalk = (TextView) findViewById(R.id.txttalk);

        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnKitchen = (Button) findViewById(R.id.btnKitchen);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        //소프트키(네비게이션바) 없애기 시작
        View decorView = getWindow().getDecorView();

        int uiOption = getWindow().getDecorView().getSystemUiVisibility();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOption);
        //소프트키(네비게이션바) 없애기 끝

    }
    public void onClick(View v){
        Intent intent = new Intent(TalkActivity.this, KitchenActivity.class);
        startActivity(intent);
    }

}
