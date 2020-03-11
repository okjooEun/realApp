package com.example.dbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    //카운터 답변 제한 시간 15초
    private static final long START_TIME = 150000;
    private boolean mTimeRunning;
    private CountDownTimer timer, timer2;
    private long mTimeLeft = START_TIME;

    private BackPressCloseHandler backPressCloseHandler;

    ImageView setting, guest, imageView16;
    Button btnSelect1, btnSelect2, btnSelect3, goKitchen;
    LinearLayout linBtn, lin;
    TextView txtTalk, txtTalk2, guestname;
    FrameLayout frame;

    ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    Handler handler = new Handler();


    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("case");

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this);

        final CountClass countclass = (CountClass) getApplicationContext();

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
        guest = (ImageView) findViewById(R.id.guest);
        imageView16 = (ImageView) findViewById(R.id.imageView16);


        lin = (LinearLayout) findViewById(R.id.lin);
        linBtn = (LinearLayout) findViewById(R.id.linBtn);
        frame = (FrameLayout) findViewById(R.id.frame);

        txtTalk = (TextView) findViewById(R.id.txtTalk);
        txtTalk2 = (TextView) findViewById(R.id.txtTalk2);
        guestname = (TextView) findViewById(R.id.guestname);

        btnSelect1 = (Button) findViewById(R.id.btnSelect1);
        btnSelect2 = (Button) findViewById(R.id.btnSelect2);
        btnSelect3 = (Button) findViewById(R.id.btnSelect3);
        goKitchen = (Button) findViewById(R.id.goKitchen);
        guest = (ImageView) findViewById(R.id.guest);
        Resources res1 = getResources();

        final Drawable drawable = res1.getDrawable(R.drawable.speech);

        Resources resources = getResources();

        drawables.add(resources.getDrawable(R.drawable.selec_bar5));
        drawables.add(resources.getDrawable(R.drawable.selec_bar4));
        drawables.add(resources.getDrawable(R.drawable.selec_bar3));
        drawables.add(resources.getDrawable(R.drawable.selec_bar2));
        drawables.add(resources.getDrawable(R.drawable.selec_bar1));
        drawables.add(resources.getDrawable(R.drawable.selec_bar0));

        //String menuarray[] = getResources().getStringArray(R.array.MENU);
        String customarray[] = getResources().getStringArray(R.array.CUSTOM);
        final String blackarray[] = getResources().getStringArray(R.array.BLACK);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();

            }

            private void startTimer() {
                timer2 = new CountDownTimer(mTimeLeft, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mTimeLeft = millisUntilFinished;

                    }

                    @Override
                    public void onFinish() {
                        mTimeRunning = false;
                    }
                }.start();
                mTimeRunning = true;
            }

            private void pauseTimer(){
                timer2.cancel();
                mTimeRunning = false;
            }

        });

        class MAnimThread extends Thread{
            public void run(){
                int index = 0 ;
                for(int i =0; i<10; i++){
                    final Drawable drawable3 = drawables.get(index);
                    index +=1;
                    if(index >=6){
                        index = 0;
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView16.setImageDrawable(drawable3);
                        }
                    });
                    try{Thread.sleep(2900);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

        timer = new CountDownTimer(15*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //엔딩 화면 바꿔야함
                Intent intent = new Intent(MainActivity.this, WrongEndingActivity.class);
                startActivity(intent);
                finish();

            }
        };

        int r = rand.nextInt(blackarray.length);
        int i = rand.nextInt(1);
        int j = rand.nextInt(customarray.length);
        for (int count = 0; count < 8; count++) {
            switch (j) {
                case 0:
                    imageView16.setVisibility(View.INVISIBLE);
                    txtTalk.setText(customarray[i]);
                    switch (i) {
                        case 0: {
                            guestname.setText("22살 여성");
                            Resources gu = getResources();
                            Drawable dr = gu.getDrawable(R.drawable.guest0);
                            guest.setImageDrawable(dr);
                            goKitchen.setVisibility(View.VISIBLE);
                            goKitchen.setClickable(true);

                            goKitchen.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    countclass.peopleCount++;

                                    Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                    intent.putExtra("bil1", "아이스아메리카노 \nX 1");
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            break;
                        }

                        case 1: {
                            guestname.setText("30살 여성");
                            Resources gu = getResources();
                            Drawable dr = gu.getDrawable(R.drawable.guest1);
                            guest.setImageDrawable(dr);
                            goKitchen.setVisibility(View.VISIBLE);
                            goKitchen.setClickable(true);

                            goKitchen.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                    intent.putExtra("bil1", "딸기 스무디 \nX 1");
                                    intent.putExtra("bil2", "핫 초코라떼 \nX 1");
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            break;
                        }

                    }

                    break;

                case 1: {
                    frame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            txtTalk.setVisibility(View.GONE);
                            linBtn.setVisibility(View.VISIBLE);
                            guestname.setVisibility(View.INVISIBLE);
                            frame.setClickable(false);
                            frame.setBackground(null);

                            timer.start();


                        }
                    });

                    txtTalk.setText((blackarray[r]));
                    if (r == 0) {
                        Resources gu = getResources();
                        Drawable dr = gu.getDrawable(R.drawable.black);
                        lin.setBackground(dr);

                        guestname.setText("진상1");
                        btnSelect1.setText("손님, 아이가 손으로 케잌을 만져서 판매가 어려워서\n이 케익까지 구매 해 주실 수 있을까요?");
                        btnSelect2.setText("(못 본 척 한다.)");
                        btnSelect3.setText("얘! 그걸 만지면 어떡하니!");

                        final MAnimThread thread = new MAnimThread();
                        thread.start();

                        btnSelect1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imageView16.setVisibility(View.INVISIBLE);
                                linBtn.setVisibility(View.INVISIBLE);
                                txtTalk2.setVisibility(View.VISIBLE);
                                txtTalk2.setText("아, 죄송해요. 애기가 만진 것까지 합쳐서 계산해주세요.");
                                goKitchen.setVisibility(View.VISIBLE);
                                guestname.setVisibility(View.VISIBLE);
                                frame.setClickable(true);
                                frame.setBackground(drawable);
                                databaseReference.setValue("1");
                                timer.cancel();

                                goKitchen.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        timer.cancel();
                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                        intent.putExtra("bil1", "아이스 바닐라라떼 \nX 1");
                                        intent.putExtra("bil2", "핫 아메리카노 \nX 2");
                                        intent.putExtra("bil3", "핫 카페라떼 \nX 1");
                                        intent.putExtra("bil4", "핫초코 \nX 1");
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                            }
                        });


                        btnSelect2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timer.cancel();
                                linBtn.setVisibility(View.INVISIBLE);
                                txtTalk2.setVisibility(View.VISIBLE);
                                txtTalk2.setText("(양심에 찔리지만 넘어갔다.)");
                                goKitchen.setVisibility(View.VISIBLE);
                                guestname.setVisibility(View.VISIBLE);
                                frame.setClickable(true);
                                frame.setBackground(drawable);
                                goKitchen.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                        intent.putExtra("bil1", "아이스 바닐라라떼 \nX 1");
                                        intent.putExtra("bil2", "핫 아메리카노 \nX 2");
                                        intent.putExtra("bil3", "핫 카페라떼 \nX 1");
                                        intent.putExtra("bil4", "핫초코 \nX 1");
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                            }
                        });

                        btnSelect3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timer.cancel();
                                Intent intent = new Intent(MainActivity.this, WrongEndingActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });
                    }
                    if (r == 1) {
                        guestname.setText("진상2");
                        Resources gu1 = getResources();
                        Drawable dr1 = gu1.getDrawable(R.drawable.black2);
                        guest.setImageDrawable(dr1);

                        btnSelect1.setText("제가 궁예인 줄 아십니까?");
                        btnSelect2.setText("죄송하지만 제가 기억이 안 나는데, 메뉴를 정확히 골라 주시겠어요?");
                        btnSelect3.setText("네? 아메리카노?");

                        final MAnimThread thread = new MAnimThread();
                        thread.start();

                        btnSelect1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timer.cancel();
                                Intent intent = new Intent(MainActivity.this, WrongEndingActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });


                        btnSelect2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timer.cancel();
                                linBtn.setVisibility(View.INVISIBLE);
                                txtTalk2.setVisibility(View.VISIBLE);
                                txtTalk2.setText("따뜻한 바닐라라떼 1잔 주세요...");
                                goKitchen.setVisibility(View.VISIBLE);
                                guestname.setVisibility(View.VISIBLE);
                                frame.setBackground(drawable);

                                goKitchen.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                        intent.putExtra("bil1", "핫 바닐라라떼 \nX 1");
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                            }
                        });

                        btnSelect3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timer.cancel();
                                linBtn.setVisibility(View.INVISIBLE);
                                txtTalk2.setVisibility(View.VISIBLE);
                                txtTalk2.setText("아니 아니, 그거 말고 다른거 시켰잖아요");
                                frame.setClickable(true);
                                guestname.setVisibility(View.VISIBLE);
                                frame.setBackground(drawable);
                                frame.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        guestname.setVisibility(View.VISIBLE);
                                        guestname.setText("나");
                                        txtTalk2.setText("네? 혹시 카페라떼..?");
                                        frame.setClickable(true);
                                        frame.setBackground(drawable);
                                        frame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                guestname.setVisibility(View.VISIBLE);
                                                guestname.setText("진상2");
                                                txtTalk2.setText("아니이~ 그거 말고 달짝지근한거!");
                                                frame.setClickable(true);
                                                frame.setBackground(drawable);
                                                frame.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        guestname.setVisibility(View.VISIBLE);
                                                        guestname.setText("나");
                                                        txtTalk2.setText("잘 모르겠는데,,,");
                                                        frame.setClickable(true);
                                                        frame.setBackground(drawable);
                                                        frame.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                guestname.setVisibility(View.VISIBLE);
                                                                guestname.setText("진상2");
                                                                txtTalk2.setText("에이, 내가 힌트 줄게 ‘바’로 시작하는거!");
                                                                frame.setClickable(true);
                                                                frame.setBackground(drawable);
                                                                frame.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        guestname.setVisibility(View.VISIBLE);
                                                                        guestname.setText("뒤에있던 손님");
                                                                        txtTalk2.setText("(짜증을 내며) 저기요, 저 빨리 주문하고 나가봐야 하거든요? \n언제까지 스무고개 하고 있을거에요?");
                                                                        frame.setClickable(true);
                                                                        frame.setBackground(drawable);
                                                                        frame.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                guestname.setVisibility(View.VISIBLE);
                                                                                guestname.setText("나");
                                                                                txtTalk2.setText("아, 따뜻한 바닐라라떼요! \n(뒤의 손님에게) 죄송합니다, 조금만 더 기다려주세요!");
                                                                                goKitchen.setVisibility(View.VISIBLE);


                                                                                goKitchen.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        timer.cancel();
                                                                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                                                                        intent.putExtra("bil1", "핫 \n바닐라라떼 X 1");
                                                                                        startActivity(intent);
                                                                                        finish();
                                                                                    }
                                                                                });
                                                                                guestname.setVisibility(View.VISIBLE);
                                                                                frame.setClickable(true);
                                                                                frame.setBackground(drawable);

                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });
                                                    }
                                                });

                                            }
                                        });
                                    }
                                });
                            }
                        });

                    }
                }
            }
        }
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

