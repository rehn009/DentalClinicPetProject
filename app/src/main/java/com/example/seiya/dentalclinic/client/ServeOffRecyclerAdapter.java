package com.example.seiya.dentalclinic.client;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seiya.dentalclinic.R;

import java.util.List;

public class ServeOffRecyclerAdapter extends RecyclerView.Adapter<ServeOffRecyclerAdapter.myViewHolder> {

    private Context context;
    private List<ServicesDetails> servicesDetailsList;

    ServeOffRecyclerAdapter(Context context, List<ServicesDetails> servicesDetailsList) {
        this.context = context;
        this.servicesDetailsList = servicesDetailsList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.serveoffered,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.servetype.setText(servicesDetailsList.get(position).getServicetayp());
        holder.servepic.setImageResource(servicesDetailsList.get(position).getServethumbnail());

    }

    @Override
    public int getItemCount() {
        return servicesDetailsList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        TextView servetype;
        ImageView servepic;

        public myViewHolder(View itemView) {
            super(itemView);

            servetype = (TextView) itemView.findViewById(R.id.servestypes);
            servepic = (ImageView) itemView.findViewById(R.id.servespics);
        }
    }
}
