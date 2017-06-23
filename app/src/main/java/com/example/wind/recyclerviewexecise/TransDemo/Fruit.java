package com.example.wind.recyclerviewexecise.TransDemo;

/**
 * Created by wind on 17-6-17.
 */

public class Fruit {

    private String fruitName;
    private int imageId;

    public Fruit(String fruitname,int imageid){
        this.fruitName=fruitname;
        this.imageId=imageid;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getImageId() {
        return imageId;
    }
}
