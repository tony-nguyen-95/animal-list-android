package com.example.animalList.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.example.animalList.model.KindOfStory;
import com.example.animalList.model.Story;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class StoriesData {
    private static StoriesData mInstance;
    private ArrayList<KindOfStory> mKindOfStory;

    private static final String[] NAMES = {
            "Con gái",
            "Con nít",
            "Con trai",
            "Công sở",
            "Cực hài",
            "Cười 18",
            "Dân gian",
            "Gia đình",
            "Giao thông",
            "Học sinh",
            "Học trò cười",
            "Khoa học",
            "Nghề nghiệp",
            "Người lớn",
            "Nhà hàng",
            "Say xỉn",
            "Tam quốc",
            "Tây du kí chế",
            "Thế giới",
            "Thơ ca cười",
            "Thơ vui",
            "Tiếu lâm",
            "Tình yêu",
            "Tôn giáo",
            "Trạng quỳnh",
            "Truyện bựa",
            "Việt nam và thế giới",
            "Vova",
            "Y tế"
    };

    private StoriesData(Context context) {
        createData(context);
    }

    public static StoriesData getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new StoriesData(context);
        }
        return mInstance;
    }

    private void createData(Context context) {
        mKindOfStory = createKindOfStories(context);
    }

    private ArrayList<KindOfStory> createKindOfStories(Context context) {
        ArrayList<KindOfStory> kindOfStories = new ArrayList<>();
        int fileCount = 0;

        for (String fileName : NAMES) {
            try {
                // Load the list of stories from the text file
                ArrayList<Story> listStory = loadListStory(context, (fileCount+1)+"_text" );
                // Load the photo for the KindOfStory
                Drawable photo = loadPhoto(context, (fileCount+1)+"_photo");
                // Check if the photo is null
                if (photo != null) {
                    // Create a new KindOfStory instance and add it to the list
                    kindOfStories.add(new KindOfStory(fileName,photo, listStory));
                } else {
                    Log.e("StoriesData", "Photo is null for " + fileName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            fileCount++;
        }

        return kindOfStories;
    }


    private ArrayList<Story> loadListStory(Context context, String fileName) {
        ArrayList<Story> listStory = new ArrayList<>();
        try {
            InputStream in = context.getAssets().open("story/" + fileName + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String str;
            String name = null;
            StringBuilder content = new StringBuilder();
            while ((str = br.readLine()) != null) {
                if (str.isEmpty()) continue;
                if (name == null) {
                    name = str;
                } else if (!str.startsWith("','0');")) {
                    content.append(str).append("\n");
                } else {
                    listStory.add(new Story(name, content.toString()));
                    name = null;
                    content = new StringBuilder();
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStory;
    }

    private Drawable loadPhoto(Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open("photo/" + fileName + ".png");
            return Drawable.createFromStream(inputStream, null);
        } catch (IOException e) {
            Log.e("StoriesData", "Failed to load photo for " + fileName, e);
            return null;
        }
    }

    public ArrayList<KindOfStory> getKindOfStory() {
        return mKindOfStory;
    }
}
