package com.example.pinnibass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class Testroom extends AppCompatActivity {

    Scanner scan = new Scanner(System.in);

    Button newTest;
    Button beginTest;
    Button interTest;
    Button testRoomBack;

    int solveNew = 1;
    int solveBegin;
    int solveInter;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testroom);
        Log.e("시험 방", "onCreate");

        newTest = findViewById(R.id.newTest);
        beginTest = findViewById(R.id.beginTest);
        interTest = findViewById(R.id.interTest);

        // 입문 수료 시험
        newTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewTest.class);

                intent.putExtra("newTestContents", 8);
                intent.putExtra("solveNew", 8);

                startActivity(intent);
            }
        });

        // 초급 수료 시험
        beginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), BeginTest.class);

                startActivity(intent);
            }
        });

        // 중급 수료 시험
        interTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), InterTest.class);

                startActivity(intent);
            }
        });

       testRoomBack = (Button)findViewById(R.id.testRoomBack);
        testRoomBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.e("시험 방", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("시험 방", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("시험 방", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("시험 방", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("시험 방", "onDestroy");
    }

    public void newTestContents() {

        solveNew = scan.nextInt(7) + 1;

        if (solveNew == 1) {
            String testNew1 = getResources().getString(R.string.newTest1);
//            testContent.setText(testNew1);
        } else if (solveNew == 2) {
            String testNew2 = getResources().getString(R.string.newTest2);
//            testContent.setText(testNew2);
        } else if (solveNew == 3) {
            String testNew3 = getResources().getString(R.string.newTest3);
//            testContent.setText(testNew3);
        } else if (solveNew == 4) {
            String testNew4 = getResources().getString(R.string.newTest4);
//            testContent.setText(testNew4);
        } else if (solveNew == 5) {
            String testNew5 = getResources().getString(R.string.newTest5);
//            testContent.setText(testNew5);
        } else if (solveNew == 6) {
            String testNew6 = getResources().getString(R.string.newTest6);
//            testContent.setText(testNew6);
        } else if (solveNew == 7) {
            String testNew7 = getResources().getString(R.string.newTest7);
//            testContent.setText(testNew7);
        } else if (solveNew == 8) {
            String testNew8 = getResources().getString(R.string.testEnd);
//            testContent.setText("시험이 종료되었습니다!\n총 점수 : " + score);
        }
    }
}
