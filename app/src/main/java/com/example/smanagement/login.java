package com.example.smanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                //validate the data
                if (username.isEmpty())
                {
                    Toast.makeText(login.this, "Username is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty())
                {
                    Toast.makeText(login.this, "Password is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length() < 6)
                {
                    Toast.makeText(login.this, "You're password must be longer than 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                break;

            case R.id.registerLink:
                //activity
                startActivity(new Intent(this, register.class));
                break;
        }
    }
}
