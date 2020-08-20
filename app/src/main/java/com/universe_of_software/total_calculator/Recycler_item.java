package com.universe_of_software.total_calculator;

import android.graphics.drawable.Drawable;

public class Recycler_item {

    private String title;
    private String image_title;
    private Drawable drawable;


    private int ViewType;


    //textView만 존재하는 리사이클러뷰 아이템을 사용할때
    public Recycler_item(String title,int viewType){
        this.title = title;
        this.ViewType = viewType;
    }

    public Recycler_item(Drawable drawable ,String image_title, int viewType){
        this.drawable = drawable;
        this.image_title = image_title;
        this.ViewType = viewType;
    }

    public String getTitle() {
        return this.title;
    }

    public int getViewType() {
        return this.ViewType;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getImage_title() {
        return this.image_title;
    }
}
