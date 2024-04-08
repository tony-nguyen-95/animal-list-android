package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.model.Exam;
import com.example.animalList.model.ExamViewHolder;

import java.util.Collections;
import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamViewHolder> {

    List<Exam> list = Collections.emptyList();
    Context context;

    public ExamAdapter(List<Exam> list, Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater  = LayoutInflater.from(context);

        View photoView
                = inflater
                .inflate(R.layout.exam_recycle_item, parent, false);

        ExamViewHolder viewHolder = new ExamViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ExamViewHolder viewHolder, final int position)
    {
        int index = viewHolder.getAdapterPosition();
        viewHolder.examName.setText(list.get(position).name);
        viewHolder.examDate.setText(list.get(position).date);
        viewHolder.examMessage.setText(list.get(position).message);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
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
