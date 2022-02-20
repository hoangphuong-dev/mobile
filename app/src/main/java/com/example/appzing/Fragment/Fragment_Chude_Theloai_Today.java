package com.example.appzing.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appzing.Model.QuangCao;
import com.example.appzing.Model.TheloaiTrongngay;
import com.example.appzing.R;
import com.example.appzing.Service.APIService;
import com.example.appzing.Service.Dataservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Chude_Theloai_Today extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chu_de_va_the_loai, container, false);
        getData();
        return view;
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<TheloaiTrongngay> callback = dataservice.GetCategoryMusic();
        callback.enqueue(new Callback<TheloaiTrongngay>() {
            @Override
            public void onResponse(Call<TheloaiTrongngay> call, Response<TheloaiTrongngay> response) {
                TheloaiTrongngay theloaiTrongngay = response.body();
            }

            @Override
            public void onFailure(Call<TheloaiTrongngay> call, Throwable t) {

            }
        });

    }
}
