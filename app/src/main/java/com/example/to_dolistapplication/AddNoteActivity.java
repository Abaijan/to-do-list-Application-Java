package com.example.to_dolistapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class AddNoteActivity extends AppCompatActivity {

    TextView heaerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        heaerText = findViewById(R.id.textTitle);
        heaerText.setText("Главная");
    }

}