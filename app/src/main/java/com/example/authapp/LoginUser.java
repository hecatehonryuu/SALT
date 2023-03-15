package com.example.authapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginUser extends AppCompatActivity implements View.OnClickListener{
    private TextView banner, forgetPassword;
    private EditText editTextEmail;
    private TextInputEditText editTextPassword;
    private Button login;

    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        forgetPassword = (TextView) findViewById(R.id.forgotPassword);
        forgetPassword.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (TextInputEditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.login:
                userLogin();
                break;
        }
    }


    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Min password length is 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(LoginUser.this, HomePage.class));
                    progressBar.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(LoginUser.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

}
