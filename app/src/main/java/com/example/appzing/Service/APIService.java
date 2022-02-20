package com.example.appzing.Service;

// nhiệm vụ : => là class trung gian kết nối APIRetrofit và Dataservice

public class APIService {
    // lấy đường link của forder chứa các file serve thiết lập trên host
    private static String base_url = "https://zingmp3ph.000webhostapp.com/Server/";

    // tạo function để kết nối
    public static Dataservice getService() {
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
