package com.example.pinnibass.ChapModel;

import java.io.Serializable;

public class NewChapContents implements Serializable {
    String contents;

    public NewChapContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
