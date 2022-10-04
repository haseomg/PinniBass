package com.example.pinnibass;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {

    String nameInput;
    String gradeInput;
    String cityInput;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Log.e("인트로 화면", "onCreate");

        sharedPreferences = getSharedPreferences("userShared", Activity.MODE_PRIVATE);

        nameInput = sharedPreferences.getString("nameIn", null);
        gradeInput = sharedPreferences.getString("gradeIn",null);
        cityInput = sharedPreferences.getString("cityIn",null);

        // 시작 버튼 클릭 시 입력 받은 이름이 없으면 IntroInput, 있으면 메인으로
        Button startBtn = (Button) findViewById(R.id.introStart);
        startBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (nameInput == null) {

                    Intent intent = new Intent
                            (getBaseContext(), IntroInput.class);

                    startActivity(intent);
                    Log.i("Intro에서 name이 null일 때 ","" + nameInput);

                } if (gradeInput == null) {

                    Intent intent = new Intent
                            (getBaseContext(), IntroInput.class);

                    startActivity(intent);
                    Log.i("Intro에서 grade가 null일 때 ","" + gradeInput);

                } else {

                    Intent intent = new Intent
                            (getBaseContext(), MainActivity.class);

                    startActivity(intent);
                    Log.i("Intro에서 name, grade가 null이 아닐 때 ","name / grade : "
                            + nameInput +" / "+ gradeInput);

                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.e("인트로 화면", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("인트로 화면", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("인트로 화면", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("인트로 화면", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("인트로 화면", "onDestroy");
    }
}