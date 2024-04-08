package com.example.animalList.model;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;

public class ExamViewHolder  extends RecyclerView.ViewHolder {
    public  TextView examName;
    public  TextView examMessage;
    public  TextView examDate;
    public  View view;

    public ExamViewHolder(View itemView)
    {
        super(itemView);
        examName= (TextView)itemView.findViewById(R.id.examName);
        examDate= (TextView) itemView.findViewById(R.id.examDate);
        examMessage = (TextView) itemView.findViewById(R.id.examMessage);
        view  = itemView;
    }
}
