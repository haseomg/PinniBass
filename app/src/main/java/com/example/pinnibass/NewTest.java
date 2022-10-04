package com.example.pinnibass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class NewTest extends AppCompatActivity {


    Scanner scan = new Scanner(System.in);

    TextView testGrade;
    TextView testContent;

    Button testBack;
    Button oneBtn, twoBtn, threeBtn, fourBtn;

    int score;
    int solveNew = 1;
    String newTestContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);

        testGrade = findViewById(R.id.testGrade);
        testContent = findViewById(R.id.testContent);

//        Intent intent = new Intent(getIntent());
//
//        newTestContents = getIntent().getStringExtra("newTestContents");
////        int newContents = intent.getIntExtra("solveNew", 1);
//        solveNew = testroom.solveNew;
//        testContent.setText(newTestContents);

        testBack = findViewById(R.id.testBack);
        oneBtn = findViewById(R.id.oneBtn1);
        twoBtn = findViewById(R.id.twoBtn1);
        threeBtn = findViewById(R.id.threeBtn1);
        fourBtn = findViewById(R.id.fourBtn1);

        newTestContents();


        // 완료 버튼
        testBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (solveNew == 1) {
                    score = score + 15;
                } else if (solveNew == 4) {
                    score = score + 15;
                } else {
                    score = score + 0;
                }

                solveNew = solveNew + 1;
                newTestContents();
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (solveNew == 2) {
                    score = score + 15;
                } else if (solveNew == 3) {
                    score = score + 15;
                } else if (solveNew == 5) {
                    score = score + 15;
                } else if (solveNew == 6) {
                    score = score + 15;
                } else if (solveNew == 7) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }
                solveNew = solveNew + 1;
                newTestContents();
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void newTestContents() {

//        solveNew = scan.nextInt(7) + 1;

        if (solveNew == 1) {
            String testNew1 = getResources().getString(R.string.newTest1);
            testContent.setText(testNew1);
//            solveNew = scan.nextInt();
        } else if (solveNew == 2) {
            String testNew2 = getResources().getString(R.string.newTest2);
            testContent.setText(testNew2);
        } else if (solveNew == 3) {
            String testNew3 = getResources().getString(R.string.newTest3);
            testContent.setText(testNew3);
        } else if (solveNew == 4) {
            String testNew4 = getResources().getString(R.string.newTest4);
            testContent.setText(testNew4);
        } else if (solveNew == 5) {
            String testNew5 = getResources().getString(R.string.newTest5);
            testContent.setText(testNew5);
        } else if (solveNew == 6) {
            String testNew6 = getResources().getString(R.string.newTest6);
            testContent.setText(testNew6);
        } else if (solveNew == 7) {
            String testNew7 = getResources().getString(R.string.newTest7);
            testContent.setText(testNew7);
        } else if (solveNew == 8) {
            String testNew8 = getResources().getString(R.string.testEnd);
            testContent.setText("시험이 종료되었습니다!\n총 점수 : " + score);
            // 수료점수 90점 => 입문일 경우 초급으로 등급 업
            // 수료하지 못할 시 => 그대로
        }
    }
}