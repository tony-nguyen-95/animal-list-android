package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Detect the device's default locale
        Locale currentLocale = getResources().getConfiguration().locale;


        // Load appropriate string resources based on the device's language
        if (currentLocale.getLanguage().equals("vi")) {
            Toast.makeText(this, "aaa",Toast.LENGTH_LONG).show();
            setLocale();
        }

        setContentView(R.layout.activity_main);
    }

    private void setLocale() {
        Locale locale = new Locale("vi");
        Locale.setDefault(locale);
        Resources resources = getResources();
        android.content.res.Configuration config = resources.getConfiguration();
        config.locale = locale;
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}