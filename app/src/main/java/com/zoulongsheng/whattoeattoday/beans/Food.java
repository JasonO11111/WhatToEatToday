package com.zoulongsheng.whattoeattoday.beans;

public class Food {

    private String foodName;                //菜名
    private float price;                    //价格
    private int residue;                    //剩余量
    private int onSale;                     //月售出
    private int goodReputation;             //好评量
    private int badReputation;              //差评量
    private int peopleLike;                 //喜欢人数
    private int img;                        //菜品图片

    public Food(){}

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    public int getOnSale() {
        return onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
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

    public int getPeopleLike() {
        return peopleLike;
    }

    public void setPeopleLike(int peopleLike) {
        this.peopleLike = peopleLike;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
