package com.example.to_dolistapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;


public class AddNoteActivity extends AppCompatActivity {
    ImageButton imageButton;
    ImageButton selectDateBtn;
    TextView selectDate;


    Button addBtn;
    EditText title;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);



        // back to tha main
        imageButton = findViewById(R.id.back_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                        startActivity(intent);
            }
        });
        // back to the main

        //select date
        selectDate = findViewById(R.id.selectedDate);
        selectDateBtn = findViewById(R.id.selectBtn);

        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddNoteActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                selectDate.setText(year + "-" +  (monthOfYear + 1 ) + "-" + dayOfMonth);
                            }
                        },
                        year,month,day);
                datePickerDialog.show();
            }
        });

        addBtn = findViewById(R.id.AddNote);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = title.getText().toString();
                String descr = description.getText().toString();
                String date = selectDate.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("description",descr);
                resultIntent.putExtra("date", date);
                setResult(RESULT_OK, resultIntent);
                finish();


            }
        });

    }

}