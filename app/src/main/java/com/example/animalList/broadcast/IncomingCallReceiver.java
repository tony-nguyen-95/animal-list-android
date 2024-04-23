package com.example.animalList.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animalList.R;
import com.example.animalList.data.AnimalsData;
import com.example.animalList.model.Animal;

import java.util.ArrayList;

public class IncomingCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state != null && state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingCallerNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if (incomingCallerNumber != null) {
                findAnimalByPhoneNumber(context, incomingCallerNumber);
            }
        }
    }

    private void findAnimalByPhoneNumber(Context context, String phoneNumber) {
        ArrayList<Animal> animals = AnimalsData.getInstance(context).getAll();
        for (Animal animal : animals) {
            String animalPhoneNumber = animal.getPhoneNumber();
            if (animalPhoneNumber != null && animalPhoneNumber.equals(phoneNumber)) {
                // Inflate custom toast layout
                View customToastView = LayoutInflater.from(context).inflate(R.layout.custom_toast_incoming_call, null);

                // Set custom toast text
                ImageView imageViewView = customToastView.findViewById(R.id.icon_toast_animal);
                animal.loadImageFromAssets(context,imageViewView,animal.getIconImagePath());
//                imageViewView.setImageResource(animal.getIconImage());

                // Show the custom toast
                Toast customToast = new Toast(context);
                customToast.setDuration(Toast.LENGTH_LONG);
                customToast.setView(customToastView);
                customToast.show();

                // If you want to do further processing, you can return or break here
                return;
            }
        }
        // If no matching animal is found for the given phone number
        Toast.makeText(context, "No animal found for the phone number: " + phoneNumber, Toast.LENGTH_LONG).show();
    }
}
