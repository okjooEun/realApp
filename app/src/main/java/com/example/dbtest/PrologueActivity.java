package com.example.dbtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AlphabetIndexer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class PrologueActivity extends AppCompatActivity {

    FrameLayout lin;
    ImageView imageView;
    TextView txt;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue);


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

        lin = (FrameLayout) findViewById(R.id.lin);
        imageView = (ImageView)findViewById(R.id.imageView);
        txt = (TextView) findViewById(R.id.txt);

        //글자 애니메이션
        anim = new AlphaAnimation(0.0f,1.0f);
        anim.setDuration(800);
        anim.setStartOffset(500);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        txt.startAnimation(anim);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.startAnimation(anim);
                    imageView.setImageResource(R.drawable.pro2);
                 imageView.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         txt.startAnimation(anim);
                         imageView.setImageResource(R.drawable.pro3);
                         imageView.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                 imageView.setImageResource(R.drawable.pro4);
                                 imageView.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         imageView.setImageResource(R.drawable.pro5);
                                         imageView.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 imageView.setImageResource(R.drawable.pro6);
                                                 imageView.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         imageView.setImageResource(R.drawable.pro7);
                                                         imageView.setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {
                                                                 imageView.setImageResource(R.drawable.pro8);
                                                                 imageView.setOnClickListener(new View.OnClickListener() {
                                                                     @Override
                                                                     public void onClick(View v) {
                                                                         imageView.setImageResource(R.drawable.pro9);
                                                                         imageView.setOnClickListener(new View.OnClickListener() {
                                                                             @Override
                                                                             public void onClick(View v) {
                                                                                 AlertDialog.Builder builder = new AlertDialog.Builder(PrologueActivity.this);
                                                                                 builder.setMessage("튜토리얼을 진행하시겠습니까?");
                                                                                 builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                                                                                     @Override
                                                                                     public void onClick(DialogInterface dialog, int which) {
                                                                                         Intent intent = new Intent(PrologueActivity.this, TutoActivity.class);
                                                                                         startActivity(intent);
                                                                                         finish();
                                                                                     }
                                                                                 });
                                                                                 builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                                                                                     @Override
                                                                                     public void onClick(DialogInterface dialog, int which) {
                                                                                         Intent intent = new Intent (PrologueActivity.this, DayActivity.class);
                                                                                         startActivity(intent);
                                                                                         finish();
                                                                                     }
                                                                                 });
                                                                                 AlertDialog dialog = builder.create();
                                                                                 dialog.show();
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
                 });

                }

        });

    }
}
