package com.example.to_dolistapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

public class MainActivity extends AppCompatActivity {

    AppCompatImageButton addBtn;
    TextView headerText ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       addBtn = findViewById(R.id.AddNote);
       headerText = findViewById(R.id.textTitle);
       addBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
               startActivity(intent);
           }
       });
       headerText.setText("Главная");

    }
}