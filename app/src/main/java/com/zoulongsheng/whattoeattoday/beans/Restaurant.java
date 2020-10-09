package com.zoulongsheng.whattoeattoday.beans;

public class Restaurant {

    private String name;        //店名
    private String location;    //位置
    private int peopleLike;     //喜欢人数
    private int goodReputation; //好评人数
    private int badReputation;  //差评人数
    private int img;            //餐馆图片

    public Restaurant(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPeopleLike() {
        return peopleLike;
    }

    public void setPeopleLike(int peopleLike) {
        this.peopleLike = peopleLike;
    }

    public int getGoodReputation() {
        return goodReputation;
    }

    public void setGoodReputation(int goodReputation) {
        this.goodReputation = goodReputation;
    }

    public int getBadReputation() {
        return badReputation;
    }

    public void setBadReputation(int badReputation) {
        this.badReputation = badReputation;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
