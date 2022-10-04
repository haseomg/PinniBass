package com.example.pinnibass;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class RandomQuiz extends AppCompatActivity {

    Random ran;
    Scanner scan = new Scanner(System.in);

    int check;
    int score;
    int ok = 0;
    int count = 1;
    final int[] num = {10};

    View view;
    TextView quiz;
    TextView randomQuiz;
    Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn;

    Timer timer;
//    TimerHandler timerHandler;
    TimerTask timerTask;
    Handler handler;
    Handler mHandler;
//    Message msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_quiz);
        Log.e("랜덤 퀴즈", "onCreate");

        quiz = findViewById(R.id.quiz);
        randomQuiz = findViewById(R.id.randomQuiz);

        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);

            quizList();

            thread.start();
            handler = new Handler() {
                public void handleMessage(Message msg) {
                    randomQuiz.setText("타이머 : " + msg.what);
                }
            };
//            mHandler = new Handler() {
//                public void handleMessage(Message msg) {
//                    quiz.setText("" + msg.what);
//                }
//            };

//            countTimer();


        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
                    Log.e("1번 버튼", "count : " + count);
                    if (ok == 6) {
                        score = score + 20;
                    } else if (ok == 12) {
                        score = score + 20;
                    } else if (ok == 13) {
                        score = score + 20;
                    } else if (ok == 15) {
                        score = score + 20;
                    } else if (ok == 19) {
                        score = score + 20;
                    } else {
                        score = score + 0;
                    }
//                }
//                quiz.setText(ok);
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
//                    quizList();
                    Log.e("2번 버튼", "count : " + count);
                    if (ok == 2) {
                        score = score + 20;
                    } else if (ok == 3) {
                        score = score + 20;
                    } else if (ok == 4) {
                        score = score + 20;
                    }  else if (ok == 5) {
                        score = score + 20;
                    } else if (ok == 7) {
                        score = score + 20;
                    } else if (ok == 8) {
                        score = score + 20;
                    } else if (ok == 14) {
                        score = score + 20;
                    } else if (ok == 16) {
                        score = score + 20;
                    } else if (ok == 17) {
                        score = score + 20;
                    } else {
                        score = score + 0;
                    }
//                }
//                quiz.setText(ok);
//                quiz.setText("버튼 클릭 후 텍스트뷰 변경");
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
//                    quizList();
                    Log.e("3번 버튼", "count : " + count);
                    if (ok == 1) {
                        score = score + 20;
                    } else if (ok == 10) {
                        score = score + 20;
                    } else if (ok == 18) {
                        score = score + 20;
                    } else {
                        score = score + 0;
                    }
//                }
//                quiz.setText(ok);
//                quiz.setText("버튼 클릭 후 텍스트뷰 변경");
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
                    quizList();
                    Log.e("4번 버튼", "count : " + count);
                    if (ok == 9) {
                        score = score + 20;
                    } else {
                        score = score + 0;
                    }
//                }
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
//                    quizList();
                    Log.e("5번 버튼", "count : " + count);
                    score = score + 0;
//                }
////                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
//                    quizList();
                    Log.e("6번 버튼", "count : " + count);
                    score = score + 0;
