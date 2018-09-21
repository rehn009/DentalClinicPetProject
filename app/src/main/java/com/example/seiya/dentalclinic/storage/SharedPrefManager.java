package com.example.seiya.dentalclinic.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.seiya.dentalclinic.model.Client;

public class SharedPrefManager {

    private static final String sharedprefname = "mySharedprefname";
    @SuppressLint("StaticFieldLeak")
    private static SharedPrefManager spmInstance;
    private Context contextL;


    private SharedPrefManager(Context contextL) {
        this.contextL = contextL;
    }

    public static synchronized SharedPrefManager getSpmInstance(Context context){
        if(spmInstance == null){
            spmInstance = new SharedPrefManager(context);
        }
        return spmInstance;
    }

    public void saveusser(Client client){
        SharedPreferences sharedPreferences = contextL.getSharedPreferences(sharedprefname,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id",client.getId());
        editor.putString("lastname", client.getLastname());
        editor.putString("firstname", client.getFirstname());
        editor.putString("midname", client.getMidname());
        editor.putString("contactnum", client.getContactnum());
        editor.putString("email", client.getEmail());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = contextL.getSharedPreferences(sharedprefname,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1; // if it is not equal to -1 it means the username is not login.
    }
    public Client getClient(){
        SharedPreferences sharedPreferences = contextL.getSharedPreferences(sharedprefname,Context.MODE_PRIVATE);
        return new Client(
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("lastname", null),
                sharedPreferences.getString("firstname",null),
                sharedPreferences.getString("midname", null),
                sharedPreferences.getString("contactnum", null),
                sharedPreferences.getString("email", null)
        );
    }
    public void clear(){
        SharedPreferences sharedPreferences = contextL.getSharedPreferences(sharedprefname,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

    }
}
