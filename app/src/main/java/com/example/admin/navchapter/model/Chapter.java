package com.example.admin.navchapter.model;

public class Chapter {

    int id;

    int numChapter;

    String titleChapter;

    String textChapter;

    public Chapter(int numChapter, String titleChapter, String textChapter) {
        this.numChapter = numChapter;
        this.titleChapter = titleChapter;
        this.textChapter = textChapter;
    }

    public int getNumChapter() {
        return numChapter;
    }

    public void setNumChapter(int numChapter) {
        this.numChapter = numChapter;
    }

    public String getTitleChapter() {
        return titleChapter;
    }

    public void setTitleChapter(String titleChapter) {
        this.titleChapter = titleChapter;
    }

    public String getTextChapter() {
        return textChapter;
    }

    public void setTextChapter(String textChapter) {
        this.textChapter = textChapter;
    }
}
