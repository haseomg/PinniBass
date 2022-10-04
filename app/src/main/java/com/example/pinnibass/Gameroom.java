package com.example.pinnibass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Gameroom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameroom);
        Log.e("게임 룸", "onCreate");

        // 메인으로
        Button gameBack = (Button)findViewById(R.id.gameRoomBack);
        gameBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });

        // 청음 게임
        Button listenBtn = (Button) findViewById(R.id.listenGame);
        listenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getBaseContext(), ListenGame.class);

                startActivity(intent);
            }
        });

        // 랜덤 퀴즈
        Button quizBtn = (Button)findViewById(R.id.randomQuiz);
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getBaseContext(), RandomQuiz.class);

                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.e("게임 룸", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("게임 룸", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("게임 룸", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("게임 룸", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("게임 룸", "onDestroy");
    }

}