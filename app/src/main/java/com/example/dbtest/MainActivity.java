package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgCalender, imgTime, guest;
    Button btnSetting, btnSelect1, btnSelect2, btnSelect3,goKitchen;
    LinearLayout linBtn;
    TextView txtTalk;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        imgCalender = (ImageView) findViewById(R.id.imgCalendar);
        imgTime = (ImageView) findViewById(R.id.imgTime);
        guest = (ImageView) findViewById(R.id.guest);

        linBtn = (LinearLayout) findViewById(R.id.linBtn);
        frame = (FrameLayout) findViewById(R.id.frame);

        txtTalk = (TextView) findViewById(R.id.txTtalk);

        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSelect1 = (Button) findViewById(R.id.btnSelect1);
        btnSelect2 = (Button) findViewById(R.id.btnSelect2);
        btnSelect3 = (Button) findViewById(R.id.btnSelect3);
        goKitchen = (Button) findViewById(R.id.goKitchen);

       frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTalk.setVisibility(View.INVISIBLE);
                linBtn.setVisibility(View.VISIBLE);
            }
        });

        btnSelect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               linBtn.setVisibility(View.INVISIBLE);
               txtTalk.setVisibility(View.VISIBLE);
               goKitchen.setVisibility(View.VISIBLE);
            }
        });
        btnSelect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linBtn.setVisibility(View.INVISIBLE);
                txtTalk.setVisibility(View.VISIBLE);
                goKitchen.setVisibility(View.VISIBLE);
            }
        });
        btnSelect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linBtn.setVisibility(View.INVISIBLE);
                txtTalk.setVisibility(View.VISIBLE);
                goKitchen.setVisibility(View.VISIBLE);

            }
        });
        goKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                startActivity(intent);
            }
        });
    }
}