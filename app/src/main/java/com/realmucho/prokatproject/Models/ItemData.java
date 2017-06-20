package com.realmucho.prokatproject.Models;


import android.graphics.Bitmap;

public class ItemData {

    private int timeInterval,mainImage;
    private String itemName;
    private String price,discription,contactName,contactEmail,contactPhone,contactNotes;
    private Bitmap bm1,bm2,bm3,bm4,bm5;



    public ItemData() {
    }


    public ItemData(int mainImage, String itemnName, String price) {

        this.mainImage = mainImage;
        this.itemName = itemnName;
        this.price = price;
    }

    public int getMainImage() {
        return mainImage;
    }

    public void setMainImage(int mainImage) {
        this.mainImage = mainImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactNotes() {
        return contactNotes;
    }

    public void setContactNotes(String contactNotes) {
        this.contactNotes = contactNotes;
    }

    public Bitmap getBm1() {
        return bm1;
    }

    public void setBm1(Bitmap bm1) {
        this.bm1 = bm1;
    }

    public Bitmap getBm2() {
        return bm2;
    }

    public void setBm2(Bitmap bm2) {
        this.bm2 = bm2;
    }

    public Bitmap getBm3() {
        return bm3;
    }

    public void setBm3(Bitmap bm3) {
        this.bm3 = bm3;
    }

    public Bitmap getBm4() {
        return bm4;
    }

    public void setBm4(Bitmap bm4) {
        this.bm4 = bm4;
    }

    public Bitmap getBm5() {
        return bm5;
    }

    public void setBm5(Bitmap bm5) {
        this.bm5 = bm5;
    }
}

