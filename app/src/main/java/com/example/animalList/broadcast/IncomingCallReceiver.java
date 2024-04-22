package com.example.animalList.broadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.animalList.R;
import com.example.animalList.data.AnimalsData;
import com.example.animalList.model.Animal;

public class IncomingCallReceiver extends BroadcastReceiver {
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        // Initialize the context
        mContext = context;

        // Check if the intent action is "android.intent.action.PHONE_STATE"
        if (intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            // Get the incoming call state
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

            // Check if the call state is "RINGING"
            if (state != null && state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                // Get the incoming phone number
                String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

               isCallFromAnimal(incomingNumber);
            }
        }
    }

    private void isCallFromAnimal(String phoneNumber) {
        // Iterate over all animals
        for (Animal animal : AnimalsData.getInstance(mContext.getApplicationContext()).getAll()) {
            // Check if the phone number matches
            if (phoneNumber.equals(animal.getPhoneNumber())) {
                showCustomToastWithAnimalImage(animal);
                return;
            }
        }
    }

    private void showCustomToastWithAnimalImage(Animal animal) {
        // Inflate custom toast layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.custom_toast_incoming_call, null);

        // Set animal image
        ImageView animalImage = layout.findViewById(R.id.icon_toast_animal);
        animalImage.setImageResource(animal.getIconImage());

        // Create and show the toast
        Toast toast = new Toast(mContext);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
