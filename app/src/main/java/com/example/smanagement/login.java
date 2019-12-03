package com.example.smanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;


    Button loginButton;
    EditText etUsername, etPassword;
    TextView registerLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //firebase instance
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //setting the views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);

        //onclick
        loginButton.setOnClickListener(this);
        registerLink.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        //gets view of id method, if login was notified do the following
        switch (v.getId())
        {
            case R.id.loginButton:
                break;

            case R.id.registerLink:
                //activity
                startActivity(new Intent(this, register.class));
                break;
        }
    }
}
