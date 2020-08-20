package com.universe_of_software.total_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {


    @Override
    //해당 엑티비티가 생성될떄  a_splash_activity.xml과 연결
    //startLoading() 매서드 실행하기
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash_activity);
        startLoading();



    }


    //스플래쉬 이미지 N 초 동안 띄워주기
    //핸들러 설정후 intent를 1초간 딜레이를줘서 메인엑티비티로 바꿔 시작
    public void startLoading(){

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000); // 1초

    }
}
