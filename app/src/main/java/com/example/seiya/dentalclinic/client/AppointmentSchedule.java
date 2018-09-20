package com.example.seiya.dentalclinic.client;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.seiya.dentalclinic.R;

public class AppointmentSchedule extends AppCompatActivity {

    Button bOkay, bCancel;
    TextView dateschedTV, timeschedTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_schedule);

        dateschedTV = findViewById(R.id.dateschedTV);
        timeschedTV = findViewById(R.id.timeschedTV);

        dateschedTV.setText(String.format("%s", getIntent().getStringExtra("date:")));
        timeschedTV.setText(String.format("%s", getIntent().getStringExtra("time:")));

        bOkay = findViewById(R.id.bOkay);
        bOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent okay = new Intent(getApplicationContext(), UserArea.class);
                okay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(okay);
            }
        });

        bCancel =  findViewById(R.id.bCancelSched);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }
}
