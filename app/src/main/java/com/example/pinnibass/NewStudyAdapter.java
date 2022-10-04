package com.example.pinnibass;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class NewStudyAdapter extends RecyclerView.Adapter<NewStudyAdapter.ViewHolder>
        implements Serializable {

//    private static final int TYPE_ONE = 1;
//    private static final int TYPE_TWO = 2;

    ArrayList<NewStudyItem> NewStudyList = new ArrayList<NewStudyItem>();
    ArrayList<NewStudyItem> LikeList;

    ArrayList<NewStudyItem> LikeListTemp = new ArrayList<NewStudyItem>();

    SharedPreferences shared;
    SharedPreferences.Editor editor;


    public StudyItemManager studyItemManager;


//    Context context;

    String Name;
    String Comment;

    private Context context;

    NewStudyAdapter(Context context,
                    ArrayList<NewStudyItem> items) {

        this.context = context;
        NewStudyList = items;
    }


    //context, shared, editor
    public NewStudyAdapter(Context context, SharedPreferences shared, SharedPreferences.Editor editor, StudyItemManager studyItemManager) {
        this.context = context;
        this.shared = shared;
        this.editor = editor;
        this.studyItemManager = studyItemManager;
    }

    public NewStudyAdapter() {

    }

    public interface OnItemClick {
        void onClick(String value);
    }

    public static void main(String[] args) throws Exception {

        FileOutputStream fo = new FileOutputStream("obj.ser");
        ObjectOutputStream out = new ObjectOutputStream(fo);

        out.writeObject(new AAA());

        // 역직렬화
        FileInputStream fin = new FileInputStream("obj.ser");
        ObjectInputStream in = new ObjectInputStream(fin);

        AAA aaa = (AAA) in.readObject();    // 형 변환 해주어야 함

    }

    static class AAA {

    }


    @NonNull
    @Override
    /**
     * 리스트 아이템을 가져와서 레이아웃을 실체화 해줌
     * 실체화를 해주는 아이가 Inflater
     * **/
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_study, parent, false);
        ViewHolder vh = new ViewHolder(view, context);
        context = parent.getContext();
        vh.setStudyItemManager(studyItemManager);

        return vh;
    }


    public interface ItemClickListener {
        void onItemClick(int position);
    }

    public void setNewStudyList(ArrayList<NewStudyItem> list) {
        this.NewStudyList = list; //데이터를 받아왔다.
//        Log.e("LikeList의 배열 값이 0일 때","LikeList.get : "+LikeList.get(0).getName());
        notifyDataSetChanged();
    }


    /**
     * 액티비티에서 받아온 데이터를 바인딩해줌.
     **/
    @Override
    public void onBindViewHolder
    (@NonNull ViewHolder holder, int position) {

        NewStudyItem newStudyItem = NewStudyList.get(position);
        holder.setItem(newStudyItem);
        System.out.println("star Check : " + NewStudyList.get(position).getLike());
        if (newStudyItem.getLike()) {
            System.out.println("star Check : " + position);
            holder.star.setImageResource(R.mipmap.fullstar);
        }

//        holder.name.setText(newStudyItem.getName());
//        holder.comment.setText(newStudyItem.getComment());
    }

    public void addItem(NewStudyItem item) {
        NewStudyList.add(item);
    }

    public void setItems(ArrayList<NewStudyItem> items) {
        this.NewStudyList = items;
    }

    public NewStudyItem getItem(int position) {
        return NewStudyList.get(position);
    }

    public void setItem(int position, NewStudyItem item) {
        NewStudyList.set(position, item);
    }


    public void setStudyItemManager(StudyItemManager studyItemManager) {
        this.studyItemManager = studyItemManager;
    }

    /**
     * 리사이클러뷰 리스트 사이즈를 불러옴
     **/
    @Override
    public int getItemCount() {
//        Log.d ("getItemCount : "+NewStudyList.size());
        return NewStudyList.size();
    }

    public void setStudyList(ArrayList<NewStudyItem> list) {
        this.NewStudyList = list;
        //데이터를 받아왔다. 위 코드를 추가하면 뉴스터디의 수업배열과 같은 주소값이 나온다.

        //LikeList로 바꿔주면 수업방, 즐겨찾기 방 둘 다 데이터가 아무것도 안 뿌려진다.
        notifyDataSetChanged();

        Log.e("NewStudyList", "뉴스터디어댑터" + NewStudyList);
    }

    public void setStudyManager(StudyItemManager studyItemManager) {
        this.studyItemManager = studyItemManager;
    }

    public void setLikeList(ArrayList<NewStudyItem> list) {
        this.LikeList = list;
//        Log.e("NewStudyAdapter - ", "LikeItems의 주소값 : "+LikeList.toString());
    }


    /**
     * 뷰홀더 생성
     **/
    public class ViewHolder extends RecyclerView.ViewHolder {

        Context ctx;

        ImageButton star;

        TextView name, comment;

        EditText newWrite; //다이얼로그의 EditText newWrite

        String likeComment = "ㅈㅔㅂㅏㄹ.....";

        ItemClickListener itemClickListener;

        StudyItemManager studyItemManager;


        public ViewHolder(View view, Context context) {

            super(view);

            this.ctx = context;

            name = view.findViewById(R.id.name);
            comment = view.findViewById(R.id.comment);
            star = view.findViewById(R.id.star);


            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ctx, ChapActivity.class);

                    intent.putExtra("content", studyItemManager
                            .newChap
                            .getNewChapComments()
                            .get(getBindingAdapterPosition())
                            .getNewChapContents()
                            .get(0)
                            .getContents());

//                    String content = studyItemManager
//                            .newChap
//                            .getNewChapComments()
//                            .get(getBindingAdapterPosition())
//                            .getNewChapContents()
//                            .get(0)
//                            .getContents();
//                    Log.e("ddd", content);


                    ctx.startActivity(intent);

                    // 수업 제목 클릭하면 수업 꺼내오는 것

                }
            });


            star.setOnClickListener(new View.OnClickListener() {

                // 수업의 별 버튼 클릭
                @Override
                public void onClick(View view) {


                    if(NewStudyList.get(getBindingAdapterPosition()).getLike()){
                        AlertDialog.Builder builder
                                = new AlertDialog.Builder(ctx);


                        Name = name.getText().toString(); //다이얼로그에서 보여줌
                        Comment = comment.getText().toString();


                        builder.setTitle("즐겨찾기를 취소하시겠습니까?");
                        builder.setMessage("             " + Name + " " + Comment);


                        builder.setIcon(R.mipmap.ic_launcher);
                        newWrite = new EditText(ctx);
                        builder.setView(newWrite);


                        builder.setPositiveButton("완료",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        likeComment = newWrite.getText().toString();





//                                    // 엉뚱하게 적용 됨, 포지션 값 찾아
                                        star.setImageResource(R.mipmap.star);

                                        //스플릿때문에 처리
                                        if (likeComment == null) {
                                            likeComment = " ";
                                        }


                                        String content = studyItemManager
                                                .newChap
                                                .getNewChapComments()
                                                .get(getBindingAdapterPosition())
                                                .getNewChapContents()
                                                .get(0)
                                                .getContents();





//                                        LikeListTemp.clear();
//
//                                        for (int i = 0; i < NewStudyList.size(); i++) {
//                                            if (i == getBindingAdapterPosition()) {
//                                                System.out.println("Like true count");
//                                                LikeListTemp.add(new NewStudyItem
//                                                        (Name, Comment, likeComment, false, content));
//                                            } else {
//                                                LikeListTemp.add(new NewStudyItem(NewStudyList.get(i).getName()
//                                                        , NewStudyList.get(i).getComment(),
//                                                        NewStudyList.get(i).getLikeComment(),
//                                                        NewStudyList.get(i).getLike(), content));
//                                            }
//
//                                        }

                                        LikeList.clear();


                                        for(NewStudyItem newStudyItem : LikeListTemp){
                                            if(!LikeList.contains(newStudyItem)){
                                                LikeList.add(newStudyItem);
                                            }
                                        }


                                        System.out.println("ARR SIZE : " + LikeList.size());


                                        String sharedTextTemp = new String(); //null도 ㄱㅊ


                                        for (int i = 0; i < LikeList.size(); i++) {
                                            sharedTextTemp +=
                                                    LikeList.get(i).getName()
                                                            + "@#@#" + LikeList.get(i).getComment() //i번째
                                                            + "@#@#" + LikeList.get(i).getLikeComment()
                                                            + "@#@#" + LikeList.get(i).getContent()
                                                            + "@#@#" + LikeList.get(i).getLike()
                                                            + "@#@#";
                                        }


                                        editor.putString("LikeList", "");
                                        editor.commit();


                                        editor.putString("LikeList", sharedTextTemp);
                                        editor.commit();


                                        Log.e("뉴스터디 어댑터의 Name과 Comment", "" + Name + Comment);


                                        Toast.makeText(ctx, "즐겨찾기에 추가하였습니다.",
                                                Toast.LENGTH_SHORT).show();
                                        Log.e("뉴스터디 어댑터", "ctx : " + ctx);
                                    }
                                });

                        //  setNegativeButton -> "Cancel" 버튼  //
                        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ctx, "취소되었습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.show();      //대화상자(dialog)화면 출력
                    }else {

                        AlertDialog.Builder builder
                                = new AlertDialog.Builder(ctx);


                        Name = name.getText().toString(); //다이얼로그에서 보여줌
                        Comment = comment.getText().toString();


                        builder.setTitle("즐겨찾기에 추가하시겠습니까?");
                        builder.setMessage("             " + Name + " " + Comment);


                        builder.setIcon(R.mipmap.ic_launcher);
                        newWrite = new EditText(ctx);
                        builder.setView(newWrite);


                        builder.setPositiveButton("완료",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        likeComment = newWrite.getText().toString();





//                                    // 엉뚱하게 적용 됨, 포지션 값 찾아
                                        star.setImageResource(R.mipmap.fullstar);

                                        //스플릿때문에 처리
                                        if (likeComment == null) {
                                            likeComment = " ";
                                        }


                                        String content = studyItemManager
                                                .newChap
                                                .getNewChapComments()
                                                .get(getBindingAdapterPosition())
                                                .getNewChapContents()
                                                .get(0)
                                                .getContents();





                                        LikeListTemp.clear();

                                        for (int i = 0; i < NewStudyList.size(); i++) {
                                            if (i == getBindingAdapterPosition()) {
                                                System.out.println("Like true count");
                                                LikeListTemp.add(new NewStudyItem
                                                        (Name, Comment, likeComment, true, content));
                                            } else {
                                                LikeListTemp.add(new NewStudyItem(NewStudyList.get(i).getName()
                                                        , NewStudyList.get(i).getComment(),
                                                        NewStudyList.get(i).getLikeComment(),
                                                        NewStudyList.get(i).getLike(), content));
                                            }

                                        }

                                        LikeList.clear();


                                        for(NewStudyItem newStudyItem : LikeListTemp){
                                            if(!LikeList.contains(newStudyItem)){
                                                LikeList.add(newStudyItem);
                                            }
                                        }


                                        System.out.println("ARR SIZE : " + LikeList.size());








//                                    LikeList.add(new NewStudyItem
//                                            (Name, Comment, likeComment,true, content));


                                        //순서 = 이름, 코맨트, 내용, 즐겨찾기내용 , 즐겨찾기추가유무


                                        //
                                        String sharedTextTemp = new String(); //null도 ㄱㅊ


                                        for (int i = 0; i < LikeList.size(); i++) {
                                            sharedTextTemp +=
                                                    LikeList.get(i).getName()
                                                            + "@#@#" + LikeList.get(i).getComment() //i번째
                                                            + "@#@#" + LikeList.get(i).getLikeComment()
                                                            + "@#@#" + LikeList.get(i).getContent()
                                                            + "@#@#" + LikeList.get(i).getLike()
                                                            + "@#@#";
                                        }


//                                    System.out.println("확인 : " + sharedTextTemp);




                                        editor.putString("LikeList", "");
                                        editor.commit();


                                        editor.putString("LikeList", sharedTextTemp);
                                        editor.commit();


                                        Log.e("뉴스터디 어댑터의 Name과 Comment", "" + Name + Comment);


                                        Toast.makeText(ctx, "즐겨찾기에 추가하였습니다.",
                                                Toast.LENGTH_SHORT).show();
                                        Log.e("뉴스터디 어댑터", "ctx : " + ctx);
                                    }
                                });

                        //  setNegativeButton -> "Cancel" 버튼  //
                        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ctx, "취소되었습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.show();      //대화상자(dialog)화면 출력

                    }

                }
            });
        }


        public void onClick(View v) {
            itemClickListener.onItemClick(getAdapterPosition());
        }


        // 뷰만 매계변수로 사용하는 뷰홀더 생성자
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            comment = itemView.findViewById(R.id.comment);

        }

        public void setItem(NewStudyItem item) {
            name.setText(item.getName());
            comment.setText(item.getComment());

        }

        public void setStudyItemManager(StudyItemManager studyItemManager) {
            this.studyItemManager = studyItemManager;
        }

//

    }

}

