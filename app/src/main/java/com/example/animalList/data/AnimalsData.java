package com.example.animalList.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.animalList.R;
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
        mammals.add(new Animal(1, "Cat", "Cats are small, agile, and independent mammals. They are popular pets and skilled hunters known for their stealth and agility.", "animal_background/mammal/cat_detail.jpg", "animal_icon/mammal/ic_cat.png"));
        mammals.add(new Animal(2, "Dog", "Dogs are loyal and friendly domesticated animals. They are known for their companionship and have been a part of human societies for thousands of years.", "animal_background/mammal/dog_detail.jpg", "animal_icon/mammal/ic_dog.png"));
        mammals.add(new Animal(3, "Hippopotamus", "Hippopotamuses are large, semi-aquatic mammals known for their massive size and aggressive nature. They are often found near rivers and lakes.", "animal_background/mammal/hippo_detail.jpg", "animal_icon/mammal/ic_hippotamus.png"));
        mammals.add(new Animal(4, "Lion", "Lions are large carnivorous mammals known as the 'king of the jungle.' They live in prides and are known for their majestic appearance.", "animal_background/mammal/lion_detail.jpg", "animal_icon/mammal/ic_lion.jpg"));
        mammals.add(new Animal(5, "Monkey", "Monkeys are intelligent primates known for their playful and social behavior. They inhabit various regions around the world.", "animal_background/mammal/monkey_detail.jpg", "animal_icon/mammal/ic_monkey.png"));
        mammals.add(new Animal(6, "Rabbit", "Rabbits are small herbivorous mammals known for their soft fur and long ears. They are popular pets and thrive in various habitats.", "animal_background/mammal/rabbit_detail.jpg", "animal_icon/mammal/ic_rabbit.png"));
        mammals.add(new Animal(7, "Tiger", "Tigers are large carnivorous mammals known for their striking striped fur and powerful hunting abilities. They are an endangered species.", "animal_background/mammal/tiger_detail.jpg", "animal_icon/mammal/ic_tiger.jpg"));
        mammals.add(new Animal(8, "Turtle", "Turtles are reptiles with a protective shell and a long lifespan. They can be found in both aquatic and terrestrial environments.", "animal_background/mammal/turtle_detail.jpg", "animal_icon/mammal/ic_turtle.png"));
        mammals.add(new Animal(9, "Zebra", "Zebras are herbivorous mammals known for their distinctive black and white stripes. They live in herds and are found in savannas and grasslands.", "animal_background/mammal/zebra_detail.jpg", "animal_icon/mammal/ic_zebra.png"));
    }


    private void createDataBird() {
        birds = new ArrayList<Animal>();
        birds.add(new Animal(10, "Eagle", "Eagles are large birds of prey known for their keen eyesight and powerful flight. They are skilled hunters and can spot prey from great distances.", "animal_background/bird/eagle_detail.jpg", "animal_icon/bird/ic_eagle.jpg"));
        birds.add(new Animal(11, "Falcon", "Falcons are birds of prey known for their incredible speed and agility in flight. They use their sharp talons to catch prey mid-air.", "animal_background/bird/falcon_detail.jpg", "animal_icon/bird/ic_falcon.jpg"));
        birds.add(new Animal(12, "Hawk", "Hawks are birds of prey known for their strong beaks and talons. They are skilled hunters and can be found in a variety of habitats worldwide.", "animal_background/bird/hawk_detail.jpg", "animal_icon/bird/ic_hawk.png"));
        birds.add(new Animal(13, "Parrot", "Parrots are colorful birds known for their ability to mimic human speech and sounds. They are intelligent and social animals.", "animal_background/bird/parrot_detail.jpg", "animal_icon/bird/ic_parrot.png"));
        birds.add(new Animal(14, "Peacock", "Peacocks are large birds known for their vibrant and ornate tail feathers. They are famous for their stunning displays during courtship.", "animal_background/bird/peacock_detail.jpg", "animal_icon/bird/ic_peacock.png"));
        birds.add(new Animal(15, "Penguin", "Penguins are flightless birds known for their distinctive black and white coloring. They are excellent swimmers and live in cold environments.", "animal_background/bird/penguin_detail.jpg", "animal_icon/bird/ic_penguin.png"));
        birds.add(new Animal(16, "Raven", "Ravens are large, intelligent birds known for their black feathers and adaptability. They are known for their ability to solve puzzles and mimic sounds.", "animal_background/bird/raven_detail.jpg", "animal_icon/bird/ic_raven.jpg"));
        birds.add(new Animal(17, "Sparrow", "Sparrows are small, agile birds known for their chirping sounds and adaptability to various environments. They are commonly found in urban areas.", "animal_background/bird/sparrow_detail.jpg", "animal_icon/bird/ic_sparrow.png"));
        birds.add(new Animal(18, "Woodpecker", "Woodpeckers are birds known for their strong beaks and ability to peck at trees. They feed on insects and can create distinctive holes in trees.", "animal_background/bird/woodpecker_detail.jpg", "animal_icon/bird/ic_woodpecker.png"));
    }


    private void createDataSeas() {
        seaAnimals = new ArrayList<Animal>();
        seaAnimals.add(new Animal(19, "Crab", "Crabs are crustaceans with a hard exoskeleton. They are known for their sideways walk and use their pincers for defense and feeding.", "animal_background/sea/crab_detail.jpg", "animal_icon/sea/ic_crab.png"));
        seaAnimals.add(new Animal(20, "Dolphin", "Dolphins are intelligent marine mammals known for their playful behavior and social nature. They communicate using clicks and whistles.", "animal_background/sea/dolphin_detail.jpg", "animal_icon/sea/ic_dolphin.png"));
        seaAnimals.add(new Animal(21, "Jellyfish", "Jellyfish are marine creatures with bell-shaped bodies and long tentacles. They use their tentacles to capture prey and defend themselves.", "animal_background/sea/jellyfish_detail.jpg", "animal_icon/sea/ic_jellyfish.png"));
        seaAnimals.add(new Animal(22, "Octopus", "Octopuses are intelligent marine invertebrates with eight arms. They can change color and texture to blend in with their surroundings.", "animal_background/sea/octopus_detail.jpg", "animal_icon/sea/ic_octopus.png"));
        seaAnimals.add(new Animal(23, "Red Snapper", "Red snappers are fish known for their distinctive red coloration and firm flesh. They are popular in culinary dishes and found in coastal waters.", "animal_background/sea/red_snapper_detail.jpg", "animal_icon/sea/ic_red_snapper.jpg"));
        seaAnimals.add(new Animal(24, "Shark", "Sharks are large predatory fish known for their sharp teeth and powerful swimming ability. They play a vital role in marine ecosystems.", "animal_background/sea/shark_detail.jpg", "animal_icon/sea/ic_shark.jpg"));
        seaAnimals.add(new Animal(25, "Squid", "Squids are marine cephalopods known for their elongated bodies and ability to eject ink. They are swift swimmers and skilled hunters.", "animal_background/sea/squid_detail.jpg", "animal_icon/sea/ic_squid.png"));
        seaAnimals.add(new Animal(26, "Swordfish", "Swordfish are large predatory fish known for their long, sword-like bills. They are powerful swimmers and are prized in sport fishing.", "animal_background/sea/sword_fish_detail.jpg", "animal_icon/sea/ic_swordfish.png"));
        seaAnimals.add(new Animal(27, "Whale", "Whales are large marine mammals known for their intelligence and complex vocalizations. They migrate long distances and are important for marine ecosystems.", "animal_background/sea/whale_detail.jpg", "animal_icon/sea/ic_whale.png"));
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
