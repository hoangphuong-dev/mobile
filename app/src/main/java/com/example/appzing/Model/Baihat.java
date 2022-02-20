package com.example.appzing.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Baihat {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("casi")
    @Expose
    private String casi;
    @SerializedName("link_bai_hat")
    @Expose
    private String linkBaiHat;
    @SerializedName("luot_thich")
    @Expose
    private String luotThich;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getImage() {
    return image;
    }

    public void setImage(String image) {
    this.image = image;
    }

    public String getCasi() {
    return casi;
    }

    public void setCasi(String casi) {
    this.casi = casi;
    }

    public String getLinkBaiHat() {
    return linkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
    this.linkBaiHat = linkBaiHat;
    }

    public String getLuotThich() {
    return luotThich;
    }

    public void setLuotThich(String luotThich) {
    this.luotThich = luotThich;
    }
}