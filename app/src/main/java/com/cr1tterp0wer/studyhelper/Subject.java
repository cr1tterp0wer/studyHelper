package com.cr1tterp0wer.studyhelper;

public class Subject {

    private long mId;
    private String mText;
    private long mUpdateTime;

    public Subject() {}

    public Subject(String text) {
        mText = text;
        mUpdateTime = System.currentTimeMillis();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String subject) {
        mText = subject;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}
