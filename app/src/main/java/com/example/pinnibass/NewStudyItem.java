package com.example.pinnibass;

import java.io.Serializable;

public class NewStudyItem implements Serializable {
    String name;
    String comment;
    String write;
    String likeComment;
    boolean like;
    String content;

    public NewStudyItem(String name, String comment, String likeComment, boolean like, String content) {
        this.name = name;
        this.comment = comment;
        this.like = like;
        this.likeComment = likeComment;
        this.content = content;
    }

    public NewStudyItem(){

    }
    //(배열번호(포지션),이름,코맨트,내용,즐겨찾기내용)
    //위개 변수들에 빈값이 존재 할수있다.
    //언제?
    //1.추가할때 -- 빈값이 존재확률이 큼. 빈값은 어떻게 할것인가.? " "

    public NewStudyItem(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public NewStudyItem(String name, String comment, String write) {
        this.name = name;
        this.comment = comment;
        this.write = write;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String  getLikeComment(){
        return likeComment;
    }

    public void setLikeComment(String likeComment){
        this.likeComment=likeComment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public boolean getLike() {
        return like;
    } //

    public void setLike(boolean like) {
        this.like = like;
    }


}
