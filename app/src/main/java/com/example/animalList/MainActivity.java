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
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ArrayList<Animal> mammals;
    private ArrayList<Animal> birds;
    private ArrayList<Animal> seaAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar as the support action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // calling this activity's function to
        // use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle("Navigation");

        actionBar.setDisplayShowHomeEnabled(true);

        List<KindOfAnimal> list = new ArrayList<>();

        list = getDataKindOfAnimal();

        // Find the RecyclerView within the nav header layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Set up RecyclerView
        KindOfAnimalAdapter adapter = new KindOfAnimalAdapter(list, getApplication(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    // Sample data for RecyclerView
    private List<KindOfAnimal> getDataKindOfAnimal()
    {

        createDataMammals();
        createDataBird();
        createDataSeas();

        List<KindOfAnimal> list = new ArrayList<>();

        list.add(new KindOfAnimal("Seas", R.drawable.animal_oceans, this.seaAnimals));
        list.add(new KindOfAnimal("Mammals", R.drawable.animal_mammals, this.mammals));
        list.add(new KindOfAnimal("Birds", R.drawable.animals_birds, this.birds));

        return list;
    }

    private void createDataMammals() {
        mammals = new ArrayList<Animal>();
        mammals.add(new Animal(1, "Cat", "Cats are small, agile, and independent mammals. They are popular pets and skilled hunters known for their stealth and agility.", R.drawable.cat_detail, R.drawable.ic_cat));
        mammals.add(new Animal(2, "Dog", "Dogs are loyal and friendly domesticated animals. They are known for their companionship and have been a part of human societies for thousands of years.", R.drawable.dog_detail, R.drawable.ic_dog));
        mammals.add(new Animal(3, "Hippopotamus", "Hippopotamuses are large, semi-aquatic mammals known for their massive size and aggressive nature. They are often found near rivers and lakes.", R.drawable.hippo_detail, R.drawable.ic_hippotamus));
        mammals.add(new Animal(4, "Lion", "Lions are large carnivorous mammals known as the 'king of the jungle.' They live in prides and are known for their majestic appearance.", R.drawable.lion_detail, R.drawable.ic_lion));
        mammals.add(new Animal(5, "Monkey", "Monkeys are intelligent primates known for their playful and social behavior. They inhabit various regions around the world.", R.drawable.monkey_detail, R.drawable.ic_monkey));
        mammals.add(new Animal(6, "Rabbit", "Rabbits are small herbivorous mammals known for their soft fur and long ears. They are popular pets and thrive in various habitats.", R.drawable.rabbit_detail, R.drawable.ic_rabbit));
        mammals.add(new Animal(7, "Tiger", "Tigers are large carnivorous mammals known for their striking striped fur and powerful hunting abilities. They are an endangered species.", R.drawable.tiger_detail, R.drawable.ic_tiger));
        mammals.add(new Animal(8, "Turtle", "Turtles are reptiles with a protective shell and a long lifespan. They can be found in both aquatic and terrestrial environments.", R.drawable.turtle_detail, R.drawable.ic_turtle));
        mammals.add(new Animal(9, "Zebra", "Zebras are herbivorous mammals known for their distinctive black and white stripes. They live in herds and are found in savannas and grasslands.", R.drawable.zebra_detail, R.drawable.ic_zibra));
    }

    private void createDataBird() {
        birds = new ArrayList<Animal>();
        birds.add(new Animal(10, "Eagle", "Eagles are large birds of prey known for their keen eyesight and powerful flight. They are skilled hunters and can spot prey from great distances.", R.drawable.eagle_detail, R.drawable.ic_eagle));
        birds.add(new Animal(11, "Falcon", "Falcons are birds of prey known for their incredible speed and agility in flight. They use their sharp talons to catch prey mid-air.", R.drawable.falcon_detail, R.drawable.ic_falcon));
        birds.add(new Animal(12, "Hawk", "Hawks are birds of prey known for their strong beaks and talons. They are skilled hunters and can be found in a variety of habitats worldwide.", R.drawable.hawk_detail, R.drawable.ic_hawk));
        birds.add(new Animal(13, "Parrot", "Parrots are colorful birds known for their ability to mimic human speech and sounds. They are intelligent and social animals.", R.drawable.parrot_detail, R.drawable.ic_parrot));
        birds.add(new Animal(14, "Peacock", "Peacocks are large birds known for their vibrant and ornate tail feathers. They are famous for their stunning displays during courtship.", R.drawable.peacock_detail, R.drawable.ic_peacock));
        birds.add(new Animal(15, "Penguin", "Penguins are flightless birds known for their distinctive black and white coloring. They are excellent swimmers and live in cold environments.", R.drawable.penguin_detail, R.drawable.ic_peguin));
        birds.add(new Animal(16, "Raven", "Ravens are large, intelligent birds known for their black feathers and adaptability. They are known for their ability to solve puzzles and mimic sounds.", R.drawable.raven_detail, R.drawable.ic_raven));
        birds.add(new Animal(17, "Sparrow", "Sparrows are small, agile birds known for their chirping sounds and adaptability to various environments. They are commonly found in urban areas.", R.drawable.sparrow_detail, R.drawable.ic_sparrow));
        birds.add(new Animal(18, "Woodpecker", "Woodpeckers are birds known for their strong beaks and ability to peck at trees. They feed on insects and can create distinctive holes in trees.", R.drawable.woodpecker_detail, R.drawable.ic_woodpecker));
    }

    private void createDataSeas() {
        seaAnimals = new ArrayList<Animal>();
        seaAnimals.add(new Animal(19, "Crab", "Crabs are crustaceans with a hard exoskeleton. They are known for their sideways walk and use their pincers for defense and feeding.", R.drawable.crab_detail, R.drawable.ic_crab));
        seaAnimals.add(new Animal(20, "Dolphin", "Dolphins are intelligent marine mammals known for their playful behavior and social nature. They communicate using clicks and whistles.", R.drawable.dolphin_detail, R.drawable.ic_dolphin));
        seaAnimals.add(new Animal(21, "Jellyfish", "Jellyfish are marine creatures with bell-shaped bodies and long tentacles. They use their tentacles to capture prey and defend themselves.", R.drawable.jellyfish_detail, R.drawable.ic_jellyfish));
        seaAnimals.add(new Animal(22, "Octopus", "Octopuses are intelligent marine invertebrates with eight arms. They can change color and texture to blend in with their surroundings.", R.drawable.octopus_detail, R.drawable.ic_octopus));
        seaAnimals.add(new Animal(23, "Red Snapper", "Red snappers are fish known for their distinctive red coloration and firm flesh. They are popular in culinary dishes and found in coastal waters.", R.drawable.red_snapper_detail, R.drawable.ic_red_snapper));
        seaAnimals.add(new Animal(24, "Shark", "Sharks are large predatory fish known for their sharp teeth and powerful swimming ability. They play a vital role in marine ecosystems.", R.drawable.shark_detail, R.drawable.ic_shark));
        seaAnimals.add(new Animal(25, "Squid", "Squids are marine cephalopods known for their elongated bodies and ability to eject ink. They are swift swimmers and skilled hunters.", R.drawable.squid_detail, R.drawable.ic_squid));
        seaAnimals.add(new Animal(26, "Swordfish", "Swordfish are large predatory fish known for their long, sword-like bills. They are powerful swimmers and are prized in sport fishing.", R.drawable.sword_fish_detail, R.drawable.ic_swordfish));
        seaAnimals.add(new Animal(27, "Whale", "Whales are large marine mammals known for their intelligence and complex vocalizations. They migrate long distances and are important for marine ecosystems.", R.drawable.whale_detail, R.drawable.ic_whale));
    }






}
