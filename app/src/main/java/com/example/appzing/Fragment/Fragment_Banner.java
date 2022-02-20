package com.example.appzing.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appzing.Adapter.BannerAdapter;
import com.example.appzing.Model.QuangCao;
import com.example.appzing.R;
import com.example.appzing.Service.APIService;
import com.example.appzing.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int currenItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        anh_xa();
        getData();
        return view;
    }

    public void anh_xa() {
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.indecator_default);
    }

    private void getData() {
        Dataservice dataservice = APIService.getService();
        Call<List<QuangCao>> callback = dataservice.GetDataBanner();
        // lắng nghe sự kiện trả về từ DB
        callback.enqueue(new Callback<List<QuangCao>>() {
            @Override
            // lắng nghe cho việc có kết quả trả về
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                bannerAdapter = new BannerAdapter(getActivity(), banners);
                // code chuyển banner quảng cáo
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currenItem = viewPager.getCurrentItem();
                        currenItem++;
                        if(currenItem >= viewPager.getAdapter().getCount()) {
                            // nếu vượt quá kích thước của banner
                            currenItem = 0;
                        }
                        viewPager.setCurrentItem(currenItem, true);
                        handler.postDelayed(runnable, 4500); // set thời gian chuyển banner
                    }
                };
                handler.postDelayed(runnable, 4500);
            }

            @Override
            // lắng nghe cho việc không có kết quả trả về
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {
                Log.d("KKKK", "999999");
            }
        });
    }
}
