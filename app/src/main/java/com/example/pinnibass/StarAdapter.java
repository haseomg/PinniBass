package com.example.pinnibass;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pinnibass.ChapModel.NewChap;

import java.io.Serializable;
import java.util.ArrayList;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.ViewHolder>
        implements Serializable {

    String StarName;
    String StarComment;

    SharedPreferences shared;
    SharedPreferences.Editor editor;

    ArrayList<NewStudyItem> LikeList = new ArrayList<NewStudyItem>();
    private Context context;

    private int position;

    public StudyItemManager studyItemManager;

    public NewChap newChap;



    //생성자에 쉐어드랑 에디터도 넣어주자
    public StarAdapter (Context context, SharedPreferences shared, SharedPreferences.Editor editor, StudyItemManager studyItemManager) {
        this.shared = shared;
        this.editor = editor;
        this.context = context;
        this.studyItemManager = studyItemManager;
    }

    public StarAdapter() {

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void removeItem(int position) {
        LikeList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    /**
     * 리스트 아이템을 가져와서 레이아웃을 실체화 해줌
     * 실체화를 해주는 아이가 Inflater
     * **/
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater
                = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_starmark, parent, false);
        ViewHolder vh = new ViewHolder(view, context);
        context = parent.getContext();
        vh.setStudyItemManager(studyItemManager);

        return vh;

    }

    public interface OnItemClickListener {
        void onEditClick(View v, int position);
        void onDeleteClick(View v, int position);
    }

    public interface OnItemClick {
        void onClick(String value);
    }

    /**
     * 액티비티에서 받아온 데이터를 바인딩해줌.
     * **/
    @Override
    public void onBindViewHolder
    (@NonNull StarAdapter.ViewHolder holder, int position) {

        NewStudyItem newStudyItem = LikeList.get(position);

        if(LikeList.get(position).getLike()){
            holder.onBind(newStudyItem,position);
        }
    }

    public void addItem(NewStudyItem item) {
        LikeList.add(item);
    }

    public void setonBind(ArrayList<NewStudyItem> items)
    { this.LikeList = items; }

    public NewStudyItem getItem(int position) {
        return LikeList.get(position);
    }

    public void setItem(int position, NewStudyItem item) {
        LikeList.set(position, item);
    }



    /**
     * 리사이클러뷰 리스트 사이즈를 불러옴
     * **/
    @Override
    public int getItemCount() {
        int p = 0;
        for(int i= 0; i<LikeList.size(); i++){
            if(LikeList.get(i).getLike()){
                p = p+1;
            }

        }


        return p;
    }

    public void setLikeList(ArrayList<NewStudyItem> list,Context context) {
        this.LikeList = list; //데이터를 받아왔다.
        this.context = context;
//        Log.e("LikeList의 배열 값이 0일 때","LikeList.get : "+LikeList.get(0).getName());
        notifyDataSetChanged();
    }

    /**
     * 뷰홀더 생성
     * **/
    public class ViewHolder extends RecyclerView.ViewHolder {
//                implements View.OnCreateContextMenuListener
//                원래 위에 코드를 포함한 뷰홀더를 사용했었지만, 뉴스터디어댑터와 동일한 상황을 만들어주기 위해
//        Context ctx;

        TextView starName;
        TextView starComment;
        TextView starContent;
        TextView starWrite;

        String likeCommentTemp;

        EditText likeComment;

        NewStudyAdapter.ItemClickListener itemClickListener;

        Button modify;
        Button delete;
        private StudyItemManager studyItemManger;


        public void onClick(View view) {
            itemClickListener.onItemClick(getAdapterPosition());
        }

        public ViewHolder(View view, Context context) {

            super(view);

//            view.setOnCreateContextMenuListener(this);

//            this.ctx = context;

//            Log.e("스타어댑터의 퍼블릭 뷰홀더","context 값은?" + context);

            final EditText write = view.findViewById(R.id.starWrite);
            starName = view.findViewById(R.id.starName);
            starComment = view.findViewById(R.id.starComment);
            starContent = view.findViewById(R.id.content);




            starComment.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, ChapActivity.class);

                    Log.e("StarAdapter에서 즐겨찾기 코멘트 클릭","");

                    Log.e("콘텐트 잘 넘어가냐?", starContent.getText().toString());

                    intent.putExtra("content", starContent.getText().toString());



                    context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                    // 수업 제목 클릭하면 수업 꺼내오는 것

                }
            });





            modify = view.findViewById(R.id.modify);
            modify.setOnClickListener (new View.OnClickListener () {

                @Override
                public void onClick(View view) {
                    Log.e("스타어댑터의 수정버튼", "클릭");

                    AlertDialog.Builder builder
                            = new AlertDialog.Builder(StarAdapter.this.context);



                    StarName = starName.getText().toString();
                    StarComment = starComment.getText().toString();


                    builder.setTitle("수정하시겠습니까?");
                    builder.setMessage("             " + StarName + " " + StarComment);

                    likeComment = new EditText(StarAdapter.this.context);
                    likeComment.setText(likeCommentTemp);

                    builder.setView(likeComment);
                    builder.setIcon(R.mipmap.ic_launcher);


                    builder.setPositiveButton("수정",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    int pos = getBindingAdapterPosition();

                                    String likeCommentTemp = likeComment.getText().toString();



                                    LikeList.get(pos).setLikeComment(likeCommentTemp);

                                    System.out.println("값 확인  :  " + LikeList.get(pos).getLikeComment());


                                    String sharedTextTemp = new String();


                                    //한줄로 이어 붙힘 (스플릿 사용해야하니까 변수마다 , 추가)
                                    for(int i= 0; i < LikeList.size(); i++){
                                        sharedTextTemp +=
                                                LikeList.get(i).getName()
                                                        +"%"+ LikeList.get(i).getComment()
                                                        +"%"+ LikeList.get(i).getLikeComment()
                                                        +"%"+ LikeList.get(i).getContent()
                                                        +"%";
                                    }

                                    System.out.println("확인 : " + sharedTextTemp);
                                    //쉐어드 저장
                                    editor.putString("LikeList",sharedTextTemp);
                                    editor.commit();

                                    notifyDataSetChanged();

                                    Toast.makeText(StarAdapter.this.context, "수정되었습니다.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                    builder.setNegativeButton("취소"
                            , new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Toast.makeText(StarAdapter.this.context, "취소되었습니다.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    builder.show();

                }
            });

            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    int pos = getBindingAdapterPosition();

                    removeItem(pos);

                    editor.clear();
                    editor.commit();

                    String sharedTextTemp = new String();



                    for(int i= 0; i < LikeList.size(); i++){
                        sharedTextTemp +=
                                LikeList.get(i).getName()
                                        +"%"+ LikeList.get(i).getComment()
                                        +"%"+ LikeList.get(i).getLikeComment()
                                        +"%"+ LikeList.get(i).getContent()
                                        +"%";
                    }

                    editor.putString("LikeList",sharedTextTemp);
                    editor.commit();


                    Toast.makeText(StarAdapter.this.context, "삭제하였습니다.",
                            Toast.LENGTH_SHORT).show();

                    Log.e("삭제","즐겨찾기 삭제" + StarAdapter.this.context);
                }
            });
        }

        void onBind(NewStudyItem item,int position) {
            starName.setText(item.getName());
            starComment.setText(item.getLikeComment());
//            likeCommentTemp = item.getLikeComment();
            starContent.setText(item.getContent());
        }

//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v,
//                                        ContextMenu.ContextMenuInfo menuInfo) {
//
//
//            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "편집");
//            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
//
////            Delete
//
//            Edit.setOnMenuItemClickListener(onEditMenu);
//            Delete.setOnMenuItemClickListener(onEditMenu);
//        }

        private final MenuItem.OnMenuItemClickListener onEditMenu
                = new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Log.e("온메뉴아이템클릭 작동 확인","");
                switch (item.getItemId()) {
                    case 1002:

                        LikeList.remove(position);

                        System.out.println("삭제된 값 : " + position);
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(),
                                LikeList.size());

                        break;
                }
                return true;
            }
        };

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            starName = itemView.findViewById(R.id.starName);
            starComment = itemView.findViewById(R.id.starComment);

        }

        public void setStudyItemManager(StudyItemManager studyItemManager) {
            this.studyItemManger = studyItemManager;
        }
    }

}
