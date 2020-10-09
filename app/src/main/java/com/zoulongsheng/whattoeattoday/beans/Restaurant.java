package com.zoulongsheng.whattoeattoday.beans;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private String name;        //店名
    private String location;    //位置
    private int peopleLike;     //喜欢人数
    private int goodReputation; //好评人数
    private int badReputation;  //差评人数
    private int img;            //餐馆图片
    private String waitTime;       //用餐等待时间
    private String send;            //人均配送
    private String descrition1;     //描述1
    private String descrition2;     //描述2
    private String discount1;       //优惠1
    private String discount2;       //优惠2

    public Restaurant(){}

    public Restaurant(String name,String location,int peopleLike,int goodReputation,int badReputation,int img,String waitTime,String send,String descrition1,String descrition2,String discount1,String discount2){
        this.name = name;
        this.location = location;
        this.peopleLike = peopleLike;
        this.goodReputation = goodReputation;
        this.badReputation = badReputation;
        this.img = img;
        this.waitTime = waitTime;
        this.send = send;
        this.descrition1 = descrition1;
        this.descrition2 = descrition2;
        this.discount1 = discount1;
        this.discount2 = discount2;
    }

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

    public String getDescrition1() {
        return descrition1;
    }

    public String getDescrition2() {
        return descrition2;
    }

    public String getDiscount1() {
        return discount1;
    }

    public String getDiscount2() {
        return discount2;
    }

    public String getSend() {
        return send;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public void setDescrition1(String descrition1) {
        this.descrition1 = descrition1;
    }

    public void setDescrition2(String descrition2) {
        this.descrition2 = descrition2;
    }

    public void setDiscount1(String discount1) {
        this.discount1 = discount1;
    }

    public void setDiscount2(String discount2) {
        this.discount2 = discount2;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }
}
