package com.example.appzing.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//kế thừa Serializable để chuyển dữ liệu cho class khác
public class QuangCao implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("id_song")
    @Expose
    private String idSong;
    @SerializedName("name_song")
    @Expose
    private String nameSong;
    @SerializedName("image_song")
    @Expose
    private String imageSong;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getImage() {
    return image;
    }

    public void setImage(String image) {
    this.image = image;
    }

    public String getContent() {
    return content;
    }

    public void setContent(String content) {
    this.content = content;
    }

    public String getIdSong() {
    return idSong;
    }

    public void setIdSong(String idSong) {
    this.idSong = idSong;
    }

    public String getNameSong() {
    return nameSong;
    }

    public void setNameSong(String nameSong) {
    this.nameSong = nameSong;
    }

    public String getImageSong() {
    return imageSong;
    }

    public void setImageSong(String imageSong) {
    this.imageSong = imageSong;
    }

}