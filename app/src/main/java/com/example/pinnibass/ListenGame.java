package com.example.pinnibass;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Scanner;

public class ListenGame extends AppCompatActivity {

    MediaPlayer player;
    int position = 0;

    Button listenBack;
    Button playBtn;
    Button doBtn, reBtn, miBtn, faBtn, solBtn, laBtn, siBtn, doBtn2;
    TextView listenGameMain;

    Scanner scan = new Scanner(System.in);
    Random ran = new Random();
    int ok;
    int select;
    int choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_game);
        Log.e("청음 게임", "onCreate");

        playScale();

        listenGameMain = findViewById(R.id.listenGameMain);
        doBtn = findViewById(R.id.doBtn);
        reBtn = findViewById(R.id.reBtn);
        miBtn = findViewById(R.id.miBtn);
        faBtn = findViewById(R.id.faBtn);
        solBtn = findViewById(R.id.solBtn);
        laBtn = findViewById(R.id.laBtn);
        siBtn = findViewById(R.id.siBtn);
        doBtn2 = findViewById(R.id.doBtn2);

        listenBack = findViewById(R.id.listenBackBtn);
        listenBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomListen();
                //  버튼 클릭시 8개의 음 중 랜덤으로 한 음을 출력한다.

//                if (ok == 1) {
//                    Log.e("낮은 도","");
//                    if (v.getId() == R.id.doBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 2) {
//                    Log.e("레","");
//                    if (v.getId() == R.id.reBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 3) {
//                    Log.e("미","");
//                    if (v.getId() == R.id.miBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 4) {
//                    Log.e("파","");
//                    if (v.getId() == R.id.faBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 5) {
//                    Log.e("솔","");
//                    if (v.getId() == R.id.solBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 6) {
//                    Log.e("라","");
//                    if (v.getId() == R.id.laBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 7) {
//                    Log.e("시","");
//                    if (v.getId() == R.id.siBtn) {
//                        Log.e("정답!","");
//                    }
//                }
//                if (ok == 8) {
//                    Log.e("높은 도","");
//                    if (v.getId() == R.id.doBtn2) {
//                        Log.e("정답!","");
//                    }
//                }


//                if (v.getId() == R.id.doBtn) {
//                    if (ok == 1) {
//                        playLowDo();
//                        Log.e("낮은 도 클릭!","");
//                    }
//                } if (v.getId() == R.id.reBtn) {
//                    if (ok == 2) {
//                        playRe();
//                        Log.e("레 클릭!","");
//                    }
//                } if (v.getId() == R.id.miBtn) {
//                    if (ok == 3) {
//                        playMi();
//                        Log.e("미 클릭!","");
//                    }
//                } if (v.getId() == R.id.faBtn) {
//                    if (ok == 4) {
//                        playFa();
//                        Log.e("파 클릭!","");
//                    }
//                } if (v.getId() == R.id.solBtn) {
//                    if (ok == 5) {
//                        playSol();
//                        Log.e("솔 클릭!","");
//                    }
//                } if (v.getId() == R.id.laBtn) {
//                    if (ok == 6) {
//                        playLa();
//                        Log.e("라 클릭!","");
//                    }
//                } if (v.getId() == R.id.siBtn) {
//                    if (ok == 7) {
//                        playSi();
//                        Log.e("시 클릭!","");
//                    }
//                } if (v.getId() == R.id.doBtn2) {
//                    if (ok == 8) {
//                        playHighDo();
//                        Log.e("높은 도 클릭!","");
//                    }
//                }
            }
        });



        // 목숨 개념 넣어줘야 함
        doBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playLowDo();
                if (ok == 1) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRe();
                if (ok == 2) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMi();
                if (ok == 3) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playFa();
                if (ok == 4) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        solBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSol();
                if (ok == 5) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        laBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playLa();
                if (ok == 6) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        siBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSi();
                if (ok == 7) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        doBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playHighDo();
                if (ok == 8) {
                    Toast.makeText(ListenGame.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListenGame.this, "땡! 오답입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void onStart() {
        super.onStart();
        Log.e("청음 게임", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("청음 게임", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("청음 게임", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("청음 게임", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("청음 게임", "onDestroy");
    }




    private void playScale() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.c_major_scale);
            player.start();
            Toast.makeText(this, "C Major Scale 재생",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playLowDo() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.low_do);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playRe() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.re);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playMi() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.mi);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playFa() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.fa);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playSol() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.sol);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playLa() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.la);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playSi() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.si);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playHighDo() {
        try {
            closePlayer();
            player = MediaPlayer.create(ListenGame.this,R.raw.high_do);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closePlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void randomListen() {
        int check = 0;

        if (check != 2) {
            Log.e("ListenGame에서 check가 2가 아닌 동안 반복한다.", "check의 값은? : " + check);

            ok = ran.nextInt(8) + 1;

            // 8개의 음 중 한 개를 랜덤으로 출력할 것이다. (ok)

            // 도일 때 만약 도 버튼이나 다른 버튼을 클릭한다면?
            // 1. 도 버튼 == 정답입니다! 애니메이션 효과!
            // 2. 나머지 버튼 == 음이 높습니다! 애니메이션 효과!
            // 2-1. 한번 더 들려주고 정답입니다! 애니메이션 효과!
            // 2-2. DDANG 정답은 도 입니다! 애니메이션 효과!

            if (ok == 1) {
                playLowDo();
            } else if (ok == 2) {
                playRe();
            } else if (ok == 3) {
                playMi();
            } else if (ok == 4) {
                playFa();
            } else if (ok == 5) {
                playSol();
            } else if (ok == 6) {
                playLa();
            } else if (ok == 7) {
                playSi();
            } else if (ok == 8) {
                playHighDo();
            }

//            System.out.println("ReGame !?"); // 애니메이션 효과
//            System.out.println();
//            System.out.println("1. YES 2.NO");
//            System.out.println();
//            check = scan.nextInt();
            if (check == 2) {
                Log.e("ListenGame에서 check == 2 조건","check의 값은? : " + check);
            }

        }
    }
}
