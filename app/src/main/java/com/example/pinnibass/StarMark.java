package com.example.pinnibass;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarMark extends AppCompatActivity {

    private RecyclerView starRecyclerView;
    private StarAdapter adapter;
    private ArrayList<NewStudyItem> LikeList;
    String write;

    public StudyItemManager studyItemManager;


    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_mark);
        Log.e("즐겨찾기", "onCreate");




        studyItemManager = (StudyItemManager) getIntent().getSerializableExtra("studyItemManager");

        shared = getSharedPreferences("pref"
                , Activity.MODE_PRIVATE);
        editor = shared.edit();



        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this);

//        starRecyclerView.setLayoutManager(layoutManager);

        starRecyclerView = (RecyclerView)findViewById(R.id.recyclerView_star);

        adapter = new StarAdapter(getApplicationContext(), shared, editor, studyItemManager);

        starRecyclerView.setAdapter(adapter);
        starRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        starRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        LikeList = new ArrayList<>(); //힙 영역 주소값 생성

//
//
//        LikeList = studyItemManager.getLikeList();
//




        LikeList = (ArrayList<NewStudyItem>)
                getIntent().getSerializableExtra("LikeList");

        Log.e("즐겨찾기에서 LikeList의 Content를 가져왔니?", "" + LikeList);





        adapter.setLikeList(LikeList,getApplicationContext()); //staritems가 갖고 있는 집 주소를 star어댑터에 알려줌]


        Button starbackBtn = (Button)findViewById(R.id.starBack);
        starbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent
                        (getBaseContext(), Studyroom.class);


                intent.putExtra("LikeList", LikeList);

                Log.e("즐겨찾기 룸에서 스터디룸으로 보내는 즐겨찾기 배열 : ","" + LikeList);

//                name = "Miro";
//                intent.putExtra("name", name);
//                Log.d("입문 수업 방에서 피니를 미로로 바꿨어", "" + name);

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }


}