package com.example.authapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterUserPreference extends AppCompatActivity implements View.OnClickListener {
    private TextView banner;
    private EditText userName, region, rank;
    private Button start;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_preference);

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.start:
                startActivity(new Intent(this, RegisterUserPreference.class));
                break;
        }

    }
}
