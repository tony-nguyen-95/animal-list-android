package com.example.animalList;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.fragment.AnimalDetailFragment;
import com.example.animalList.fragment.MenuFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        MenuFragment menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, menuFragment)
                .addToBackStack(null)
                .commit();
    }

}
