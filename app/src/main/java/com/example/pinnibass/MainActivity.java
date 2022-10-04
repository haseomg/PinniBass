package com.example.pinnibass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player = new MediaPlayer();
    int position = 0;

    TextView nameMain;
    TextView gradeMain;

    ImageView profileMain;
    ImageView profileSetMain;
    ImageView volume = null;

    int i = 0;
    int p = 0;

    TextView insta;

    String mainName;
    String mainGrade;
    String mainCity;
    int mainProfile;

    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("메인 화면 [HOME]", "onCreate");






        // 공부방에서 돌아올 때 런쳐로 인해 기록으로 돌아와서 다시 startActivity 되기 때문에 음악이 다시 재생 됨
        // 다시 돌아올 때마다 player == null 그래서 계속 재생 됨

        Log.e("MainActivity의 OnCreate 시","재생 전 player의 값 : " + player); // null
        Log.e("MainActivity의 OnCreate 시","재생 전 playAudio() : " + playAudio());

        resumeAudio();

//        if (player == null) {
//            stopAudio();
//            Log.e("MainActivity","stopAudio : ");
//        }
        // 첫번째 음원 이후, 공부방 다녀왔을 때는 재생된 음원이 버튼 클릭 먹음
        // 그럼 첫번째 playAudio는 ..? 도대체 ...?
//       if (player != null) {
//            stopAudio();
//            Log.e("MainActivity","playAudio() 1 : " + player);
//        }
       if (!player.isPlaying()) {
           playAudio();
           Log.e("MainActivity","playAudio() 2 : " + player);
       }
//        if (!playAudio()) {
//            stopAudio();
//            Log.e("MainActivity","playAudio() 3 : " + player);
//        }


        Log.e("MainActivity의 OnCreate 시","재생 후 player의 값 : " + player); // 값 들어감
        Log.e("MainActivity의 OnCreate 시","재생 후 playAudio() : " + playAudio());




        shared = getSharedPreferences("userShared", Activity.MODE_PRIVATE);
        editor = shared.edit();

        // String
        mainName = shared.getString("nameIn", null);
        mainGrade = shared.getString("gradeIn",null);
        mainCity = shared.getString("cityIn", null);

        mainProfile = shared.getInt("profileIn", 0);

        nameMain = findViewById(R.id.mainName);
        gradeMain = findViewById(R.id.mainGrade);

        profileMain = findViewById(R.id.mainProfile);
        SlicedImg(this,"https://i.pinimg.com/564x/97/71/95/9771956e11b160af17d75684a9bfa6ec.jpg",profileMain);

        volume = findViewById(R.id.volume);
        profileSetMain = findViewById(R.id.mainProfileSet);

        String urlInstagram = "<a href='https://www.instagram.com/haseomg/'> instagram @haseomg </a><br>";

        insta = findViewById(R.id.insta);
        insta.setLinksClickable(true);
        insta.setMovementMethod(LinkMovementMethod.getInstance());

        insta.setText(Html.fromHtml(urlInstagram));

        nameMain.setText(mainName);
        gradeMain.setText(mainGrade);

        profileMain.setImageResource(mainProfile);

        Log.e("MainActivity name","" + mainName);


        // 넘어가서 유저 정보에서 완료를 누르면 메인음악 다시 재생되고, 쉐어드도 확인해봐야해 ! !
        // 버튼 눌렀을 때 IntroInput 액티비티에 지역이랑 등급 못 뿌려줌
        profileSetMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), IntroInput.class);

                mainName = nameMain.getText().toString();
                mainGrade = gradeMain.getText().toString();

                intent.putExtra("name", mainName);
                intent.putExtra("grade", mainGrade);
                intent.putExtra("city", mainCity);
                intent.putExtra("profile", mainProfile);

                editor.putString("nameIn", mainName);
                editor.putString("gradeIn", mainGrade);
                editor.putString("cityIn", mainCity);
                editor.putInt("profileIn", mainProfile);
                editor.commit();

                startActivity(intent);
            }
        });



        Button gameBtn = findViewById(R.id.gameClick);
        gameBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent
                        (getBaseContext(), Gameroom.class);

                startActivity(intent);
            }
        });


        Button studyBtn = findViewById(R.id.studyClick);
        studyBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent
                        (getBaseContext(), Studyroom.class);

                startActivity(intent);
            }
        });


        Button testBtn = findViewById(R.id.testClick);
        testBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent
                        (getBaseContext(), Testroom.class);

                startActivity(intent);
            }
        });
        // 1. 볼륨 아이콘 클릭시 노래 재생 (ok)
        // 2. 볼륨 아이콘 클릭시 음소거 아이콘으로 변경 (ok)
        // 3. 노래가 끝나면 다시 재생, 이건 어떻게 해야할까?

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1-i;

                if (i == 0) {
                    volume.setImageResource(R.mipmap.soundon);
                    resumeAudio();
                } else {
                    pauseAudio();
                    volume.setImageResource(R.mipmap.soundoff);
                }
                Log.e("MainActivity의 int i","" +i);
            }
        });
    }


    protected void onStart() {
        super.onStart();
        Log.e("메인 화면 [HOME]", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("메인 화면 [HOME]", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("메인 화면 [HOME]", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("메인 화면 [HOME]", "onStop");
//        pauseAudio();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("메인 화면 [HOME]", "onDestroy");
    }

    private boolean playAudio() {
        try {
            closePlayer();
            player = MediaPlayer.create(MainActivity.this,R.raw.main_mp3);
//            player.setLooping(true); // 계속 반복
            player.start();
            Toast.makeText(this, "메인 음악 재생 시작",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 일시정지
    private void pauseAudio() {
        if (player != null) {
            position = player.getCurrentPosition();
            player.pause();

            Toast.makeText(this, "메인 음악 일시정지",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 재시작
    private void resumeAudio() {
        if (player != null && !player.isPlaying()) {
            player.seekTo(position);
            player.start();

            Toast.makeText(this, "메인 음악 재시작",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 중지
    private void stopAudio() {
        if (player != null && player.isPlaying()) {
            player.stop();

            Toast.makeText(this, "메인 음악 중지",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // 녹음 시 마이크 리소스 제한.
    // 누군가가 lock 걸어놓으면 다른 앱에서 사용할 수 없음.
    // 따라서 꼭 리소스를 해제해주어야 함.
    public void closePlayer() {
        if (player != null) {
            player.release();
            player = null;
            Log.e("closePlayer 메서드에서 player = null;","player의 값은 ? : "+player);
            // null인 부분 때문에 계속 player가 null이 되었을까?
        }
    }

    public void SlicedImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().circleCrop())
                .into(profileMain);
    }


}