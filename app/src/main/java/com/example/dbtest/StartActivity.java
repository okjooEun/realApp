package com.example.dbtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    ImageView setting;
    Button btnstart, btncall;
    private BackPressCloseHandler backPressCloseHandler;


    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start);

        backPressCloseHandler = new BackPressCloseHandler(this);

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
                Intent intent = new Intent(StartActivity.this, PrologueActivity.class);
                startActivity(intent);
                finish();
            }
        });
}

// 뒤로가기 눌렀을 때
@Override public void onBackPressed() { //backPressCloseHandler.onBackPressed();

        AlertDialog.Builder dia = new AlertDialog.Builder(this);
        dia.setTitle("종료");
        dia.setMessage("정말 종료하시겠습니까?");
        dia.setIcon(R.drawable.icon1).setPositiveButton("네", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        finish();
        }
        });
        dia.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {

        }
        });
        dia.show();
        }
        }
