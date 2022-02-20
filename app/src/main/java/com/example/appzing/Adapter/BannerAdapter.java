package com.example.appzing.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appzing.Activity.DanhSachBaiHatActivity;
import com.example.appzing.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appzing.Model.QuangCao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    Context context;
    ArrayList<QuangCao> arrayListBanner;

    // tạo contruscor để chắc chắn gọi đến class này chỉ truyền vào 2 tham số
    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        // muốn vẽ bao nhiêu trong view pager => có bao nhiêu hình trả về thì hiển thị bấy nhiêu
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner, null);
        // ánh xạ view
        ImageView imgbackground_banner = view.findViewById(R.id.image_view_background_banner);
        ImageView imgsong_banner = view.findViewById(R.id.image_view_banner);
        TextView txt_title_song_banner = view.findViewById(R.id.text_view_title_banner_bai_hat);
        TextView txt_noidung = view.findViewById(R.id.textview_noidung);

        // lấy hình ảnh bằng thư viện Picaso
        Picasso.get().load(arrayListBanner.get(position).getImage()).into(imgbackground_banner);
        Picasso.get().load(arrayListBanner.get(position).getImageSong()).into(imgsong_banner);
        txt_title_song_banner.setText(arrayListBanner.get(position).getNameSong());
        txt_noidung.setText(arrayListBanner.get(position).getContent());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("banner", arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
