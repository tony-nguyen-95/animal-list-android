package com.example.animalList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.adapter.KindOfAnimalAdapter;
import com.example.animalList.fragment.GridAnimalsFragment;
import com.example.animalList.fragment.MenuFragment;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.util.ArrayList;
import java.util.List;

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
                .replace(R.id.ln_main, menuFragment, null).commit();

    }
}
