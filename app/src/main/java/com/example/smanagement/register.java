package com.example.smanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity implements View.OnClickListener {

    //firebase instance


    Button registerButton;
    EditText etName, etUsername, etPassword, etAge;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //setting views
        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etAge = (EditText) findViewById(R.id.etAge);
        registerButton = (Button) findViewById(R.id.registerButton);
        loginLink = (TextView) findViewById(R.id.loginLink);

        //onClick
        registerButton.setOnClickListener(this);
        loginLink.setOnClickListener(this);




    }

    @Override
    public void onClick(View v)
    {
        //gets view of id method, if login was notified do the following
        switch (v.getId())
        {
            case R.id.registerButton:
                //do something
                //getting name, username, password, age
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                String ageText = etAge.getText().toString();
                int age = 0;

                if(! TextUtils.isEmpty(ageText)) // If EditText is not empty
                    age = Integer.parseInt(ageText); // parse its content to integer
                //int age = Integer.parseInt(etAge.getText().toString());

                //creating new user
                user newUser = new user(name, age, username, password);
                break;

            case R.id.loginLink:
                //do something
                startActivity(new Intent(this, login.class));
                break;
        }
    }
}
