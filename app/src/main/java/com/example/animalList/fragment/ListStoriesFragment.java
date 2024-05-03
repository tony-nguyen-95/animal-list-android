package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.adapter.KindOfStoryAdapter;
import com.example.animalList.adapter.ListStoryAdapter;
import com.example.animalList.data.StoriesData;
import com.example.animalList.model.KindOfStory;
import com.example.animalList.model.Story;

import java.util.ArrayList;
import java.util.List;

public class ListStoriesFragment extends Fragment {
    private Context mContext;
//    private ArrayList<Story> listStory;
    private KindOfStory kindOfStory;

    public ListStoriesFragment(KindOfStory kindOfStory) {
        this.kindOfStory = kindOfStory;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_story, container, false);
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

        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewListStory);

        ListStoryAdapter adapter = new ListStoryAdapter(kindOfStory, appCompatActivity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        ImageView icBack = v.findViewById(R.id.iv_back);
        TextView listNameView = v.findViewById(R.id.tv_name);
        icBack.setVisibility(View.VISIBLE);

        icBack.setOnClickListener(vw->{
            appCompatActivity.getSupportFragmentManager().popBackStack();
        });

        listNameView.setText(kindOfStory.getName());

    }


    private List<KindOfStory> getDataKindOfStory()
    {
        List<KindOfStory> list = StoriesData.getInstance(mContext).getKindOfStory();
        return list;
    }

}
