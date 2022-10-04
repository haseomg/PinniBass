package com.example.pinnibass.ChapModel;

import java.io.Serializable;
import java.util.ArrayList;

public class NewChap implements Serializable {
    String gradeTitle = "입문";


    ArrayList<NewChapComment> newChapComments = new ArrayList<>();

    public String getGradeTitle() {
        return gradeTitle;
    }

    public void setGradeTitle(String gradeTitle) {
        this.gradeTitle = gradeTitle;
    }

    public ArrayList<NewChapComment> getNewChapComments() {
        return newChapComments;
    }

    public void setNewChapComments(ArrayList<NewChapComment> newChapComments) {
        this.newChapComments = newChapComments;
    }
}
