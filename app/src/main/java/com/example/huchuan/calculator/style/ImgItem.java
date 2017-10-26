package com.example.huchuan.calculator.style;

/**
 * Created by huchuan on 2017/10/19.
 */

public class ImgItem {
    private int ImgSrc;
    private String ItemName;

    public ImgItem(int imgSrc, String itemName) {
        ImgSrc = imgSrc;
        ItemName = itemName;
    }

    public ImgItem( String itemName) {
        ImgSrc=0;
        ItemName=itemName;
    }

    public int getImgSrc() {
        return ImgSrc;
    }

    public void setImgSrc(int imgSrc) {
        ImgSrc = imgSrc;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }
}
