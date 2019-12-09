package com.example.dbtest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class KitchenActivity extends AppCompatActivity {

    Button iceCup, iceWater, iceMilk,hotCup, hotWater, hotMilk, blender, recipeBook, btnMake,trash;
   ImageView ing[] = new ImageView[8];
    Integer[] Rid_ImageVIew = {R.id.ing0, R.id.ing1, R.id.ing2, R.id.ing3, R.id.ing4, R.id.ing5, R.id.ing6, R.id.ing7, R.id.ing8};
    ImageView selectCup, selectWM, selectIng,selectBlen;

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


        for(int i = 0; i<ing.length; i++){
            ing[i] = (ImageView) findViewById(Rid_ImageVIew[i]);
        }

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


        trash = (Button) findViewById(R.id.trash);


        iceCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.icecup);
                selectCup.setImageDrawable(drawable);
            }
        });

        hotCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotcup);
                selectCup.setImageDrawable(drawable);
            }
        });

        iceWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.ice_water);
                selectWM.setImageDrawable(drawable);
            }
        });

        hotWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotwater);
                selectWM.setImageDrawable(drawable);
            }
        });

        iceMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.ice_milk);
                selectWM.setImageDrawable(drawable);
            }
        });

        hotMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.hotmilk);
                selectWM.setImageDrawable(drawable);
            }
        });

        for(int i =0; i<ing.length; i++){
            final int INDEX;
            INDEX = i;
            ing[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Resources res = getResources();

                    final Drawable drawable = res.getDrawable(R.drawable.ice);
                    selectIng.setImageDrawable(drawable);
                }
            });
        }

        blender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();

                final Drawable drawable = res.getDrawable(R.drawable.miniblender);
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