//                }
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (count < 6) {
//                    count ++;
//                    quizList();
                    Log.e("7번 버튼", "count : " + count);
                    if (ok == 11) {
                        score = score + 20;
                    } else {
                        score = score + 0;
                    }
//                }
//                count ++;
                count = count + 1;
                quizList();
//                count ++;
            }
        });




        Button quizBack = (Button) findViewById(R.id.quizBack);
        quizBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.e("랜덤 퀴즈", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("랜덤 퀴즈", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("랜덤 퀴즈", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("랜덤 퀴즈", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("랜덤 퀴즈", "onDestroy");
    }


    public void btnClick(View view) {
        view = new View(this);
        this.view = view;
//        count = 1;
        if (view.getId() == R.id.oneBtn) {
//            count++;
        } else if (view.getId() == R.id.twoBtn) {
//            count++;
        } else if (view.getId() == R.id.threeBtn) {
//            count++;
        } else if (view.getId() == R.id.fourBtn) {
//            count++;
        } else if (view.getId() == R.id.fiveBtn) {
//            count++;
        } else if (view.getId() == R.id.sixBtn) {
//            count++;
        } else if (view.getId() == R.id.sevenBtn) {
//            count++;
        }
//        return false;
    }


    public void quizList() {
        ran = new Random();
//        count = 1;

        // 정답 버튼을 클릭하면 count가 올라가게

//        while (count < 6) {

            Log.e("quizList","count : " + count);
            Log.e("quizList","ok : " + ok);
            ok = ran.nextInt(19) + 1;

            if (ok == 1) {
                String quiz1 = getResources().getString(R.string.quiz1);
                quiz.setText(quiz1);
            } else if (ok == 2) {
                String quiz2 = getResources().getString(R.string.quiz2);
                quiz.setText(quiz2);
            } else if (ok == 3) {
                String quiz3 = getResources().getString(R.string.quiz3);
                quiz.setText(quiz3);
            } else if (ok == 4) {
                String quiz4 = getResources().getString(R.string.quiz4);
                quiz.setText(quiz4);
            } else if (ok == 5) {
                String quiz5 = getResources().getString(R.string.quiz5);
                quiz.setText(quiz5);
            } else if (ok == 6) {
                String quiz6 = getResources().getString(R.string.quiz6);
                quiz.setText(quiz6);
            } else if (ok == 7) {
                String quiz7 = getResources().getString(R.string.quiz7);
                quiz.setText(quiz7);
            } else if (ok == 8) {
                String quiz8 = getResources().getString(R.string.quiz8);
                quiz.setText(quiz8);
            } else if (ok == 9) {
                String quiz9 = getResources().getString(R.string.quiz9);
                quiz.setText(quiz9);
            } else if (ok == 10) {
                String quiz10 = getResources().getString(R.string.quiz10);
                quiz.setText(quiz10);
            } else if (ok == 11) {
                String quiz11 = getResources().getString(R.string.quiz11);
                quiz.setText(quiz11);
            } else if (ok == 12) {
                String quiz12 = getResources().getString(R.string.quiz12);
                quiz.setText(quiz12);
            } else if (ok == 13) {
                String quiz13 = getResources().getString(R.string.quiz13);
                quiz.setText(quiz13);
            } else if (ok == 14) {
                String quiz14 = getResources().getString(R.string.quiz14);
                quiz.setText(quiz14);
            } else if (ok == 15) {
                String quiz15 = getResources().getString(R.string.quiz15);
                quiz.setText(quiz15);
            } else if (ok == 16) {
                String quiz16 = getResources().getString(R.string.quiz16);
                quiz.setText(quiz16);
            } else if (ok == 17) {
                String quiz17 = getResources().getString(R.string.quiz17);
                quiz.setText(quiz17);
            } else if (ok == 18) {
                String quiz18 = getResources().getString(R.string.quiz18);
                quiz.setText(quiz18);
            } else if (ok == 19) {
                String quiz19 = getResources().getString(R.string.quiz19);
                quiz.setText(quiz19);
            }

//            btnClick(view);
//            count = count + 1;
//        } // while문 소괄호 끝

        if (count >= 6) {
            quiz.setText("퀴즈가 종료되었습니다!\n총 점수 : " + score);
//                Toast.makeText(RandomQuiz.this, "게임이 끝났습니다!", Toast.LENGTH_SHORT).show();
            Log.e("quizList()", "count >= 6");
        }
        if (num[0] == 0) {
            quiz.setText("퀴즈가 종료되었습니다!\n총 점수 : " + score);
//            Toast.makeText(RandomQuiz.this, "게임이 끝났습니다!", Toast.LENGTH_SHORT).show();
            Log.e("quizList()", "num[0] == 0");
        }
    } // quizList 메서드 끝




    Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {

            String input = randomQuiz.getText().toString();
            Message message = Message.obtain();
            message.obj = input;
            String output = message.obj + "퀴즈가 종료되었습니다!";

            while (num[0] != 0) {
//                msg = handler.obtainMessage();
//                handler.sendMessage(msg);
                try {
                    handler.sendEmptyMessage(num[0]--);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (num[0] == 0) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            randomQuiz.setText("퀴즈가 종료되었습니다!");
                            quiz.setText("총 점수 : "+ score);
                        }
                    });
//                    randomQuiz.setText("퀴즈가 종료되었습니다!");
//                    quiz.setText("총 점수 : "+ score);
//                    Toast.makeText(RandomQuiz.this, "게임이 끝났습니다!", Toast.LENGTH_SHORT).show();
                }
                if (count == 6) {
                    num[0] = 0;
                    Log.e("Thread에서 count == 6","");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            randomQuiz.setText("퀴즈가 종료되었습니다!");
                            quiz.setText("총 점수 : "+ score);
                        }
                    });
//                    randomQuiz.setText("퀴즈가 종료되었습니다!");
//                    quiz.setText("총 점수 : "+ score);
//                    Toast.makeText(RandomQuiz.this, "게임이 끝났습니다!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        // postDelay
        // run으로 때리기
    });
//    thread.start();






//    public void countTimer() {
//
//        second = 5;
//
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                timer = new Timer();
//                timerTask = new TimerTask() {
//
//                    @Override
//                    public void run() {
//
//                        while (second != 0) {
////                    랜덤 퀴즈를 시작합니다!에 초수 띄워주기
//                            second --;
////                    randomQuiz.setText("타이머 : " + second);
//                        }
//                        if (second <= 10 && second <= 30) {
//                            randomQuiz.setText("타이머 : " + second);
//                        }
//                        if (second <= 9) {
//                            randomQuiz.setText("타이머 : 0" + second);
//                        } else {
//                            randomQuiz.setText(Integer.toString(second));
//                        }
//                        if (second == 0) {
//                            quiz.setText("퀴즈가 종료되었습니다!\n총 점수 : " + score + "점");
////                            Toast.makeText(RandomQuiz.this, "게임이 끝났습니다!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                };
//                timer.schedule(timerTask, 0, 1000);
//            }
//        }, 0);
//
//    }


}