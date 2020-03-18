package com.example.dbtest;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class LoadingDialog extends Dialog {
    LoadingDialog(@NonNull Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);   //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //다이얼로그의 배경을 투명으로 만듭니다.
        getWindow().setGravity(Gravity.CENTER);

        setContentView(R.layout.activity_makesuccess);     //다이얼로그에서 사용할 레이아웃입니다.

        ImageView gifImageView = findViewById(R.id.menu);
        Glide.with(getContext()).load(R.drawable.ms_bl).into(gifImageView);


    }
}
