package com.example.dbtest;

import android.content.Intent;
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

    Button  iceCup, iceWater, iceMilk,hotCup, hotWater, hotMilk, blender, recipeBook, btnMake;
    Button ing[] = new Button[8];
    Integer[] Rid_button = {R.id.ing0, R.id.ing1, R.id.ing2, R.id.ing3, R.id.ing4, R.id.ing5, R.id.ing6, R.id.ing7, R.id.ing8};
    TextView selectCup, selectWM, selectIng,selectBlen;
    ImageView trash;

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
            ing[i] = (Button) findViewById(Rid_button[i]);
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

        selectCup = (TextView) findViewById(R.id.selectCup);
        selectWM = (TextView) findViewById(R.id.selectWM);
        selectBlen = (TextView) findViewById(R.id.selectBlen);
        selectIng = (TextView) findViewById(R.id.selectIng);

        trash = (ImageView) findViewById(R.id.trash);

        iceCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCup.setText("찬컵");
            }
        });

        hotCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCup.setText("뜨거운컵");
            }
        });

        iceWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWM.setText("차가운 물");
            }
        });

        hotWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWM.setText("뜨거운 물");
            }
        });

        iceMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWM.setText("차가운 우유");
            }
        });

        hotMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWM.setText("뜨거운 우유");
            }
        });

        for(int i =0; i<ing.length; i++){
            final int INDEX;
            INDEX = i;
            ing[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    selectIng.setText(ing[INDEX].getText().toString());
                }
            });
        }

        blender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectBlen.setText("블랜딩");
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCup.setText("");
                selectWM.setText("");
                selectIng.setText("");
                selectBlen.setText("");
            }
        });

        recipeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(KitchenActivity.this);

                builder.setMessage("레시피북 내용");
                builder.show();
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
