package com.example.pinnibass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Studyroom extends AppCompatActivity {

    private StarAdapter adapter;

    ArrayList<NewStudyItem> LikeList = new ArrayList<NewStudyItem>();
    ArrayList<NewStudyItem> LikeListTemp = new ArrayList<NewStudyItem>();

    public StudyItemManager studyItemManager;


    Context context;

    SharedPreferences shared;
    SharedPreferences.Editor editor;

    MainActivity mainActivity;

//    String name = "Pinni";

    String Write;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyroom);

        studyItemManager = new StudyItemManager();


        shared = getSharedPreferences("pref"
                , Activity.MODE_PRIVATE);
        editor = shared.edit();

        context = this;

        // 초기 구동시 배열이 없을때 불러온다
        if (LikeList.size() == 0) {

            String textArrayTemp;


            textArrayTemp = shared.getString("LikeList", null);

            // split
            if (textArrayTemp != null) {
                String textArray[] = textArrayTemp.split("@#@#");




//                Log.e("Studyroom",""+i);

                LikeList.clear();

                if (textArray.length > 1) {
                    // 이름,코맨트,내용,즐겨찾기내용) 0,1,2,3,4 / 5,6,7,8,9
                    for (int i = 0; i < textArray.length; i += 5) {


                        NewStudyItem newStudyItem = new NewStudyItem();

                        newStudyItem.setName(textArray[i]);
                        newStudyItem.setComment(textArray[i + 1]);
                        newStudyItem.setLikeComment(textArray[i + 2]);
                        newStudyItem.setContent(textArray[i + 3]);
                        if (textArray[i + 4].equals("true")) {
                            newStudyItem.setLike(true);
                            System.out.println("True CHeck@@@");
                        } else {
                            newStudyItem.setLike(false);
                        }

                        LikeList.add(newStudyItem);

                    }


                    // 붙혀주는 게 contains
                   for(NewStudyItem newStudyItem : LikeList){
                       if(!LikeListTemp.contains(newStudyItem)){
                           LikeListTemp.add(newStudyItem);
                       }
                   }

                   for(int i = 0; i <LikeListTemp.size(); i++){
                       System.out.println("Check Like Num : " + LikeListTemp.get(i).getLike()+ ":: " + i);
                   }


                    studyItemManager.setLikeList(LikeListTemp);
                    LikeList = LikeListTemp;
                    System.out.println("라이크 리스트 사이트 확인 : " + LikeListTemp.size());
                }
            }
        }

        Log.e("공부 방", "onCreate");

        Log.e("스터디룸의 LikeList의 주소값은? : ", "" + LikeListTemp.size());

        adapter = new StarAdapter(getApplicationContext(), shared, editor, studyItemManager);

        context = getApplicationContext();

        adapter.setLikeList(LikeList, context);

        Log.e("스터디룸의 OnCreate 메서드 안 입니다.", "LikeList가 갖고있는 것은?" + LikeList);


        Button starBtn = (Button) findViewById(R.id.starMark);
        starBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent
                        (getBaseContext(), StarMark.class);

                // 데이터 유지하ㄱ
                ArrayList<NewStudyItem> starMarkArr = new ArrayList<>();

                for(int i = 0; i < LikeList.size(); i++){
                    if(LikeList.get(i).getLike()){
                        starMarkArr.add(LikeList.get(i));
                    }
                }


                intent.putExtra("LikeList", starMarkArr);

                Log.e("공부방에서 즐겨찾기룸으로 보내는 즐겨찾기 배열 : ", "" + LikeList);

                launcer.launch(intent);
            }
        });


        // 재생 문제
        Button studyBack = (Button) findViewById(R.id.studyRoomBack);
        studyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getBaseContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                launcer.launch(intent);
                finish();
            }
        });


        Button newbtn = (Button) findViewById(R.id.newcomer);
        newbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent
                        (getBaseContext(), NewStudy.class);

//                LikeList.add(new NewStudyItem("Pinni","27", false));
//                LikeList.add(new NewStudyItem("Miro", "27", false));
                intent.putExtra("LikeList", LikeList);
                intent.putExtra("studyItemManager", studyItemManager);
                intent.putExtra("grade", "newComer");


                launcer.launch(intent);

            }
        });

        Button beginBtn = (Button) findViewById(R.id.beginner);
        beginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getBaseContext(), NewStudy.class);

//                LikeList.add(new NewStudyItem("Pinni","27", false));
//                LikeList.add(new NewStudyItem("Miro", "27", false));
                intent.putExtra("LikeList", LikeList);
                intent.putExtra("studyItemManager", studyItemManager);
                intent.putExtra("grade", "beginner");
                Log.e("스터디룸에서 입문자 수업룸으로 보내는 즐겨찾기 배열 : ", "" + LikeList);

                launcer.launch(intent);
            }
        });

        Button interBtn = (Button) findViewById(R.id.Inter);
        interBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (getBaseContext(), NewStudy.class);

                intent.putExtra("LikeList", LikeList);
                intent.putExtra("studyItemManager", studyItemManager);
                intent.putExtra("grade", "intermediate");
//                Log.e("스터디룸에서 입문자 수업룸으로 보내는 즐겨찾기 배열 : ","" + LikeList);

                launcer.launch(intent);
            }
        });


//        Log.i("---","---");
//        Log.d("//===========//","================================================");
//        Log.i("","[스터디룸의 OnCreate 메서드가 갖고있어 ! name의 값은? : " + name);
//        Log.d("//===========//","================================================");
//        Log.i("---","---");


    }


    // 액티비티끼리 서로 데이터를 주고받아야할 때 사용
    ActivityResultLauncher<Intent> launcer = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult data) {
                            Log.e("Studyroom -", "OnActivityResult : " + data);
                            {

                                if (data.getResultCode() == Activity.RESULT_OK) {
                                    Intent intent = data.getData();
                                    Write = intent.getStringExtra("newWrite");

                                    LikeList = (ArrayList<NewStudyItem>)
                                            intent.getSerializableExtra("LikeList");
                                }
                            }
                        }
                    });


    protected void onStart() {
        super.onStart();
        Log.e("공부 방", "onStart");

//        Log.d("공부 방","onStart : " + name);
        Log.e("스터디룸의 LikeList의 주소값은? : ", "" + LikeList.size());
    }


    protected void onResume() {
        super.onResume();
        Log.e("공부 방", "onResume");

//        Log.d("공부 방","onResume : " + name);

    }


    protected void onPause() {
        super.onPause();
        Log.e("공부 방", "onPause");

//        if (mainActivity.player != null) {
//            mainActivity.player.stop();
//            Log.e("Studyroom에서 Main으로 돌아갈 때","");
//        }
    }


    protected void onStop() {
        super.onStop();
        Log.e("공부 방", "onStop");
    }


    protected void onDestroy() {
        super.onDestroy();
        Log.e("공부 방", "onDestroy");
    }
}
