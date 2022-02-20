package com.example.appzing.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_singer")
    @Expose
    private String nameSinger;
    @SerializedName("image")
    @Expose
    private String image;

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

    public String getNameSinger() {
    return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
    this.nameSinger = nameSinger;
    }

    public String getImage() {
    return image;
    }

    public void setImage(String image) {
    this.image = image;
    }

}