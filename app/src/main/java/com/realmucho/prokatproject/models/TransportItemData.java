package com.realmucho.prokatproject.models;



public class TransportItemData extends ItemData {

    private String mModel;
    private int mFuelType, mEngineVolume, mBox, mYear;

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public int getmFuelType() {
        return mFuelType;
    }

    public void setmFuelType(int mFuelType) {
        this.mFuelType = mFuelType;
    }

    public int getmEngineVolume() {
        return mEngineVolume;
    }

    public void setmEngineVolume(int mEngineVolume) {
        this.mEngineVolume = mEngineVolume;
    }

    public int getmBox() {
        return mBox;
    }

    public void setmBox(int mBox) {
        this.mBox = mBox;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }
}
