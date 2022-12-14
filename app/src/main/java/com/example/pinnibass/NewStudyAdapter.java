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

        // ????????????
        FileInputStream fin = new FileInputStream("obj.ser");
        ObjectInputStream in = new ObjectInputStream(fin);

        AAA aaa = (AAA) in.readObject();    // ??? ?????? ???????????? ???

    }

    static class AAA {

    }


    @NonNull
    @Override
    /**
     * ????????? ???????????? ???????????? ??????????????? ????????? ??????
     * ???????????? ????????? ????????? Inflater
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
        this.NewStudyList = list; //???????????? ????????????.
//        Log.e("LikeList??? ?????? ?????? 0??? ???","LikeList.get : "+LikeList.get(0).getName());
        notifyDataSetChanged();
    }


    /**
     * ?????????????????? ????????? ???????????? ???????????????.
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
     * ?????????????????? ????????? ???????????? ?????????
     **/
    @Override
    public int getItemCount() {
//        Log.d ("getItemCount : "+NewStudyList.size());
        return NewStudyList.size();
    }

    public void setStudyList(ArrayList<NewStudyItem> list) {
        this.NewStudyList = list;
        //???????????? ????????????. ??? ????????? ???????????? ??????????????? ??????????????? ?????? ???????????? ?????????.

        //LikeList??? ???????????? ?????????, ???????????? ??? ??? ??? ???????????? ???????????? ??? ????????????.
        notifyDataSetChanged();

        Log.e("NewStudyList", "?????????????????????" + NewStudyList);
    }

    public void setStudyManager(StudyItemManager studyItemManager) {
        this.studyItemManager = studyItemManager;
    }

    public void setLikeList(ArrayList<NewStudyItem> list) {
        this.LikeList = list;
//        Log.e("NewStudyAdapter - ", "LikeItems??? ????????? : "+LikeList.toString());
    }


    /**
     * ????????? ??????
     **/
    public class ViewHolder extends RecyclerView.ViewHolder {

        Context ctx;

        ImageButton star;

        TextView name, comment;

        EditText newWrite; //?????????????????? EditText newWrite

        String likeComment = "???????????????.....";

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

                    // ?????? ?????? ???????????? ?????? ???????????? ???

                }
            });


            star.setOnClickListener(new View.OnClickListener() {

                // ????????? ??? ?????? ??????
                @Override
                public void onClick(View view) {


                    if(NewStudyList.get(getBindingAdapterPosition()).getLike()){
                        AlertDialog.Builder builder
                                = new AlertDialog.Builder(ctx);


                        Name = name.getText().toString(); //????????????????????? ?????????
                        Comment = comment.getText().toString();


                        builder.setTitle("??????????????? ?????????????????????????");
                        builder.setMessage("             " + Name + " " + Comment);


                        builder.setIcon(R.mipmap.ic_launcher);
                        newWrite = new EditText(ctx);
                        builder.setView(newWrite);


                        builder.setPositiveButton("??????",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        likeComment = newWrite.getText().toString();





//                                    // ???????????? ?????? ???, ????????? ??? ??????
                                        star.setImageResource(R.mipmap.star);

                                        //?????????????????? ??????
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


                                        String sharedTextTemp = new String(); //null??? ??????


                                        for (int i = 0; i < LikeList.size(); i++) {
                                            sharedTextTemp +=
                                                    LikeList.get(i).getName()
                                                            + "@#@#" + LikeList.get(i).getComment() //i??????
                                                            + "@#@#" + LikeList.get(i).getLikeComment()
                                                            + "@#@#" + LikeList.get(i).getContent()
                                                            + "@#@#" + LikeList.get(i).getLike()
                                                            + "@#@#";
                                        }


                                        editor.putString("LikeList", "");
                                        editor.commit();


                                        editor.putString("LikeList", sharedTextTemp);
                                        editor.commit();


                                        Log.e("???????????? ???????????? Name??? Comment", "" + Name + Comment);


                                        Toast.makeText(ctx, "??????????????? ?????????????????????.",
                                                Toast.LENGTH_SHORT).show();
                                        Log.e("???????????? ?????????", "ctx : " + ctx);
                                    }
                                });

                        //  setNegativeButton -> "Cancel" ??????  //
                        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ctx, "?????????????????????.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.show();      //????????????(dialog)?????? ??????
                    }else {

                        AlertDialog.Builder builder
                                = new AlertDialog.Builder(ctx);


                        Name = name.getText().toString(); //????????????????????? ?????????
                        Comment = comment.getText().toString();


                        builder.setTitle("??????????????? ?????????????????????????");
                        builder.setMessage("             " + Name + " " + Comment);


                        builder.setIcon(R.mipmap.ic_launcher);
                        newWrite = new EditText(ctx);
                        builder.setView(newWrite);


                        builder.setPositiveButton("??????",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        likeComment = newWrite.getText().toString();





//                                    // ???????????? ?????? ???, ????????? ??? ??????
                                        star.setImageResource(R.mipmap.fullstar);

                                        //?????????????????? ??????
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


                                        //?????? = ??????, ?????????, ??????, ?????????????????? , ????????????????????????


                                        //
                                        String sharedTextTemp = new String(); //null??? ??????


                                        for (int i = 0; i < LikeList.size(); i++) {
                                            sharedTextTemp +=
                                                    LikeList.get(i).getName()
                                                            + "@#@#" + LikeList.get(i).getComment() //i??????
                                                            + "@#@#" + LikeList.get(i).getLikeComment()
                                                            + "@#@#" + LikeList.get(i).getContent()
                                                            + "@#@#" + LikeList.get(i).getLike()
                                                            + "@#@#";
                                        }


//                                    System.out.println("?????? : " + sharedTextTemp);




                                        editor.putString("LikeList", "");
                                        editor.commit();


                                        editor.putString("LikeList", sharedTextTemp);
                                        editor.commit();


                                        Log.e("???????????? ???????????? Name??? Comment", "" + Name + Comment);


                                        Toast.makeText(ctx, "??????????????? ?????????????????????.",
                                                Toast.LENGTH_SHORT).show();
                                        Log.e("???????????? ?????????", "ctx : " + ctx);
                                    }
                                });

                        //  setNegativeButton -> "Cancel" ??????  //
                        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ctx, "?????????????????????.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.show();      //????????????(dialog)?????? ??????

                    }

                }
            });
        }


        public void onClick(View v) {
            itemClickListener.onItemClick(getAdapterPosition());
        }


        // ?????? ??????????????? ???????????? ????????? ?????????
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

