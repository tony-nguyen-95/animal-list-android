package com.example.animalList.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.animalList.model.Animal;

import java.util.ArrayList;

public class AnimalsData {
    private static AnimalsData mInstance;
    private ArrayList<Animal> mammals;
    private ArrayList<Animal> birds;
    private ArrayList<Animal> seaAnimals;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_NAME = "AnimalsDataPrefs";

    private AnimalsData(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        createDataMammals();
        createDataBird();
        createDataSeas();
        loadLovedState();
        loadPhoneNumbers();
    }

    public static AnimalsData getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new AnimalsData(context);
        }
        return mInstance;
    }


    private void createDataMammals() {
        mammals = new ArrayList<Animal>();
        mammals.add(new Animal(1, "Cat", "animal_description/mammal/cat_des.txt", "animal_background/mammal/cat_detail.jpg", "animal_icon/mammal/ic_cat.png"));
        mammals.add(new Animal(2, "Dog", "animal_description/mammal/dog_des.txt", "animal_background/mammal/dog_detail.jpg", "animal_icon/mammal/ic_dog.png"));
        mammals.add(new Animal(3, "Hippopotamus", "animal_description/mammal/hippopotamus_des.txt", "animal_background/mammal/hippo_detail.jpg", "animal_icon/mammal/ic_hippotamus.png"));
        mammals.add(new Animal(4, "Lion", "animal_description/mammal/lion_des.txt", "animal_background/mammal/lion_detail.jpg", "animal_icon/mammal/ic_lion.jpg"));
        mammals.add(new Animal(5, "Monkey", "animal_description/mammal/monkey_des.txt", "animal_background/mammal/monkey_detail.jpg", "animal_icon/mammal/ic_monkey.png"));
        mammals.add(new Animal(6, "Rabbit", "animal_description/mammal/rabbit_des.txt", "animal_background/mammal/rabbit_detail.jpg", "animal_icon/mammal/ic_rabbit.png"));
        mammals.add(new Animal(7, "Tiger", "animal_description/mammal/tiger_des.txt", "animal_background/mammal/tiger_detail.jpg", "animal_icon/mammal/ic_tiger.jpg"));
        mammals.add(new Animal(8, "Turtle", "animal_description/mammal/turtle_des.txt", "animal_background/mammal/turtle_detail.jpg", "animal_icon/mammal/ic_turtle.png"));
        mammals.add(new Animal(9, "Zebra", "animal_description/mammal/zebra_des.txt", "animal_background/mammal/zebra_detail.jpg", "animal_icon/mammal/ic_zebra.png"));
    }

    private void createDataBird() {
        birds = new ArrayList<Animal>();
        birds.add(new Animal(10, "Eagle", "animal_description/bird/eagle_des.txt", "animal_background/bird/eagle_detail.jpg", "animal_icon/bird/ic_eagle.jpg"));
        birds.add(new Animal(11, "Falcon", "animal_description/bird/falcon_des.txt", "animal_background/bird/falcon_detail.jpg", "animal_icon/bird/ic_falcon.jpg"));
        birds.add(new Animal(12, "Hawk", "animal_description/bird/hawk_des.txt", "animal_background/bird/hawk_detail.jpg", "animal_icon/bird/ic_hawk.png"));
        birds.add(new Animal(13, "Parrot", "animal_description/bird/parrot_des.txt", "animal_background/bird/parrot_detail.jpg", "animal_icon/bird/ic_parrot.png"));
        birds.add(new Animal(14, "Peacock", "animal_description/bird/peacock_des.txt", "animal_background/bird/peacock_detail.jpg", "animal_icon/bird/ic_peacock.png"));
        birds.add(new Animal(15, "Penguin", "animal_description/bird/penguin_des.txt", "animal_background/bird/penguin_detail.jpg", "animal_icon/bird/ic_penguin.png"));
        birds.add(new Animal(16, "Raven", "animal_description/bird/raven_des.txt", "animal_background/bird/raven_detail.jpg", "animal_icon/bird/ic_raven.jpg"));
        birds.add(new Animal(17, "Sparrow", "animal_description/bird/sparrow_des.txt", "animal_background/bird/sparrow_detail.jpg", "animal_icon/bird/ic_sparrow.png"));
        birds.add(new Animal(18, "Woodpecker", "animal_description/bird/woodpecker_des.txt", "animal_background/bird/woodpecker_detail.jpg", "animal_icon/bird/ic_woodpecker.png"));
    }

    private void createDataSeas() {
        seaAnimals = new ArrayList<Animal>();
        seaAnimals.add(new Animal(19, "Crab", "animal_description/sea/crab_des.txt", "animal_background/sea/crab_detail.jpg", "animal_icon/sea/ic_crab.png"));
        seaAnimals.add(new Animal(20, "Dolphin", "animal_description/sea/dolphin_des.txt", "animal_background/sea/dolphin_detail.jpg", "animal_icon/sea/ic_dolphin.png"));
        seaAnimals.add(new Animal(21, "Jellyfish", "animal_description/sea/jellyfish_des.txt", "animal_background/sea/jellyfish_detail.jpg", "animal_icon/sea/ic_jellyfish.png"));
        seaAnimals.add(new Animal(22, "Octopus", "animal_description/sea/octopus_des.txt", "animal_background/sea/octopus_detail.jpg", "animal_icon/sea/ic_octopus.png"));
        seaAnimals.add(new Animal(23, "Red Snapper", "animal_description/sea/red_snapper_des.txt", "animal_background/sea/red_snapper_detail.jpg", "animal_icon/sea/ic_red_snapper.jpg"));
        seaAnimals.add(new Animal(24, "Shark", "animal_description/sea/shark_des.txt", "animal_background/sea/shark_detail.jpg", "animal_icon/sea/ic_shark.jpg"));
        seaAnimals.add(new Animal(25, "Squid", "animal_description/sea/squid_des.txt", "animal_background/sea/squid_detail.jpg", "animal_icon/sea/ic_squid.png"));
        seaAnimals.add(new Animal(26, "Swordfish", "animal_description/sea/swordfish_des.txt", "animal_background/sea/sword_fish_detail.jpg", "animal_icon/sea/ic_swordfish.png"));
        seaAnimals.add(new Animal(27, "Whale", "animal_description/sea/whale_des.txt", "animal_background/sea/whale_detail.jpg", "animal_icon/sea/ic_whale.png"));
    }


    public ArrayList<Animal> getMammals() {
        return mammals;
    }

    public ArrayList<Animal> getBirds() {
        return birds;
    }

    public ArrayList<Animal> getSeaAnimals() {
        return seaAnimals;
    }

    public ArrayList<Animal> getAll() {
        ArrayList<Animal> allAnimals = new ArrayList<>();
        allAnimals.addAll(mammals);
        allAnimals.addAll(birds);
        allAnimals.addAll(seaAnimals);
        return allAnimals;
    }

    /**
     * Save the loved state of an animal.
     */
    public void saveLovedState(Animal animal) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("animal_loved_" + animal.getId(), animal.isLiked());
        editor.apply();
    }


    /**
     * Load the loved state of all animals from SharedPreferences.
     */
    public void loadLovedState() {
        // Retrieve the shared preferences
        SharedPreferences prefs = sharedPreferences;

        // Iterate over all animals and load their loved state
        for (Animal animal : getAll()) {
            boolean isLiked = prefs.getBoolean("animal_loved_" + animal.getId(), false);
            animal.setLiked(isLiked);
        }
    }

    /**
     * Save the phone number for the specified animal.
     */
    public void savePhoneNumber(int animalId, String phoneNumber) {
        // Retrieve the shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save the phone number
        editor.putString("animal_phone_" + animalId, phoneNumber);
        editor.apply();
    }

    /**
     * Load the phone numbers of all animals from SharedPreferences.
     */
    public void loadPhoneNumbers() {
        // Retrieve the shared preferences
        SharedPreferences prefs = sharedPreferences;

        // Iterate over all animals and load their phone numbers
        for (Animal animal : getAll()) {
            String phoneNumber = prefs.getString("animal_phone_" + animal.getId(), null);
            animal.setPhoneNumber(phoneNumber);
        }
    }

    /**
     * Remove the phone number for the specified animal from SharedPreferences.
     */
    public void removePhoneNumber(int animalId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("animal_phone_" + animalId);
        editor.apply();
    }



}
