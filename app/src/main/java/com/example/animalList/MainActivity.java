package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.animalList.model.Animal;
import com.example.animalList.adapter.AnimalAdapter;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_DETAIL_ACTIVITY = 1;
    private List<Animal> mAnimalList= new ArrayList<>();
    private AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createData();

        GridView mGridViewCustom = findViewById(R.id.grid_animals); // Find GridView by id

        mAdapter = new AnimalAdapter(this,this, mAnimalList); // Create adapter
        mGridViewCustom.setAdapter(mAdapter);
    }

    private void createData() {
        mAnimalList= new ArrayList<>();

        mAnimalList.add(new Animal(1, "Dog", "The dog is a domesticated descendant of the wolf. Also called the domestic dog, it is derived from extinct gray wolves, and the gray wolf is the dog's closest living relative. The dog was the first species to be domesticated by humans. Experts estimate that hunter-gatherers domesticated dogs more than 15,000 years ago, which was before the development of agriculture.", R.drawable.dog_detail, R.drawable.dog));
        mAnimalList.add(new Animal(2, "Elephant", "Elephants are the largest land animals on Earth. They are known for their long trunks, large ears, and tusks. Elephants are herbivores, meaning they only eat plants. They are highly intelligent animals and have strong social bonds within their herds.", R.drawable.elephant_detail, R.drawable.elephant));
        mAnimalList.add(new Animal(3, "Cat", "Cats are small carnivorous mammals that are often kept as pets. They are known for their independent and aloof nature. Cats are skilled hunters and have a wide range of vocalizations for communication. They are also known for their agility and ability to land on their feet when falling.", R.drawable.cat_detail, R.drawable.cat));
        mAnimalList.add(new Animal(4, "Bear", "Bears are large mammals found in various habitats across the world. They are omnivores, meaning they eat both plants and animals. Bears are known for their strength and are often symbolized as powerful and formidable creatures. There are several species of bears, including the polar bear, brown bear, and black bear.", R.drawable.bear_detail, R.drawable.bear));
        mAnimalList.add(new Animal(5, "Dolphin", "Dolphins are highly intelligent marine mammals known for their playful behavior and distinctive clicks and whistles. They are social animals that live in groups called pods. Dolphins are skilled hunters and feed on a variety of fish and squid. They are also known for their acrobatic jumps and flips.", R.drawable.dolphin_detail, R.drawable.dolphin));
        mAnimalList.add(new Animal(6, "Bat", "Bats are flying mammals that are nocturnal, meaning they are active at night. They use echolocation to navigate and hunt for insects. Bats play important roles in ecosystems as pollinators and pest controllers. There are over 1,400 species of bats worldwide, and they come in a variety of sizes and colors.", R.drawable.bat_detail, R.drawable.bat));
        mAnimalList.add(new Animal(7, "Spider", "Spiders are arachnids known for their eight legs and ability to spin silk webs. They are found in various habitats worldwide and play important roles in controlling insect populations. Spiders are skilled hunters and use their webs to capture prey.", R.drawable.spider_detail, R.drawable.spider));
        mAnimalList.add(new Animal(8, "Dinosaur", "Dinosaurs were a diverse group of reptiles that lived millions of years ago. They ruled the Earth for over 160 million years before becoming extinct around 65 million years ago. Dinosaurs came in various shapes and sizes, ranging from small, bird-like creatures to massive, long-necked giants.", R.drawable.dinosaur_detail, R.drawable.dinosaur));
        mAnimalList.add(new Animal(9, "Pig", "Pigs are domesticated mammals that are raised for meat and other products. They are highly intelligent animals and are known for their social behavior and communication skills. Pigs are omnivores and have a varied diet that includes plants, insects, and small animals.", R.drawable.pig_detail, R.drawable.pig));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_DETAIL_ACTIVITY && resultCode == RESULT_OK && data != null) {

            Animal updatedAnimal = (Animal) data.getSerializableExtra("updated_animal");
            if (updatedAnimal != null) {
                for (int i = 0; i < mAnimalList.size(); i++) {
                    Animal animal = mAnimalList.get(i);
                    if (animal.getId() == updatedAnimal.getId()) {
                        animal.setLiked(updatedAnimal.isLiked());
                        mAdapter.notifyDataSetChanged();
                        break;
                    }
                }
            }
        }
    }

}