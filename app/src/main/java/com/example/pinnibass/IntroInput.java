package com.example.pinnibass;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;

public class IntroInput extends AppCompatActivity {

    EditText inputName;


    EditText inputCity; // 지역 Spinner 사용해야 해
    EditText inputGrade; // 등급 Spinner 사용해야 해


    String nameIn;


    String cityIn;
    String gradeIn;
    String cityInput;
    String gradeInput;


//    int position;
    int profileIn = 0;
    String profileUrl;

    ImageView profileSet;
    ImageView profile;

    final int camera = 100;
    final int gallery = 101;

    MainActivity mainActivity;


    Spinner citySpinner;
    Spinner gradeSpinner;


    String[] cityItem = {"지역 (선택)", "서울", "경기", "인천", "대구", "부산", "광주", "울산",
            "대전", "세종", "강원", "충북", "충남", "전북", "전남",
            "경북", "경남", "제주", "해외", "기타 (직접입력)"};
    String[] gradeItem = {"등급 (선택)", "입문", "초급", "중급", "전공", "프로", "기타 (직접입력)"};

    public IntroInput() {

    }

//    public IntroInput(String nameIn, String gradeIn, String cityIn, int profileIn) {
//        this.nameIn = nameIn;
//        this.gradeIn = gradeIn;
//        this.cityIn = cityIn;
//        this.profileIn = profileIn;
//    }

    SharedPreferences shared;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_input);
        Log.e("유저 정보 입력하기", "onCreate");

        checkSelfPermission();

        shared = getSharedPreferences("userShared", Activity.MODE_PRIVATE);
        editor = shared.edit();

        nameIn = shared.getString("nameIn", null);
        gradeIn = shared.getString("gradeIn", null);
        cityIn = shared.getString("cityIn", null);
        profileIn = shared.getInt("profileIn", 0);

        inputName = findViewById(R.id.userName);

        inputCity = findViewById(R.id.userCity); // 지역 Spinner
        inputGrade = findViewById(R.id.userGrade); // 등급 Spinner


        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>
                            (this, android.R.layout.simple_spinner_item, cityItem);
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>
                            (this, android.R.layout.simple_spinner_item, gradeItem);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        citySpinner = findViewById(R.id.citySpinner);
        gradeSpinner = findViewById(R.id.gradeSpinner);

        citySpinner.setAdapter(cityAdapter);
        gradeSpinner.setAdapter(gradeAdapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputCity.setText(cityItem[position]);
                cityInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                inputCity.setText("지역");
            }
        });
        gradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputGrade.setText(gradeItem[position]);
                gradeInput = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                inputGrade.setText("등급");
            }
        });


        profileSet = (ImageView) findViewById(R.id.profileSet);
        profile = (ImageView) findViewById(R.id.profileImage);
        SlicedImg(this,"https://i.pinimg.com/564x/97/71/95/9771956e11b160af17d75684a9bfa6ec.jpg",profile);
//        Glide.with(this).load("https://i.pinimg.com/564x/97/71/95/9771956e11b160af17d75684a9bfa6ec.jpg")
//                                  .placeholder(getDrawable(R.drawable.ic_launcher_background))
//                                  .into(profile);

        inputName.setText(nameIn);
        inputGrade.setText(gradeInput);
        inputCity.setText(cityInput);
        profile.setImageResource(profileIn);

        Button welcomeBtn = (Button) findViewById(R.id.welcomeBtn);

        welcomeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view.getId() == R.id.welcomeBtn) {
//                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                    Bitmap bitmap = ((BitmapDrawable)profile.getDrawable()).getBitmap();
//                    float scale = (float) (1024/(float)bitmap.getWidth());

//                    profileUrl = SlicedImg(getBaseContext(),
//                            "https://i.pinimg.com/564x/97/71/95/9771956e11b160af17d75684a9bfa6ec.jpg",
//                            profile).toString();
                            
                    
                    // 이미지도 shared에 넣고 싶은데 ..
//                    profileIn = Integer.parseInt(profile.toString());
//                    앱 Stop


                    Intent intent = new Intent(getBaseContext(), MainActivity.class);

                    nameIn = inputName.getText().toString();
                    gradeIn = inputGrade.getText().toString();
                    cityIn = inputCity.getText().toString();

                    try {
                        profileIn = Integer.parseInt(profile.toString());
                    } catch (NumberFormatException nfe) {
                        System.out.println("Could not parse " + nfe);
                    }

                    intent.putExtra("name", nameIn);
                    intent.putExtra("grade", gradeInput);
                    intent.putExtra("city", cityInput);
                    intent.putExtra("profile", profileIn);

//                    nameIn = inputName.getText().toString();
//                    gradeIn = inputGrade.getText().toString();
//                    cityIn = inputCity.getText().toString();

//                    String[] arrayStr = myStr.split(",");

//                    for(int i = 0; i < arrayStr.length; i++){
//                        System.out.println(arrayStr[i]);

                    editor.putString("nameIn", nameIn);
                    editor.putString("gradeIn", gradeIn);
                    editor.putString("cityIn", cityIn);
                    editor.putInt("profileIn", profileIn);
                    editor.commit();

                    startActivity(intent);
                }
            }
        });





        profileSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(getBaseContext(), GetImage.class);
//
//                startActivity(intent);

                    Intent intent = new Intent();
                    //기기 기본 갤러리 접근
                    intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                    //구글 갤러리 접근
                    //intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,101);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.e("유저 정보 입력하기", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.e("유저 정보 입력하기", "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.e("유저 정보 입력하기", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.e("유저 정보 입력하기", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("유저 정보 입력하기", "onDestroy");
    }




        public void checkSelfPermission() {

        String temp = "";

        // 파일 읽기 권한 확인
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.READ_EXTERNAL_STORAGE + " ";
        }

        // 파일 쓰기 권한 확인
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " ";
        }

        if (!TextUtils.isEmpty(temp)) {
            // 권한 요청
            ActivityCompat.requestPermissions(this, temp.trim().split(" "),1);
        } else {
            // 모두 허용 상태
            Toast.makeText(this, "권한을 모두 허용", Toast.LENGTH_SHORT).show();
        }
    }




    //권한에 대한 응답이 있을때 작동하는 함수
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //권한을 허용 했을 경우
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    // 동의
                    Log.d("MainActivity", "권한 허용 : " + permissions[i]);
                }
            }
        }
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            try {
                InputStream is = getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                is.close();
                profile.setImageBitmap(bm);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == 101 && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
        }
    }

    public void SlicedImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().circleCrop())
                .into(profile);
    }


//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        inputCity.setText(cityItem[position]);
//        if(inputCity.getText().toString().equals("")) {
//            inputCity.setText("");
//        }
//
//        inputGrade.setText(gradeItem[position]);
//        if(inputGrade.getText().toString().equals("")) {
//            inputGrade.setText("");
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        inputCity.setText("");
//        inputGrade.setText("");
//    }
} // class 끝나는 중괄호호