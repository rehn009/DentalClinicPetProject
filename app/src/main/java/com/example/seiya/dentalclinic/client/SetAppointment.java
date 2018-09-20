package com.example.seiya.dentalclinic.client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.seiya.dentalclinic.R;

import java.util.ArrayList;

public class SetAppointment extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Services> serveslist = new ArrayList<Services>();
    int[] imageid = {R.drawable.cu, R.drawable.phrophy, R.drawable.rest, R.drawable.extract, R.drawable.pros, R.drawable.ortho, R.drawable.rcanal, R.drawable.odon};
    String [] servicesoffereds,setappoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_appointment);

        servicesoffereds = getResources().getStringArray(R.array.servicesoffereds);
        setappoint = getResources().getStringArray(R.array.setappoint);

        int count = 0;
        for(String Servicesoffereds : servicesoffereds){
            Services services = new Services(imageid[count],servicesoffereds[count],setappoint[count]);
            count++;
            serveslist.add(services);
        }

        recyclerView = findViewById(R.id.recyclerserve);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ServiceAdapter(serveslist,this);
        recyclerView.setAdapter(adapter);
    }
}
