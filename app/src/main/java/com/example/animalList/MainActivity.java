package com.example.animalList;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.animalList.broadcast.IncomingCallReceiver;
import com.example.animalList.fragment.MenuFragment;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 123;
    private IncomingCallReceiver incomingCallReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();

    }

    // Check if the required permissions are granted
    private boolean checkPermissions() {
        int phoneStatePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int callLogPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG);
        return phoneStatePermission == PackageManager.PERMISSION_GRANTED &&
                callLogPermission == PackageManager.PERMISSION_GRANTED;
    }

    // Request permissions from the user
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG},
                PERMISSION_REQUEST_CODE);
    }

    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Check if all permissions are granted
            boolean allPermissionsGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allPermissionsGranted = false;
                    break;
                }
            }
            if (allPermissionsGranted) {
                // Permissions are granted, proceed with app functionality
                initViews();
                incomingCallReceiver = new IncomingCallReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
                registerReceiver(incomingCallReceiver, intentFilter);
            } else {
                // Permissions are not granted, show a toast and exit the app
                Toast.makeText(this, "Please allow this permission to use features of the app", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity
            }
        }
    }


    private void initViews() {
        MenuFragment menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, menuFragment)
                .addToBackStack(null)
                .commit();
    }

}
