package com.realmucho.prokatproject.models;


public class CategoryData {


    private int mCheckedPhoto;
    private int mUncheckedPhoto;
    private String name;


    public CategoryData(int mUncheckedPhoto, String mName, int mCheckedPhoto) {
        this.mUncheckedPhoto = mUncheckedPhoto;
        this.name = mName;
        this.mCheckedPhoto = mCheckedPhoto;
    }

    public int getUncheckedphote() {
        return mUncheckedPhoto;
    }


    public int getmCheckedPhoto() {
        return mCheckedPhoto;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
