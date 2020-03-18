package com.example.dbtest;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KitchenActivity extends AppCompatActivity {

    Button iceCup, iceWater, iceMilk,hotCup, hotWater, hotMilk, blender, recipeBook, btnMake,trash;
    ImageView icon0,icon1,icon2,icon3,icon4,icon5,icon6, icon7, icon8;
    ImageView selectCup, selectWM, selectIng,selectIng2,selectBlen, imageView15, setting, help;
    TextView bil1, bil2, bil3,bil4;

    private BackPressCloseHandler backPressCloseHandler;

   private CountDownTimer ktimer;


    ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        //소프트키(네비게이션바) 없애기 시작
        View decorView = getWindow().getDecorView();

        backPressCloseHandler = new BackPressCloseHandler(this);

        CountClass countclass = (CountClass) getApplication();

        int uiOption = getWindow().getDecorView().getSystemUiVisibility();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility(uiOption);
        //소프트키(네비게이션바) 없애기

        ktimer = new CountDownTimer(15*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //엔딩 화면 넣기
                Intent intent = new Intent(KitchenActivity.this, WrongEndingActivity.class);
                startActivity(intent);
                finish();
            }
        };

        icon0 = (ImageView) findViewById(R.id.icon0);
        icon1 = (ImageView) findViewById(R.id.icon1);
        icon2 = (ImageView) findViewById(R.id.icon2);
        icon3 = (ImageView) findViewById(R.id.icon3);
        icon4 = (ImageView) findViewById(R.id.icon4);
        icon5 = (ImageView) findViewById(R.id.icon5);
        icon6 = (ImageView) findViewById(R.id.icon6);
        icon7 = (ImageView) findViewById(R.id.icon7);
        icon8 = (ImageView) findViewById(R.id.icon8);
        setting = (ImageView) findViewById(R.id.setting);
        help = (ImageView) findViewById(R.id.help);


        iceCup = (Button) findViewById(R.id.iceCup);
        hotCup = (Button) findViewById(R.id.hotCup);
        iceWater = (Button) findViewById(R.id.iceWater);
        hotWater = (Button) findViewById(R.id.hotWater);
        iceMilk = (Button) findViewById(R.id.iceMilk);
        hotMilk = (Button) findViewById(R.id.hotMilk);
        blender = (Button) findViewById(R.id.blender);
        recipeBook = (Button) findViewById(R.id.recipeBook);
        btnMake = (Button) findViewById(R.id.btnMake);

        selectCup = (ImageView) findViewById(R.id.selectCup);
        selectWM = (ImageView) findViewById(R.id.selectWM);
        selectBlen = (ImageView) findViewById(R.id.selectBlen);
        selectIng = (ImageView) findViewById(R.id.selectIng);
        selectIng2 = (ImageView) findViewById(R.id.selectIng2);
        imageView15 = (ImageView) findViewById(R.id.imageView15);

        bil1 = (TextView) findViewById(R.id.bil1);
        bil2 = (TextView) findViewById(R.id.bil2);
        bil3 = (TextView) findViewById(R.id.bil3);
        bil4 = (TextView) findViewById(R.id.bil4);

        Intent intent = getIntent();

        trash = (Button) findViewById(R.id.trash);


        Resources resources = getResources();
        drawables.add(resources.getDrawable(R.drawable.bar5));
        drawables.add(resources.getDrawable(R.drawable.bar4));
        drawables.add(resources.getDrawable(R.drawable.bar3));
        drawables.add(resources.getDrawable(R.drawable.bar2));
        drawables.add(resources.getDrawable(R.drawable.bar1));
        drawables.add(resources.getDrawable(R.drawable.bar0));


        String a = intent.getExtras().getString("bil1");
        bil1.setText(a);

        String b = intent.getExtras().getString("bil2");
        bil2.setText(b);

        String c = intent.getExtras().getString("bil3");
        bil3.setText(c);

        String d = intent.getExtras().getString("bil4");
        bil4.setText(d);


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(KitchenActivity.this, SettingActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(KitchenActivity.this, HelpActivity.class);
                startActivity(intent1);
            }
        });
        iceCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.icecup_on);
                selectCup.setImageDrawable(drawable);
            }
        });

        hotCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotcup_on);
                selectCup.setImageDrawable(drawable);
            }
        });

        iceWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.coldwater_on);
                selectWM.setImageDrawable(drawable);
            }
        });

        hotWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotwater_on);
                selectWM.setImageDrawable(drawable);
            }
        });

        iceMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.coldmilk_on);
                selectWM.setImageDrawable(drawable);
            }
        });

        hotMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotmilk_on);
                selectWM.setImageDrawable(drawable);
            }
        });

        icon0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.ice_on);
                selectIng.setImageDrawable(drawable);
                if (selectIng != null) {
                    icon0.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    });

                }
            }
        });

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.coffee_on);
                selectIng.setImageDrawable(drawable);

                icon1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectIng != null) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    }
                });
            }
        });
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.vanil_on);
                selectIng.setImageDrawable(drawable);

                icon2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectIng != null) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    }
                });
            }
        });
        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.choco_on);
                selectIng.setImageDrawable(drawable);
                icon3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectIng != null) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    }
                });

            }
        });
        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.straw_on);
                selectIng.setImageDrawable(drawable);
                icon4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectIng != null) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    }
                });
            }
        });
        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.banana_on);
                selectIng.setImageDrawable(drawable);
                icon5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectIng != null) {
                            selectIng2.setVisibility(View.VISIBLE);
                            selectIng2.setImageDrawable(drawable);
                        }
                    }
                });

                icon6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT).show();
                    }
                });

                icon7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT).show();
                    }
                });

                icon8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT).show();
                    }
                });
                blender.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Resources res = getResources();

                        final Drawable drawable = res.getDrawable(R.drawable.blender_on);
                        selectBlen.setImageDrawable(drawable);
                    }
                });

                trash.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectCup.setImageDrawable(null);
                        selectWM.setImageDrawable(null);
                        selectIng.setImageDrawable(null);
                        selectIng2.setImageDrawable(null);
                        selectIng2.setVisibility(View.GONE);
                        selectBlen.setImageDrawable(null);
                    }
                });

                recipeBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(KitchenActivity.this, RecipebookActivity.class);
                        startActivity(intent);
                    }
                });

                btnMake.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         LoadingDialog loadingDialog;

                        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics(); //디바이스 화면크기를 구하기위해
                        int width = dm.widthPixels; //디바이스 화면 너비
                        int height = dm.heightPixels; //디바이스 화면 높이

                        //로딩이미지 gif 형식
                        loadingDialog = new LoadingDialog(getApplicationContext());
                        WindowManager.LayoutParams wm = loadingDialog.getWindow().getAttributes();  //다이얼로그의 높이 너비 설정하기위해
                        wm.copyFrom(loadingDialog.getWindow().getAttributes());  //여기서 설정한값을 그대로 다이얼로그에 넣겠다는의미
                        wm.width = (int)(width *0.5);  //화면 너비의 절반
                        wm.height = (int)(height *0.5);
                        loadingDialog.show();

                        // 제조 성공하면
                        //Intent intent = new Intent(KitchenActivity.this, MakesuccessActivity.class);
                        //startActivity(intent);
                        ktimer.cancel();
