package com.realmucho.prokatproject;


import android.util.Log;

public class CategoryData {


    private int currentphoto;
    private int checkedphoto;
    private int uncheckedphoto;
    private String name;
    private boolean checked=false;



    public CategoryData(int uncheckedphote, String name,int checkedphoto) {
        this.uncheckedphoto = uncheckedphote;
        this.name = name;
        this.checkedphoto=checkedphoto;
        this.currentphoto=uncheckedphote;
    }

    public int getUncheckedphote() {
        return uncheckedphoto;
    }

    public void setUncheckedphote(int uncheckedphote) {
        this.uncheckedphoto = uncheckedphote;
    }

    public int getCurrentphoto() {
        return currentphoto;

    }

    public boolean isChecked() {
        return checked;
    }

    public int getCheckedphoto() {
        return checkedphoto;
    }

    public void setCheckedphoto(int checkedphoto) {
        this.checkedphoto = checkedphoto;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setCurrentphoto(int currentphoto) {
        this.currentphoto = currentphoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void clearall(){
        Log.i("log","!!!!!clear");

    }
}
