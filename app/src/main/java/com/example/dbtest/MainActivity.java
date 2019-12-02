package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgCalender, imgTime, guest;
    Button btnSetting, btnSelect1, btnSelect2, btnSelect3, goKitchen;
    LinearLayout linBtn;
    TextView txtTalk, txtTalk2;
    FrameLayout frame;

    Random rand = new Random();


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

//        imgCalender = (ImageView) findViewById(R.id.imgCalendar);
//        imgTime = (ImageView) findViewById(R.id.imgTime);
        guest = (ImageView) findViewById(R.id.guest);

        linBtn = (LinearLayout) findViewById(R.id.linBtn);
        frame = (FrameLayout) findViewById(R.id.frame);

        txtTalk = (TextView) findViewById(R.id.txtTalk);
        txtTalk2 = (TextView) findViewById(R.id.txtTalk2);
//
//        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSelect1 = (Button) findViewById(R.id.btnSelect1);
        btnSelect2 = (Button) findViewById(R.id.btnSelect2);
        btnSelect3 = (Button) findViewById(R.id.btnSelect3);
        goKitchen = (Button) findViewById(R.id.goKitchen);
        guest = (ImageView) findViewById(R.id.guest);


        String menuarray[] = getResources().getStringArray(R.array.MENU);
        final String blackarray[] = getResources().getStringArray(R.array.BLACK);
        int i = rand.nextInt(9);
        int j = rand.nextInt(4);
        int r = rand.nextInt(2);

        for (int count = 0; count < 8; count++) {
            switch (r) {
                case 0:
                    txtTalk.setText(menuarray[i] + " " + (j + 1) + " 잔 주세요.");
                    goKitchen.setVisibility(View.VISIBLE);
                    break;

                case 1:
                    txtTalk.setText((blackarray[j]));
                    if(j==0){
                        btnSelect1.setText("손님, 죄송하지만 저희 매장에는 없는 메뉴입니다. 단 메뉴를 찾으신다면 초코 스무디로 준비해드릴까요?");
                        btnSelect2.setText("그런 메뉴는 없습니다. 다른 걸로 주문하세요.");
                        btnSelect3.setText("그런 거 시키시려면 별다방으로 가세요");
                    } if(j==1){
                        btnSelect1.setText("손님, 주문 다시 확인하겠습니다. 아이스 아메리카노 주문하신 것 맞나요?");
                        btnSelect2.setText("메뉴 제조");
                        btnSelect3.setText("이어폰 빼고 제대로 주문하시겠어요?");
                } if(j==2){
                    btnSelect1.setText("네? 다 똑같이 생기셨는데...");
                    btnSelect2.setText("그냥 하나로 의견 모아서 주세요.");
                    btnSelect3.setText("각자 한 잔씩 결제 가능한데, 한 카드로 진행 하면 될까요?");
                } if(j==3){
                        btnSelect1.setText("할인이나 적립은 둘 중 하나만 선택하세요.");
                        btnSelect2.setText("저희 매장은 할인과 적립 동시 적용 가능 매장이 아니어서요. 둘 중 하나만 이용 가능하신데, 어떤 걸로 하시겠어요?");
                        btnSelect3.setText("(사장님께 전화해본다.)");
                }
                    break;
            }


            frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    txtTalk.setVisibility(View.GONE);
                    linBtn.setVisibility(View.VISIBLE);
                }
            });

            btnSelect1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linBtn.setVisibility(View.INVISIBLE);
                    txtTalk2.setVisibility(View.VISIBLE);
                    goKitchen.setVisibility(View.VISIBLE);
                }
            });
            btnSelect2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linBtn.setVisibility(View.INVISIBLE);
                    txtTalk2.setVisibility(View.VISIBLE);
                    goKitchen.setVisibility(View.VISIBLE);
                }
            });

            btnSelect3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linBtn.setVisibility(View.INVISIBLE);
                    txtTalk2.setVisibility(View.VISIBLE);
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

            int rnd = rand.nextInt(3);
            String imgName = "guest" + rnd;
            Resources res = getResources();
            int id = res.getIdentifier(imgName, "drawable", getPackageName());

            guest.setImageResource(id);
        }
    }
}