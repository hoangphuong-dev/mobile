package com.example.appzing.Service;

import com.example.appzing.Model.Album;
import com.example.appzing.Model.Baihat;
import com.example.appzing.Model.Playlist;
import com.example.appzing.Model.QuangCao;
import com.example.appzing.Model.TheloaiTrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

// đây là 1 interface => nhiệm vụ : Gửi dữ liệu và nhận dữ liệu trả về từ server
public interface Dataservice {
    // Gọi dữ liệu cho phần quảng cáo
    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    // gọi dữ liệu cho phần playlist
    @GET("playlist.php")
    Call<List<Playlist>> GetPlaylistCurrenDay();

    // gọi dữ liệu cho phần chude và theloai
    @GET("chu-de-va-the-loai-trong-ngay.php")
    Call<TheloaiTrongngay> GetCategoryMusic();

    // gọi dữ liệu cho album
    @GET("album-hot.php")
    Call<List<Album>> GetAlbumHot();

    // gọi dữ liệu cho bài hát yêu thích
    @GET("bai-hat-yeu-thich.php")
    Call<List<Baihat>> GetBaiHatHot();

    // Gửi dữ liệu bằng phương thức POST
    @FormUrlEncoded
    @POST("danh_sach_bai_hat.php")
    Call<List<Baihat>> GetDanhSachbaihatTheoQuangcao(@Field("idquangcao") String idquangcao);

}

