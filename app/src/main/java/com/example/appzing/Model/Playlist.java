package com.example.appzing.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hinh_nen")
    @Expose
    private String hinhNen;
    @SerializedName("hinh_icon")
    @Expose
    private String hinhIcon;

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

    public String getHinhNen() {
    return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
    this.hinhNen = hinhNen;
    }

    public String getHinhIcon() {
    return hinhIcon;
    }

    public void setHinhIcon(String hinhIcon) {
    this.hinhIcon = hinhIcon;
    }

}