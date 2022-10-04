package com.example.pinnibass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InterTest extends AppCompatActivity {

    TextView interTitle;
    TextView interContent;

    Button interBack;
    Button oneBtn, twoBtn, threeBtn, fourBtn;

    int score;
    int solveInter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_test);

        interTitle = findViewById(R.id.interTitle);
        interContent = findViewById(R.id.interContent);

        interBack = findViewById(R.id.interBack);
        oneBtn = findViewById(R.id.oneBtn3);
        twoBtn = findViewById(R.id.twoBtn3);
        threeBtn = findViewById(R.id.threeBtn3);
        fourBtn = findViewById(R.id.fourBtn3);

        interTestContents();

        interBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // score랑 메서드 반복 넣어줘야지
        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solveInter == 2) {
                    score = score + 10;
                } else if (solveInter == 3) {
                    score = score + 10;
                } else if (solveInter == 6) {
                    score = score + 10;
                } else if (solveInter == 7) {
                    score = score + 10;
                } else if (solveInter == 8) {
                    score = score + 10;
                } else if (solveInter == 10) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveInter = solveInter + 1;
                interTestContents();
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (solveInter == 4) {
                    score = score + 10;
                } else if (solveInter == 5) {
                    score = score + 10;
                } else if (solveInter == 9) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveInter = solveInter + 1;
                interTestContents();
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score = score + 0;
                solveInter = solveInter + 1;
                interTestContents();
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (solveInter == 4) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveInter = solveInter + 1;
                interTestContents();
            }
        });
    }

    public void interTestContents() {
        if (solveInter == 1) {
            String testinter1 = getResources().getString(R.string.interTest1);
            interContent.setText(testinter1);
//            solveNew = scan.nextInt();
        } else if (solveInter == 2) {
            String testinter2 = getResources().getString(R.string.interTest2);
            interContent.setText(testinter2);
        } else if (solveInter == 3) {
            String testinter3 = getResources().getString(R.string.interTest3);
            interContent.setText(testinter3);
        } else if (solveInter == 4) {
            String testinter4 = getResources().getString(R.string.interTest4);
            interContent.setText(testinter4);
        } else if (solveInter == 5) {
            String testinter5 = getResources().getString(R.string.interTest5);
            interContent.setText(testinter5);
        } else if (solveInter == 6) {
            String testinter6 = getResources().getString(R.string.interTest6);
            interContent.setText(testinter6);
        } else if (solveInter == 7) {
            String testinter7 = getResources().getString(R.string.interTest7);
            interContent.setText(testinter7);
        } else if (solveInter == 8) {
            String testinter8 = getResources().getString(R.string.interTest8);
            interContent.setText(testinter8);
        } else if (solveInter == 9) {
            String testinter9 = getResources().getString(R.string.interTest9);
            interContent.setText(testinter9);
        } else if (solveInter == 10) {
            String testinter10 = getResources().getString(R.string.interTest10);
            interContent.setText(testinter10);
        } else if (solveInter == 11) {
            String testNew8 = getResources().getString(R.string.testEnd);
            interContent.setText("시험이 종료되었습니다!\n총 점수 : " + score);
            // 수료점수 80점 => 입문일 경우 초급으로 등급 업
            // 수료하지 못할 시 => 그대로
        }
    }
}