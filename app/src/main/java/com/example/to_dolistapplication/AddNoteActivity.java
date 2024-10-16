package com.example.to_dolistapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;


public class AddNoteActivity extends AppCompatActivity {
    ImageButton imageButton;
    ImageButton selectDateBtn;
    TextView selectDate;
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
    }

}