//                        Dialog dialog = new Dialog(KitchenActivity.this);
//                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                       // makesuccessActivity = new MakesuccessActivity(getApplicationContext());
//                        dialog.setContentView(R.layout.activity_makesuccess);
//                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                        dialog.show();
//
//                        Display display = getWindowManager().getDefaultDisplay();
//                        Point size = new Point();
//                        display.getSize(size);
//
//                        Window window = dialog.getWindow();
//
//                        int x = (int) (size.x * 0.5f);
//                        int y = (int) (size.y * 0.7f);
//
//                        window.setLayout(x, y);
//                        // 제조 실패하면
//

                    }
                });


            }
        });

//        switch (countclass.peopleCount) {
//
//            case 10:
//                Intent intent1 = new Intent(KitchenActivity.this, DayActivity.class);
//                startActivity(intent1);
//                finish();
//                break;
//            case 5:
//                Intent intent2 = new Intent(KitchenActivity.this, DayActivity.class);
//                startActivity(intent2);
//                finish();
//                break;
//
//            case 15:
//                Intent intent3 = new Intent(KitchenActivity.this, DayActivity.class);
//                startActivity(intent3);
//                finish();
//                break;
//        }
    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }


    @Override
    protected void onStart() {
        super.onStart();
        final AnimThread thread = new AnimThread();
        thread.start();
        ktimer.start();
    }

    class AnimThread extends Thread {
        public void run() {

            int index = 0;

            for (int i = 0; i < 10; i++) {
                final Drawable drawable;
                drawable = drawables.get(index);
                index += 1;
                if (index >= 6) {
                    index = 0;
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView15.setBackground(drawable);
                    }
                });
                try {
                    Thread.sleep(2900);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
            finish();
        }
    }
}