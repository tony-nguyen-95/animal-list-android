package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.model.KindOfAnimal;
import com.example.animalList.model.KindOfAnimalViewHolder;

import java.util.Collections;
import java.util.List;

public class KindOfAnimalAdapter extends RecyclerView.Adapter<KindOfAnimalViewHolder> {

    List<KindOfAnimal> list = Collections.emptyList();
    Context context;

    public KindOfAnimalAdapter(List<KindOfAnimal> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public KindOfAnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater  = LayoutInflater.from(context);

        View photoView
                = inflater
                .inflate(R.layout.kind_animal_recycle_item, parent, false);

        KindOfAnimalViewHolder viewHolder = new KindOfAnimalViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KindOfAnimalViewHolder viewHolder, final int position)
    {
        int index = viewHolder.getAdapterPosition();
        viewHolder.getKindName().setText(list.get(position).name);
        viewHolder.getKindPhoto().setImageResource(list.get(position).photo);
        viewHolder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, "clicked item index is "+index, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
