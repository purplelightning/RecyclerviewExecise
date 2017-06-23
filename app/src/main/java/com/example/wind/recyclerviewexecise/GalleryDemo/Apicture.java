package com.example.wind.recyclerviewexecise.GalleryDemo;

/**
 * Created by wind on 17-6-21.
 */

public class Apicture {
    private String picName;
    private int picId;

    public Apicture(int picid,String name){
        this.picName=name;
        this.picId=picid;
    }

    public int getPicId() {
        return picId;
    }

    public String getPicName() {
        return picName;
    }
}
