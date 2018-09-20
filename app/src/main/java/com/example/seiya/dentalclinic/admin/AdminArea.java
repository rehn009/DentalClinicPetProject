package com.example.seiya.dentalclinic.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.seiya.dentalclinic.R;
import com.example.seiya.dentalclinic.client.ServicesOffered;

public class AdminArea extends AppCompatActivity implements View.OnClickListener {

    private CardView appointmentCV, serviceCV, reportsCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);

        appointmentCV = findViewById(R.id.appointmentCV);
        serviceCV = findViewById(R.id.serviceCV);
        reportsCV = findViewById(R.id.locationCV);

        appointmentCV.setOnClickListener(this);
        serviceCV.setOnClickListener(this);
        reportsCV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.appointmentCV:
               // i = new Intent(AdminArea.this, AdminAppoinmentArea.class);
               // startActivity(i);
                break;
            case R.id.serviceCV:
                i = new Intent(AdminArea.this, ServicesOffered.class);
                startActivity(i);
                break;
            //case R.id.locationCV: i = new Intent(UserArea.this,DentalLocation.class);startActivity(i);break;
            //case R.id.dentistCV: i = new Intent(UserArea.this,Dentist.class);startActivity(i);break;
            default:
                break;
        }
    }
}
