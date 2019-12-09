package com.example.dbtest;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    ImageView setting;
    Button btnstart, btncall;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);


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

        setting = (ImageView) findViewById(R.id.setting);
        btnstart = (Button) findViewById(R.id.btnstart);
        btncall = (Button) findViewById(R.id.btncall);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, DayActivity.class);
                startActivity(intent);
            }
        });
}
}
