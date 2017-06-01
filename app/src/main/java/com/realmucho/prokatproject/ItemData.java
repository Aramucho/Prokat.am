package com.realmucho.prokatproject;

import java.util.ArrayList;

/**
 * Created by Free User on 5/31/2017.
 */

public class ItemData {

    private int mainImage;
    private String itemName;
    private String price;

   public ItemData(int mainImage,String itemnName, String  price){

        this.mainImage=mainImage;
        this.itemName=itemnName;
        this.price=price;
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

    public void setPrice(String  price) {
        this.price = price;
    }


    }

