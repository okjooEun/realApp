package com.example.dbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ImageView setting, guest;
    Button btnSelect1, btnSelect2, btnSelect3, goKitchen;
    LinearLayout linBtn;
    TextView txtTalk, txtTalk2, guestname;
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

        setting = (ImageView) findViewById(R.id.setting);
        guest = (ImageView) findViewById(R.id.guest);

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

        //String menuarray[] = getResources().getStringArray(R.array.MENU);
        String customarray[] = getResources().getStringArray(R.array.CUSTOM);
        final String blackarray[] = getResources().getStringArray(R.array.BLACK);

        int r = rand.nextInt(2);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

//        String imgName = "guest" + r;
//        Resources res = getResources();
//        int id = res.getIdentifier(imgName, "drawable", getPackageName());

        for (int count = 0; count < 8; count++) {
            switch (r) {
                case 0:
                    txtTalk.setText(customarray[r]);
                    switch (r) {
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
                                    Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                    intent.putExtra("bil1","아이스아메리카노 \nX 1");
                                    startActivity(intent);
                                }
                            });
                            break;
                        }

                        case 1: {
                            guestname.setText("30살 여성");
                            Resources gu = getResources();
                            Drawable dr = gu.getDrawable(R.drawable.guest0);
                            guest.setImageDrawable(dr);
                            goKitchen.setVisibility(View.VISIBLE);
                            goKitchen.setClickable(true);

                            goKitchen.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                    intent.putExtra("bil1","딸기 스무디 \nX 1");
                                    intent.putExtra("bil2","핫 초코라떼 \nX 1");
                                    startActivity(intent);
                                }
                            });
                            break;
                        }

                    }

                    break;

                case 1:
                    frame.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            txtTalk.setVisibility(View.GONE);
                            linBtn.setVisibility(View.VISIBLE);
                            guestname.setVisibility(View.INVISIBLE);
                            frame.setClickable(false);
                            frame.setBackground(null);

                        }
                    });
                    txtTalk.setText((blackarray[r-1]));
                    if (r == 1) {
                        Resources gu = getResources();
                        Drawable dr = gu.getDrawable(R.drawable.guest0);
                        guest.setImageDrawable(dr);
                        guestname.setText("진상1");
                        btnSelect1.setText("손님, 아이가 손으로 케잌을 만져서 판매가 어려워서\n이 케익까지 구매 해 주실 수 있을까요?");
                        btnSelect2.setText("(못 본 척 한다.)");
                        btnSelect3.setText("얘! 그걸 만지면 어떡하니!");
                        btnSelect1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                linBtn.setVisibility(View.INVISIBLE);
                                txtTalk2.setVisibility(View.VISIBLE);
                                txtTalk2.setText("아, 죄송해요. 애기가 만진 것까지 합쳐서 계산해주세요.");
                                goKitchen.setVisibility(View.VISIBLE);
                                guestname.setVisibility(View.VISIBLE);
                                frame.setClickable(true);
                                frame.setBackground(drawable);
                                goKitchen.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                        intent.putExtra("bil1","아이스 바닐라라떼 \nX 1");
                                        intent.putExtra("bil2","핫 아메리카노 \nX 2");
                                        intent.putExtra("bil3","핫 카페라떼 \nX 1");
                                        intent.putExtra("bil4","핫초코 \nX 1");
                                        startActivity(intent);
                                    }
                                });

                            }
                        });


                        btnSelect2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
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
                                        intent.putExtra("bil1","아이스 바닐라라떼 \nX 1");
                                        intent.putExtra("bil2","핫 아메리카노 \nX 2");
                                        intent.putExtra("bil3","핫 카페라떼 \nX 1");
                                        intent.putExtra("bil4","핫초코 \nX 1");
                                        startActivity(intent);
                                    }
                                });
                            }
                        });

                        btnSelect3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, WrongEndingActivity.class);
                                startActivity(intent);

                            }
                        });
                    }
                    if (r == 2) {
                        guestname.setText("진상2");
                        Resources gu = getResources();
                        Drawable dr = gu.getDrawable(R.drawable.guest0);
                        guest.setImageDrawable(dr);
                        btnSelect1.setText("제가 궁예인 줄 아십니까?");
                        btnSelect2.setText("죄송하지만 제가 기억이 안 나는데, 메뉴를 정확히 골라 주시겠어요?");
                        btnSelect3.setText("네? 아메리카노?");
                        btnSelect1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, WrongEndingActivity.class);
                                startActivity(intent);

                            }
                        });


                        btnSelect2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
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
                                        intent.putExtra("bil1","핫 바닐라라떼 \nX 1");
                                        startActivity(intent);
                                    }
                                });
                            }
                        });

                        btnSelect3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
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
                                                                                        Intent intent = new Intent(MainActivity.this, KitchenActivity.class);
                                                                                        intent.putExtra("bil1","핫 \n바닐라라떼 X 1");
                                                                                        startActivity(intent);
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
//                    if (j == 2) {
//                        Resources gu = getResources();
//                        Drawable dr = gu.getDrawable(R.drawable.guest1);
//                        btnSelect1.setText("네? 다 똑같이 생기셨는데...");
//                        btnSelect2.setText("그냥 하나로 의견 모아서 주세요.");
//                        btnSelect3.setText("각자 한 잔씩 결제 가능한데, 한 카드로 진행 하면 될까요?");
//                    }
//                    if (j == 3) {
//                        Resources gu = getResources();
//                        Drawable dr = gu.getDrawable(R.drawable.guest1);
//
//                        btnSelect1.setText("할인이나 적립은 둘 중 하나만 선택하세요.");
//                        btnSelect2.setText("저희 매장은 할인과 적립 동시 적용 가능 매장이 아니어서요.\n 둘 중 하나만 이용 가능하신데, 어떤 걸로 하시겠어요?");
//                        btnSelect3.setText("(사장님께 전화해본다.)");
//                    }
//                    break;
//            }


//
//            btnSelect1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    linBtn.setVisibility(View.INVISIBLE);
//                    txtTalk2.setVisibility(View.VISIBLE);
//                    goKitchen.setVisibility(View.VISIBLE);
//                    guestname.setVisibility(View.VISIBLE);
//                    frame.setClickable(true);
//                    frame.setBackground(drawable);
//
//                }
//            });
//
//
//            btnSelect2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    linBtn.setVisibility(View.INVISIBLE);
//                    txtTalk2.setVisibility(View.VISIBLE);
//                    goKitchen.setVisibility(View.VISIBLE);
//                    guestname.setVisibility(View.VISIBLE);
//                    frame.setClickable(true);
//                    frame.setBackground(drawable);
//                }
//            });
//
//            btnSelect3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    linBtn.setVisibility(View.INVISIBLE);
//                    txtTalk2.setVisibility(View.VISIBLE);
//                    goKitchen.setVisibility(View.VISIBLE);
//                    guestname.setVisibility(View.VISIBLE);
//                    frame.setClickable(true);
//                    frame.setBackground(drawable);
//
//                }
//            });

//            int rnd = rand.nextInt(3);
//            String imgName = "guest" + rnd;
//            Resources res = getResources();
//            int id = res.getIdentifier(imgName, "drawable", getPackageName());
//
//            guest.setImageResource(id);
            }
        }

    }}