package com.example.animalList.adapter;

import android.content.Context;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.view.animation.AnimationUtils;

import android.widget.TextView;



import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.MainActivity;
import com.example.animalList.R;
import com.example.animalList.model.Song;

import java.util.ArrayList;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {

    private final ArrayList<Song> listSong;

    private final Context mContext;



    public MusicAdapter(ArrayList<Song> listSong, Context mContext) {

        this.listSong = listSong;

        this.mContext = mContext;

    }



    @Override

    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_song, parent, false);

        return new MusicHolder(view);

    }



    @Override

    public void onBindViewHolder(MusicAdapter.MusicHolder holder, int position) {

        Song item = listSong.get(position);

        holder.tvName.setText(item.getName());

        holder.tvName.setTag(item);

    }



    @Override

    public int getItemCount() {

        return listSong.size();

    }



    public class MusicHolder extends RecyclerView.ViewHolder {

        TextView tvName;



        public MusicHolder(View itemView) {

            super(itemView);

            tvName = itemView.findViewById(R.id.tv_song);

            itemView.setOnClickListener(v -> {

                v.startAnimation(AnimationUtils.loadAnimation(mContext, androidx.appcompat.R.anim.abc_fade_in));

                ((MainActivity) mContext).playSong((Song) tvName.getTag());

            });

        }

    }

}