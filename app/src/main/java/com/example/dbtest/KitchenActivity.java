package com.example.dbtest;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class KitchenActivity extends AppCompatActivity {

    Button iceCup, iceWater, iceMilk,hotCup, hotWater, hotMilk, blender, recipeBook, btnMake,trash;
   ImageView ice_icon, coffee_icon, vanil_icon, choco_icon, straw_icon, banana_icon, mash_icon, toff_icon, mouse_icon;
    ImageView selectCup, selectWM, selectIng,selectBlen;
    TextView bil1, bil2, bil3,bil4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

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

        ice_icon = (ImageView) findViewById(R.id.ice_icon);
        coffee_icon =(ImageView)findViewById(R.id.coffee_icon);
        vanil_icon =(ImageView)findViewById(R.id.vanil_icon);
        choco_icon =(ImageView) findViewById(R.id.choco_icon);
        straw_icon = (ImageView) findViewById(R.id.straw_icon);
        banana_icon =(ImageView) findViewById(R.id.banana_icon);
        mash_icon =(ImageView) findViewById(R.id.mash_icon);
        toff_icon =(ImageView) findViewById(R.id.toff_icon);
        mouse_icon=(ImageView) findViewById(R.id.mouse_icon);


        iceCup = (Button) findViewById(R.id.iceCup);
        hotCup = (Button) findViewById(R.id.hotCup);
        iceWater =(Button) findViewById(R.id.iceWater);
        hotWater = (Button) findViewById(R.id.hotWater);
        iceMilk =(Button) findViewById(R.id.iceMilk);
        hotMilk = (Button) findViewById(R.id.hotMilk);
        blender = (Button) findViewById(R.id.blender);
        recipeBook = (Button) findViewById(R.id.recipeBook);
        btnMake = (Button) findViewById(R.id.btnMake);

        selectCup = (ImageView) findViewById(R.id.selectCup);
        selectWM = (ImageView) findViewById(R.id.selectWM);
        selectBlen = (ImageView) findViewById(R.id.selectBlen);
        selectIng = (ImageView) findViewById(R.id.selectIng);

        bil1 = (TextView) findViewById(R.id.bil1);
        bil2 = (TextView) findViewById(R.id.bil2);
        bil3 = (TextView) findViewById(R.id.bil3);
        bil4 = (TextView) findViewById(R.id.bil4);

        Intent intent = getIntent();

        trash = (Button) findViewById(R.id.trash);

        String a = intent.getExtras().getString("bil1");
        bil1.setText(a);

        String b = intent.getExtras().getString("bil2");
        bil2.setText(b);

        String c = intent.getExtras().getString("bil3");
        bil3.setText(c);

        String d = intent.getExtras().getString("bil4");
        bil4.setText(d);


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

        ice_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.ice_on);
                selectIng.setImageDrawable(drawable);
            }
        });

        coffee_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.coffee_on);
                selectIng.setImageDrawable(drawable);
            }
        });
        vanil_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.vanil_on);
                selectIng.setImageDrawable(drawable);
            }
        });
        choco_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.choco_on);
                selectIng.setImageDrawable(drawable);
            }
        });
        straw_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.straw_on);
                selectIng.setImageDrawable(drawable);
            }
        });
        banana_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.banana_on);
                selectIng.setImageDrawable(drawable);
            }
        });
        mash_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT ).show();
            }
        });

        toff_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT ).show();
            }
        });

        mouse_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(KitchenActivity.this, "이 재료는 사용할 수 없어요", Toast.LENGTH_SHORT ).show();
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
                // 제조 성공하면
                Intent intent = new Intent(KitchenActivity.this, MakesuccessActivity.class);
                startActivity(intent);
                // 제조 실패하면

            }
        });
    }
}
