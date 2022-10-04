//package com.example.pinnibass;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class add_edit extends AppCompatActivity {
//
////    @Override
////    void OnClick (String value) {
////
////    }
//
//    NewStudyItem item;
//
//    StarAdapter adapter;
//    NewStudyAdapter newAdapter;
//    Context context;
//
//    ArrayList<NewStudyItem> LikeList;
//    ArrayList<NewStudyItem> NewStudyList;
//
//    //수업방의 별버튼 누르면 넘어올 곳
//    //1.수업룸의 별 버튼을 누르면 이 액티비티에 수업 배열의 데이터를 뿌려준다.
//    //2. 별 버튼을 누르면 이 액티비티가 실행된다.
//    //3. 완료 버튼을 누르면 즐겨찾기 방에 즐겨찾기 배열을 뿌려준다.
//
//    TextView cNum, cTitle;
//    EditText cWrite;
//
//    Button ok, no;
//
//    String name = "name";
//    String comment = "comment";
//    String write = "write";
//
//    private ActivityResultLauncher<Intent> launcer;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_edit);
//        Log.e("애드에딧 룸입니다", "onCreate");
//
//        newAdapter = new NewStudyAdapter();
//        adapter = new StarAdapter();
//
//        newAdapter.setNewStudyList(NewStudyList);
//        adapter.setLikeList(LikeList);
//
//
//        NewStudyItem item = new NewStudyItem(name, comment);
//
//        cNum = findViewById(R.id.cNum);
//        cTitle = findViewById(R.id.cTitle);
//        cWrite = findViewById(R.id.cWrite);
//
//        ok = findViewById(R.id.ok);
//        no = findViewById(R.id.no);
//
//        Intent receive_intent = getIntent();
//
//        String temp1 = receive_intent.getStringExtra("name");
//        String temp2 = receive_intent.getStringExtra("comment");
//
//        cNum.setText(temp1);
//        cTitle.setText(temp2);
//
////        cNum.setText(item.getName()); //이건 안됨 데이터 못 받아옴
//        Log.e("애드에딧의 cNum","" + temp1);
////        cTitle.setText(item.getComment());
//        Log.e("애드에딧의 cTitle","" + temp2);
//
//
////        NewStudyAdapter.ItemClickListener itemClickListener;
//
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){ //완료하면 입문자룸에 즐겨찾기 배열 추가 (별버튼에서 가져와)
//
//                Intent intent = new Intent
//                        (getBaseContext(), NewStudy.class);
//
////                LikeList.add(new NewStudyItem
////                        (name, comment, write));
//
////                write = cWrite.getText().toString();
//
//                intent.putExtra("LikeList", LikeList);
//
////                int lastIndex = LikeList.size() - 1;
////
////                Log.e("LikeList가 전달받은 index에 있는 값을 리턴한다.",
////                            "LikeList.get : " + LikeList.get(lastIndex).getName()
////                                    +LikeList.get(lastIndex).getComment());
////              Log.e("LikeList의 주소값", " " + LikeList);
////
////
////                Log.e("LikeList 배열의 마지막 인덱스 값", "int lastIndex : " + lastIndex);
////
////                     .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//
//                Log.e("애드에딧에서 공부방으로 보내는 즐겨찾기 배열 : ","" + LikeList);
//
//                launcer.launch(intent);
//
////                finish();
//
////                ((Activity)context).finish(); //액티비티 종료
//            }
//        });
//
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                finish();
//            }
//        });
//
//        ActivityResultLauncher<Intent> launcer = registerForActivityResult
//                (new ActivityResultContracts.StartActivityForResult(),
//                        new ActivityResultCallback<ActivityResult>() {
//                            @Override
//                            public void onActivityResult(ActivityResult data) {
//                                Log.e("add_edit -", "OnActivityResult : " + data); {
//
//                                    if (data.getResultCode() == Activity.RESULT_OK) {
//                                        Intent intent = data.getData();
////                                        String name = intent.getStringExtra("name");
//
//                                        LikeList = (ArrayList<NewStudyItem>)
//                                                intent.getSerializableExtra("NewStudyList");
////                                    Log.e("입문자 수업룸에서 받은 즐겨찾기 배열 : ","" + LikeList);
////                                    Log.e("입문자 수업룸에서 다시 돌아와 받은 즐겨찾기 배열 : ","" + LikeList.get(0).getName());
////                                    Log.e("입문자 수업룸에서 다시 돌아와 받은 즐겨찾기 배열 : ","" + LikeList.get(0).getComment());
////                                    Log.e("입문자 수업룸에서 다시 돌아와 받은 즐겨찾기 배열 : ","" + LikeList.get(1).getName());
////                                    Log.e("입문자 수업룸에서 다시 돌아와 받은 즐겨찾기 배열 : ","" + LikeList.get(1).getComment());
////                                    Log.e("스터디룸의 즐겨찾기배열 사이즈는? : ","" + LikeList.size());
//
//
//
////                                    Log.e("Studyroom -",
////                                            "ActivityResult 추가 후 name의 값 :" + name);
//                                    }
//                                }
//                            }
//                        });
//
//
//    }
//
////
////    @Override
////    public void onClick(String value) {
////
////    }
//}