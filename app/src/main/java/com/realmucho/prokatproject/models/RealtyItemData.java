package com.realmucho.prokatproject.models;


public class RealtyItemData extends ItemData {


    private int mRoomCount, mFloor;
    private String mAdress;

    public int getmRoomCount() {
        return mRoomCount;
    }

    public void setmRoomCount(int mRoomCount) {
        this.mRoomCount = mRoomCount;
    }

    public int getmFloor() {
        return mFloor;
    }

    public void setmFloor(int mFloor) {
        this.mFloor = mFloor;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }
}
