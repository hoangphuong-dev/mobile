package com.example.appzing.Service;

// retofit này sẽ tương tác với server

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// nhiệm vụ : cấu hình giao thức và trả về retrofit
public class APIRetrofitClient {
    private static Retrofit retrofit = null;

    // tạo hàm lấy để retrofit lấy dữ liệu
    // vì retrofit không tự cấu hình được -> truyền cho nó đường dẫn
    public static Retrofit getClient(String base_url) {
        // giao thức tương tác với server
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(1000000, TimeUnit.MICROSECONDS)
                .writeTimeout(1000000, TimeUnit.MICROSECONDS)
                .connectTimeout(1000000, TimeUnit.MICROSECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        // hỗ trợ đọc biến json trả về thành các biến trong java
        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
