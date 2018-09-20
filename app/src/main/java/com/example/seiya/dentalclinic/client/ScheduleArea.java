package com.example.seiya.dentalclinic.client;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.seiya.dentalclinic.MainActivity;
import com.example.seiya.dentalclinic.R;
import com.example.seiya.dentalclinic.storage.SharedPrefManager;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class ScheduleArea extends AppCompatActivity {

    private CalendarPickerView.OnDateSelectedListener onDateSelectedListener;
    TextView pickdateTV,pickedtimeTV;
    String timepick,selectedDdate;
    Button bReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_area);
        pickdateTV =  findViewById(R.id.pickedateTV);

        Spinner spins =  findViewById(R.id.timeSpin);
        ArrayAdapter<CharSequence> adapts = ArrayAdapter.createFromResource(this, R.array.startym, android.R.layout.simple_spinner_item);
        adapts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spins.setAdapter(adapts);

        Date today = new Date();
        Calendar nextyear = Calendar.getInstance();
        nextyear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendar);
        datePicker.init(today,nextyear.getTime()).withSelectedDate(today);

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = " " + (calSelected.get(Calendar.MONTH) + 1)
                        + " " + calSelected.get(Calendar.DAY_OF_MONTH)
                        + " " + calSelected.get(Calendar.YEAR);

                pickdateTV.setText(selectedDate);
            }



            @Override
            public void onDateUnselected(Date date) {



            }
        });

        bReserve = findViewById(R.id.bReserve);
        bReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ScheduleArea.this);
                alertBuilder.setMessage("Do you want to cancel your reservation ?").setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent service = new Intent(getApplicationContext(), SetAppointment.class);
                                service.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(service);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                AlertDialog.Builder reserve = new AlertDialog.Builder(ScheduleArea.this);
                                reserve.setMessage("Thank you for trusting us.").setCancelable(false)
                                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                finish();
                                            }
                                        });

                                AlertDialog serve = reserve.create();
                                serve.show();
                            }
                        });

                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Reservation");
                alert.show();
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getSpmInstance(ScheduleArea.this).isLoggedIn()){
            Intent intent = new Intent(ScheduleArea.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

   }

