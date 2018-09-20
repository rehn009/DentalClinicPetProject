package com.example.seiya.dentalclinic.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seiya.dentalclinic.MainActivity;
import com.example.seiya.dentalclinic.R;
import com.example.seiya.dentalclinic.api.RetrofitClient;
import com.example.seiya.dentalclinic.model.DefaultResponse;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationArea extends AppCompatActivity implements View.OnClickListener {

    EditText lastnameET,firstnameET,midnameET,contactnumET,emailET,passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_area);

            lastnameET = findViewById(R.id.lastnameET);
            firstnameET = findViewById(R.id.firstnameET);
            midnameET = findViewById(R.id.midnameET);
            contactnumET = findViewById(R.id.contactnumET);
            emailET = findViewById(R.id.emailET);
            passwordET = findViewById(R.id.passwordET);

            Button bSubmit = findViewById(R.id.bSubmit);
            bSubmit.setOnClickListener(this);

         }

    private  void signup() {
        String lastname = lastnameET.getText().toString().trim();
        String firstname = firstnameET.getText().toString().trim();
        String midname = midnameET.getText().toString().trim();
        String contactnum = contactnumET.getText().toString().trim();
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();


        if (lastname.isEmpty()) {
            lastnameET.setError("Last name is required");
            lastnameET.requestFocus();
            return;
        }
        if (firstname.isEmpty()) {
            firstnameET.setError("First name is required");
            firstnameET.requestFocus();
            return;
        }
        if (midname.isEmpty()) {
            midnameET.setError("Middle name is required");
            midnameET.requestFocus();
            return;
        }
        if (contactnum.isEmpty()) {
            contactnumET.setError("Mobile number is required");
            contactnumET.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            emailET.setError("Email add is required");
            emailET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailET.setError("Enter a valid email address");
            emailET.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordET.setError("Password is required");
            passwordET.requestFocus();
            return;
        }
        if (password.length() < 6) {
            passwordET.setError("Password should be 6 or more characters");
            passwordET.requestFocus();
            return;
        }

        Call<DefaultResponse>call = RetrofitClient.getInstance().getApi().createClient(lastname,firstname,midname,contactnum,email,password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if(response.code() == 201){
                    DefaultResponse dr = response.body();
                    Toast.makeText(RegistrationArea.this, dr.getMesage(),Toast.LENGTH_LONG).show();
                }else if(response.code() == 422){

                    Toast.makeText(RegistrationArea.this,"User already exists",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSubmit:
                signup();
                Toast.makeText(RegistrationArea.this,"User created successfully", Toast.LENGTH_LONG).show();
                Intent reg = new Intent(getApplicationContext(),MainActivity.class);
                this.finish();
                startActivity(reg);

                break;


        }
    }
}

