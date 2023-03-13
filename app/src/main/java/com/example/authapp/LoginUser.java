package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginUser extends AppCompatActivity implements View.OnClickListener{
    private TextView login, banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }


    //    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void updateUI(FirebaseUser currentUser) {
//    }

}
