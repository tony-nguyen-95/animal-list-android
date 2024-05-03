package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.adapter.KindOfStoryAdapter;
import com.example.animalList.data.StoriesData;
import com.example.animalList.model.KindOfStory;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        initView(v);
        System.out.println(mContext);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initView(View v) {
        if (getActivity() == null) {
            return;
        }

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        List<KindOfStory> list = getDataKindOfStory();

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);

        KindOfStoryAdapter adapter = new KindOfStoryAdapter(list, appCompatActivity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }


    private List<KindOfStory> getDataKindOfStory()
    {
        List<KindOfStory> list = StoriesData.getInstance(mContext).getKindOfStory();
        return list;
    }

}
