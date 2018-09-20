package com.example.seiya.dentalclinic.client;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.seiya.dentalclinic.MainActivity;
import com.example.seiya.dentalclinic.R;
import com.example.seiya.dentalclinic.model.Client;
import com.example.seiya.dentalclinic.storage.SharedPrefManager;


public class UserArea extends AppCompatActivity implements View.OnClickListener{

    private CardView appointmentCV, serviceCV, locationCV, dentistCV;
    TextView clientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        appointmentCV = findViewById(R.id.appointmentCV);
        serviceCV = findViewById(R.id.serviceCV);
        locationCV = findViewById(R.id.locationCV);
        dentistCV = findViewById(R.id.dentistCV);
        clientName = findViewById(R.id.clientName);

        Client client = SharedPrefManager.getSpmInstance(this).getClient();
        //clientName.setText("Hey!" + client.getFirstname());

        appointmentCV.setOnClickListener(this);
        serviceCV.setOnClickListener(this);
        locationCV.setOnClickListener(this);
        dentistCV.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getSpmInstance(UserArea.this).isLoggedIn()){
            Intent intent = new Intent(UserArea.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
             case R.id.appointmentCV: i = new Intent(UserArea.this,SetAppointment.class);startActivity(i);break;
            case R.id.serviceCV: i = new Intent(UserArea.this,ServicesOffered.class);startActivity(i);break;
            //case R.id.locationCV: i = new Intent(UserArea.this,DentalLocation.class);startActivity(i);break;
            //case R.id.dentistCV: i = new Intent(UserArea.this,Dentist.class);startActivity(i);break;
            default:break;
        }

    }
}
