package com.example.pinnibass;

import android.app.Activity;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class NewStudy extends AppCompatActivity implements Serializable {

    private RecyclerView recyclerView;
    private NewStudyAdapter adapter;

    private ArrayList<NewStudyItem> NewStudyList;
    private ArrayList<NewStudyItem> LikeList;

    public StudyItemManager studyItemManager;


    SharedPreferences shared;
    SharedPreferences.Editor editor;

    String grade;

    String write;

    Button newBack;

    String name;
    String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_study);

        setView();

    }

    protected void onResume() {
        super.onResume();
        Log.e("입문 수업 방", "onResume");

        Button newbackBtn = (Button) findViewById(R.id.newStudyBack);
        newbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent
                        (getBaseContext(), Studyroom.class);
//
//                intent.putExtra("write", write);
//                intent.putExtra("LikeList", LikeList);

                studyItemManager.setLikeList(LikeList);
                intent.putExtra("studyItemManager", studyItemManager);

                startActivity(intent);

                Log.e("입문자 수업룸에서 스터디룸으로 보내는 즐겨찾기 배열 : ", "" + LikeList);
//                setResult(RESULT_OK, intent);

                finish();

            }
        });

    }

    ActivityResultLauncher<Intent> launcer = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult data) {
                            Log.e("NewStudy -", "OnActivityResult : " + data);
                            {

                                if (data.getResultCode() == Activity.RESULT_OK) {
                                    Intent intent = data.getData();
                                    name = intent.getStringExtra("name");

                                    intent.putExtra("studyItemManager", studyItemManager);

                                }
                            }
                        }
                    });

    // onCreate() 에 이 메서드 한 줄만 있다.
    public void setView() {
        // set View
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        setVariable();

    }

    public void setVariable() {
        shared = getSharedPreferences("pref"
                , Activity.MODE_PRIVATE);
        editor = shared.edit();

        grade = getIntent().getStringExtra("grade");


        NewStudyList = new ArrayList<>();
        studyItemManager = (StudyItemManager) getIntent().getSerializableExtra("studyItemManager");

        if (studyItemManager.getLikeList().size() != 0) {
            LikeList = studyItemManager.getLikeList();
        } else {
            LikeList = (ArrayList<NewStudyItem>)
                    getIntent().getSerializableExtra("LikeList");
        }

        adapter = new NewStudyAdapter(this, shared, editor, studyItemManager);



        setRecyclerView();
    }

    public void setRecyclerView() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


        if (grade.equals("newComer")) {
            loadNewComer();
        } else if (grade.equals("beginner")) {
            loadBeginner();
        } else if (grade.equals("intermediate")) {
            loadIntermediate();
        }


    }

    public void loadNewComer() {
        studyItemManager.setNewChapData();

        if(LikeList.size() != 0){
            NewStudyList = LikeList;
        }
        int p = 1;
        for (int i = 0; i < studyItemManager.newChap.getNewChapComments().size(); i++) {

            NewStudyList.add(new NewStudyItem(studyItemManager.newChap.getGradeTitle()
                    + " ["
                    + p
                    + "]", studyItemManager.newChap.getNewChapComments().get(i).getComment()
                    , null, false, null));
            p++;
        }




        adapter.setStudyList(NewStudyList);
        adapter.setLikeList(LikeList);

        adapter.notifyDataSetChanged();

    }

    public void loadBeginner() {
        studyItemManager.setBeginChapData();
        int p = 1;
        for (int i = 0; i < studyItemManager.newChap.getNewChapComments().size(); i++) {

            NewStudyList.add(new NewStudyItem(studyItemManager.newChap.getGradeTitle()
                    + " ["
                    + p
                    + "]", studyItemManager.newChap.getNewChapComments().get(i).getComment()
                    , null, false, null));
            p++;
        }

        adapter.setStudyList(NewStudyList);
        adapter.setLikeList(LikeList);

        adapter.notifyDataSetChanged();

    }

    public void loadIntermediate() {
        studyItemManager.setInterChapData();
        int p = 1;
        for (int i = 0; i < studyItemManager.newChap.getNewChapComments().size(); i++) {

            NewStudyList.add(new NewStudyItem(studyItemManager.newChap.getGradeTitle()
                    + " ["
                    + p
                    + "]", studyItemManager.newChap.getNewChapComments().get(i).getComment()
                    , null, false, null));
            p++;
        }

        adapter.setStudyList(NewStudyList);
        adapter.setLikeList(LikeList);

        adapter.notifyDataSetChanged();


    }
}



