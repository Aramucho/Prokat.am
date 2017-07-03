package com.realmucho.prokatproject.models;


import android.graphics.Bitmap;

public class ItemData {

    private int mTimeInterval,mainImage;
    private String name;
    private String mPrice, mDescription, mContactName, mContactEmail, mContactPhone, MContactNotes;
    private Bitmap mBm1, mBm2, mBm3, mBm4, mBm5;



    public ItemData() {
    }


    public ItemData(int mainImage, String name, String mPrice) {

        this.mainImage = mainImage;
        this.name = name;
        this.mPrice = mPrice;
    }



    public int getMainImage() {
        return mainImage;
    }

    public void setMainImage(int mainImage) {
        this.mainImage = mainImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public int getmTimeInterval() {
        return mTimeInterval;
    }

    public void setmTimeInterval(int mTimeInterval) {
        this.mTimeInterval = mTimeInterval;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmContactName() {
        return mContactName;
    }

    public void setmContactName(String mContactName) {
        this.mContactName = mContactName;
    }

    public String getmContactEmail() {
        return mContactEmail;
    }

    public void setmContactEmail(String mContactEmail) {
        this.mContactEmail = mContactEmail;
    }

    public String getmContactPhone() {
        return mContactPhone;
    }

    public void setmContactPhone(String mContactPhone) {
        this.mContactPhone = mContactPhone;
    }

    public String getMContactNotes() {
        return MContactNotes;
    }

    public void setMContactNotes(String MContactNotes) {
        this.MContactNotes = MContactNotes;
    }

    public Bitmap getmBm1() {
        return mBm1;
    }

    public void setmBm1(Bitmap mBm1) {
        this.mBm1 = mBm1;

    }

    public Bitmap getmBm2() {
        return mBm2;
    }

    public void setmBm2(Bitmap mBm2) {
        this.mBm2 = mBm2;
    }

    public Bitmap getmBm3() {
        return mBm3;
    }

    public void setmBm3(Bitmap mBm3) {
        this.mBm3 = mBm3;
    }

    public Bitmap getmBm4() {
        return mBm4;
    }

    public void setmBm4(Bitmap mBm4) {
        this.mBm4 = mBm4;
    }

    public Bitmap getmBm5() {
        return mBm5;
    }

    public void setmBm5(Bitmap mBm5) {
        this.mBm5 = mBm5;
    }
}

