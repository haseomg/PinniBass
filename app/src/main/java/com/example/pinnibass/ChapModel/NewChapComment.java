package com.example.pinnibass.ChapModel;

import java.io.Serializable;
import java.util.ArrayList;

public class NewChapComment implements Serializable {
    String comment;

    boolean star;


    ArrayList<NewChapContents> newChapContents = new ArrayList<>();



    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public NewChapComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ArrayList<NewChapContents> getNewChapContents() {
        return newChapContents;
    }

    public void setNewChapContents(ArrayList<NewChapContents> newChapContents) {
        this.newChapContents = newChapContents;
    }
}
