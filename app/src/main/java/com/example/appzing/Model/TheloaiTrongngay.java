package com.example.appzing.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TheloaiTrongngay {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_chu_de")
    @Expose
    private String idChuDe;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getIdChuDe() {
    return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
    this.idChuDe = idChuDe;
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

    //    @SerializedName("TheLoai")
//    @Expose
//    private List<TheLoai> theLoai = null;
//    @SerializedName("ChuDe")
//    @Expose
//    private List<ChuDe> chuDe = null;
//
//    public List<TheLoai> getTheLoai() {
//        return theLoai;
//    }
//
//    public void setTheLoai(List<TheLoai> theLoai) {
//        this.theLoai = theLoai;
//    }
//
//    public List<ChuDe> getChuDe() {
//        return chuDe;
//    }
//
//    public void setChuDe(List<ChuDe> chuDe) {
//        this.chuDe = chuDe;
//    }


}
//
//public class ChuDe {
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("image")
//    @Expose
//    private String image;
//
//    public String getId() {
//    return id;
//    }
//
//    public void setId(String id) {
//    this.id = id;
//    }
//
//    public String getName() {
//    return name;
//    }
//
//    public void setName(String name) {
//    this.name = name;
//    }
//
//    public String getImage() {
//    return image;
//    }
//
//    public void setImage(String image) {
//    this.image = image;
//    }
//
//}


//public class TheLoai {
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("id_chu_de")
//    @Expose
//    private String idChuDe;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("image")
//    @Expose
//    private String image;
//
//    public String getId() {
//    return id;
//    }
//
//    public void setId(String id) {
//    this.id = id;
//    }
//
//    public String getIdChuDe() {
//    return idChuDe;
//    }
//
//    public void setIdChuDe(String idChuDe) {
//    this.idChuDe = idChuDe;
//    }
//
//    public String getName() {
//    return name;
//    }
//
//    public void setName(String name) {
//    this.name = name;
//    }
//
//    public String getImage() {
//    return image;
//    }
//
//    public void setImage(String image) {
//    this.image = image;
//    }
//
//}

