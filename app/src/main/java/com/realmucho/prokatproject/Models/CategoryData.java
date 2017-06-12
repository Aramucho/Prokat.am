package com.realmucho.prokatproject.Models;




public class CategoryData {


    private int checkedphoto;
    private int uncheckedphoto;
    private String name;
    private boolean checked = false;


    public CategoryData(int uncheckedphote, String name, int checkedphoto) {
        this.uncheckedphoto = uncheckedphote;
        this.name = name;
        this.checkedphoto = checkedphoto;
    }

    public int getUncheckedphote() {
        return uncheckedphoto;
    }


    public int getCheckedphoto() {
        return checkedphoto;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
