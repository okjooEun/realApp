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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    ImageView imgCalender, imgTime, guest;
    Button btnSetting, btnselect1, btnselect2, btnselect3;
    TextView txttalk;
    LinearLayout linbtn;
    boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        imgCalender = (ImageView) findViewById(R.id.imgCalendar);
        imgTime = (ImageView) findViewById(R.id.imgTime);
        guest = (ImageView) findViewById(R.id.guest);

        txttalk = (TextView) findViewById(R.id.txttalk);
        linbtn = (LinearLayout) findViewById(R.id.linBtn);

        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnselect1 = (Button) findViewById(R.id.btnselect1);
        btnselect2 = (Button) findViewById(R.id.btnselect2);
        btnselect3 = (Button) findViewById(R.id.btnselect3);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  //화면 가로 고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
*/
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

    public void onClick(View v) {
//        txttalk.setVisibility(View.VISIBLE);
//        linbtn.setVisibility(View.GONE);

        Intent intent = new Intent(MainActivity.this, TalkActivity.class);
        startActivity(intent);

    }
}
