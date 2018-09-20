package com.example.seiya.dentalclinic.api;

import com.example.seiya.dentalclinic.model.DefaultResponse;
import com.example.seiya.dentalclinic.model.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.FormUrlEncoded;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("createClient")
    Call<DefaultResponse>createClient(@Field("lastname") String lastname, @Field("firstname") String firstname, @Field("midname")String midname,
                                      @Field("contactnum") String contactnum, @Field("email")String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(@Field("email") String email, @Field("password") String password);
}
