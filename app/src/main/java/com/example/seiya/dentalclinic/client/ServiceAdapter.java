package com.example.seiya.dentalclinic.client;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seiya.dentalclinic.R;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    ArrayList<Services> services = new ArrayList<Services>();
    Context context;

    ServiceAdapter(ArrayList<Services> services, Context context){
        this.services = services;
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewserv,parent,false);
        ServiceViewHolder serveViewHolder = new ServiceViewHolder(view);
        return serveViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {

        Services serve = services.get(position);
        holder.serviceimg.setImageResource(serve.getImageid());
        holder.servicetypes.setText(serve.getServicetype());
        holder.setappoints.setText(serve.getSetappoint());
        holder.cardviewserv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appointment = new Intent(context,ScheduleArea.class);
                context.startActivity(appointment);
            }
        });

    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    static class ServiceViewHolder extends RecyclerView.ViewHolder{

            ImageView serviceimg;
            TextView servicetypes, setappoints;
            CardView cardviewserv;
        ServiceViewHolder(View view){
            super(view);
                serviceimg = view.findViewById(R.id.servepic);
                servicetypes = view.findViewById(R.id.servicetype);
                setappoints = view.findViewById(R.id.setappointment);
                cardviewserv = view.findViewById(R.id.serviceview);
        }

    }
}
