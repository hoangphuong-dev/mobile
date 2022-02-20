package com.example.appzing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appzing.Model.Baihat;
import com.example.appzing.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHoder> {
    Context context;
    ArrayList<Baihat> baihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inteInflater = LayoutInflater.from(context);
        View view = inteInflater.inflate(R.layout.dong_baihat_hot, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Baihat baihat = baihatArrayList.get(position);
        holder.txtCasi.setText(baihat.getCasi());
        holder.txtTen.setText(baihat.getName());
        Picasso.get().load(baihat.getImage()).into(holder.imgHinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView txtTen, txtCasi;
        ImageView imgHinh, imgLuotthich;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.textview_tenbaihat_hot);
            txtCasi = itemView.findViewById(R.id.textview_casi_baihathot);
            imgHinh = itemView.findViewById(R.id.image_view_baihat_hot);
            imgLuotthich = itemView.findViewById(R.id.image_view_luotthich);
        }
    }
}
