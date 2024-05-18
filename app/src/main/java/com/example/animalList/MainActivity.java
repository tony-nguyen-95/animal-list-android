package com.example.animalList;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(v-> {
                String inputText = editText.getText().toString();
                System.out.println(inputText);
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("inputString", inputText);
                this.startActivity(intent);

        });
    }
}