package com.example.pinnibass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BeginTest extends AppCompatActivity {

    TextView beginTitle;
    TextView beginContent;

    Button beginBack;
    Button oneBtn, twoBtn, threeBtn;

    int score;
    int solveBegin = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_test);

        beginTitle = findViewById(R.id.beginTitle);
        beginContent = findViewById(R.id.beginContent);

        beginBack = findViewById(R.id.beginBack);
        oneBtn = findViewById(R.id.oneBtn2);
        twoBtn = findViewById(R.id.twoBtn2);
        threeBtn = findViewById(R.id.threeBtn2);

        beginTestContents();

        beginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solveBegin == 3) {
                    score = score + 10;
                } else if (solveBegin == 4) {
                    score = score + 10;
                } else if (solveBegin == 10) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveBegin = solveBegin + 1;
                beginTestContents();
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solveBegin == 2) {

                } else if (solveBegin == 5) {
                    score = score + 10;
                } else if (solveBegin == 6) {
                    score = score + 10;
                } else if (solveBegin == 7) {
                    score = score + 10;
                } else if (solveBegin == 8) {
                    score = score + 10;
                } else if (solveBegin == 9) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveBegin = solveBegin + 1;
                beginTestContents();
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solveBegin == 1) {
                    score = score + 10;
                } else {
                    score = score + 0;
                }

                solveBegin = solveBegin + 1;
                beginTestContents();
            }
        });

    }

    public void beginTestContents() {
        if (solveBegin == 1) {
            String testBegin1 = getResources().getString(R.string.beginTest1);
            beginContent.setText(testBegin1);
//            solveNew = scan.nextInt();
        } else if (solveBegin == 2) {
            String testBegin2 = getResources().getString(R.string.beginTest2);
            beginContent.setText(testBegin2);
        } else if (solveBegin == 3) {
            String testBegin3 = getResources().getString(R.string.beginTest3);
            beginContent.setText(testBegin3);
        } else if (solveBegin == 4) {
            String testBegin4 = getResources().getString(R.string.beginTest4);
            beginContent.setText(testBegin4);
        } else if (solveBegin == 5) {
            String testBegin5 = getResources().getString(R.string.beginTest5);
            beginContent.setText(testBegin5);
        } else if (solveBegin == 6) {
            String testBegin6 = getResources().getString(R.string.beginTest6);
            beginContent.setText(testBegin6);
        } else if (solveBegin == 7) {
            String testBegin7 = getResources().getString(R.string.beginTest7);
            beginContent.setText(testBegin7);
        } else if (solveBegin == 8) {
            String testBegin8 = getResources().getString(R.string.beginTest8);
            beginContent.setText(testBegin8);
        } else if (solveBegin == 9) {
            String testBegin9 = getResources().getString(R.string.beginTest9);
            beginContent.setText(testBegin9);
        } else if (solveBegin == 10) {
            String testBegin10 = getResources().getString(R.string.beginTest10);
            beginContent.setText(testBegin10);
        } else if (solveBegin == 11) {
            String testNew8 = getResources().getString(R.string.testEnd);
            beginContent.setText("시험이 종료되었습니다!\n총 점수 : " + score);
            // 수료점수 80점 => 입문일 경우 초급으로 등급 업
            // 수료하지 못할 시 => 그대로
        }
    }
}