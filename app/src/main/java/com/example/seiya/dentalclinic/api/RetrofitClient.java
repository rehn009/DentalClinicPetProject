package com.example.seiya.dentalclinic.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://173.16.0.208/MyApi/public/";
    private static RetrofitClient rInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static synchronized RetrofitClient getInstance(){

        if(rInstance == null){
            rInstance = new RetrofitClient();
        }
        return rInstance;
    }


    public ApiInterface getApi(){

        return  retrofit.create(ApiInterface.class);
    }
}
