package com.example.appzing.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appzing.Model.Baihat;
import com.example.appzing.Model.QuangCao;
import com.example.appzing.R;
import com.example.appzing.Service.APIService;
import com.example.appzing.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class DanhSachBaiHatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;

    // nếu có bug thì sửa toolbar ở đây
    RecyclerView recyclerView_danhsachbaihat;
    FloatingActionButton floatingActionButton;
    QuangCao quangCao;
    ImageView img_danhsach_cakhuc;
    ArrayList<Baihat> mang_baihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);
        DataIntent();

        anh_xa();
        init();
        if(quangCao != null && !quangCao.getNameSong().equals("")) {
            setValueInView(quangCao.getNameSong(), quangCao.getImageSong());
            GetDataQuangCao(quangCao.getId());
        }

    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
        Picasso.get().load(hinh).into(img_danhsach_cakhuc);
    }

    private void GetDataQuangCao(String idQuangCao) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhSachbaihatTheoQuangcao(idQuangCao);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mang_baihat = (ArrayList<Baihat>) response.body();
//                Log.d("BBB", response.toString());
                Log.d("YYY", mang_baihat.get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void anh_xa() {
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbar = findViewById(R.id.toolbar_danhsach);
        recyclerView_danhsachbaihat = findViewById(R.id.recyclerview_danhsach_baihat);
        floatingActionButton = findViewById(R.id.floating_action_button);
        img_danhsach_cakhuc = findViewById(R.id.imageview_danhsach_cakhuc);
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void DataIntent() {
        // gửi dữ liệu từ BannerAdapter là inten nên bên này lấy cũng phải là intent
        Intent intent = getIntent();
        if(intent != null) {
            if (intent.hasExtra("banner")) {
                quangCao = (QuangCao) intent.getSerializableExtra("banner");
                Toast.makeText(this, quangCao.getNameSong(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}