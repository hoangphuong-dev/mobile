package com.example.appzing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appzing.Model.Album;
import com.example.appzing.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHorder> {
    Context context;
    ArrayList<Album> arrayAlbum;

    public AlbumAdapter(Context context, ArrayList<Album> arrayAlbum) {
        this.context = context;
        this.arrayAlbum = arrayAlbum;
    }

    @NonNull
    @Override
    public ViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, parent, false);
        return new ViewHorder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHorder holder, int position) {
        Album album = arrayAlbum.get(position);
        holder.txt_tencasi_album.setText(album.getNameSinger());
        holder.txt_ten_album.setText(album.getName());
        Picasso.get().load(album.getImage()).into(holder.image_album);
    }

    @Override
    public int getItemCount() {
        return arrayAlbum.size();
    }

    public class ViewHorder extends RecyclerView.ViewHolder {
        ImageView image_album;
        TextView txt_ten_album, txt_tencasi_album;

        public ViewHorder(@NonNull View itemView) {
            super(itemView);
            image_album = itemView.findViewById(R.id.image_view_album);
            txt_ten_album = itemView.findViewById(R.id.textview_ten_album);
            txt_tencasi_album = itemView.findViewById(R.id.textview_tencasi_album);
        }
    }
}
