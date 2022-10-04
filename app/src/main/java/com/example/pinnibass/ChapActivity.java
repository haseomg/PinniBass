package com.example.pinnibass;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChapActivity extends AppCompatActivity {

    TextView contentTextView;
    Button backBtn;

    String contentText;
//    String studyChapter = "공부 합시다!";

//    NewChap newChap = new NewChap();
//    StringBuilder result = new StringBuilder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chap);

        contentTextView = (TextView) findViewById(R.id.ChapActivity_Text);
        backBtn = (Button) findViewById(R.id.ChapActivity_Btn);

        contentText = getIntent().getStringExtra("content");

        contentTextView.setText(contentText);


//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < studyChapter.length(); i++) {
//                    try {
//                        Bundle bundle = new Bundle();
//                        studyChapter = newChap.getNewChapComments().
//                                get();
//                        String cut = String.valueOf(studyChapter.charAt(i));
//                        bundle.putString("content", String.valueOf(result.append(cut)));
//
//                        Message msg = handler.obtainMessage();
//                        msg.setData(bundle);
//
//                        handler.sendMessage(msg);
//                        Thread.sleep(100);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

//    }
//    @SuppressLint("HandlerLeak")
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            String content = msg.getData().getString("content");
//            contentTextView.setText(content);
//        }


    };
}