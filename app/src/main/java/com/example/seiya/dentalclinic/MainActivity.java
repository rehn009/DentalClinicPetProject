package com.example.seiya.dentalclinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seiya.dentalclinic.admin.AdminArea;
import com.example.seiya.dentalclinic.api.RetrofitClient;
import com.example.seiya.dentalclinic.client.RegistrationArea;
import com.example.seiya.dentalclinic.client.UserArea;
import com.example.seiya.dentalclinic.model.LoginResponse;
import com.example.seiya.dentalclinic.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET,passwordET;
    private Button bLogin;
    private TextView regTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        regTV = findViewById(R.id.regTV);
        bLogin = findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        regTV.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(SharedPrefManager.getSpmInstance(MainActivity.this).isLoggedIn()){
            Intent intent = new Intent(MainActivity.this, UserArea.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userLogin() {
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

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

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(email,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if(!loginResponse.isError()){
                    SharedPrefManager.getSpmInstance(MainActivity.this).saveusser(loginResponse.getClient());

                    Intent intent = new Intent(MainActivity.this, UserArea.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,loginResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                userLogin();
                break;

            case R.id.bAdmin:
                Intent admin = new Intent(getApplicationContext(), AdminArea.class);
                admin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(admin);
                break;

            case R.id.regTV:
                Intent reg = new Intent(getApplicationContext(),RegistrationArea.class);
                reg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(reg);
                break;
        }
    }
}