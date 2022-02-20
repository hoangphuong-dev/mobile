package com.example.appzing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appzing.Model.Playlist;
import com.example.appzing.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txt_ten_playlist;
        ImageView img_background, img_playlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_ten_playlist = convertView.findViewById(R.id.textview_ten_playlist);
            viewHolder.img_playlist = convertView.findViewById(R.id.image_view_playlist);
            viewHolder.img_background = convertView.findViewById(R.id.image_view_background_playlist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = (Playlist) getItem(position);

        Picasso.get().load(playlist.getHinhNen()).into(viewHolder.img_background);
        Picasso.get().load(playlist.getHinhIcon()).into(viewHolder.img_playlist);
        viewHolder.txt_ten_playlist.setText(playlist.getName());

        return convertView;
    }
}
