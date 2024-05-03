package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.model.KindOfStory;
import com.example.animalList.model.Story;

import java.util.ArrayList;
public class ViewPagerAdapterFragment extends Fragment {
    private ViewPager viewPager;
    private Context mContext;
//    private ArrayList<AnimalDetailFragment> animalFragments;

    // Create a new instance of ViewPagerAdapterFragment with animalFragments as a parameter
    public static ViewPagerAdapterFragment newInstance(KindOfStory kindOfStory, int position) {
        // Create a new instance of ViewPagerAdapterFragment
        ViewPagerAdapterFragment fragment = new ViewPagerAdapterFragment();

        // Create a bundle to pass the list of stories
        Bundle args = new Bundle();
        args.putSerializable("kindName", kindOfStory.getName());
        args.putSerializable("stories", kindOfStory.getListStory());
        args.putSerializable("position",position);

        // Set the arguments on the fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_wrapper, container, false);
//
//        // Retrieve the list of stories from the arguments
        String kindName = getArguments().getString("kindName", "");
        ArrayList<Story> stories = (ArrayList<Story>) getArguments().getSerializable("stories");
        int position = getArguments().getInt("position", 0);

        DetailViewPagerAdapter adapter = new DetailViewPagerAdapter(getChildFragmentManager());

        // Create a list of AnimalDetailFragment instances
        ArrayList<StoryDetailFragment> animalFragments = new ArrayList<>();

        for (Story story : stories) {
            StoryDetailFragment fragment = new StoryDetailFragment(story);
            adapter.addFragment(fragment);
        }

        // Initialize ViewPager
        viewPager = view.findViewById(R.id.vp_story);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        ImageView icBack = view.findViewById(R.id.iv_back);
        TextView listNameView = view.findViewById(R.id.tv_name);
        icBack.setVisibility(View.VISIBLE);

        icBack.setOnClickListener(vw->{
            appCompatActivity.getSupportFragmentManager().popBackStack();
        });

        listNameView.setText(kindName);

        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
