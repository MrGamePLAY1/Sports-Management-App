package com.example.smanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity implements View.OnClickListener {

    //firebase instance


    Button registerButton;
    EditText etName, etUsername, etPassword, etAge;
    TextView loginLink;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);


        //firebase
        mAuth = FirebaseAuth.getInstance();

        //Is already Logged in, send to main activity
        if (mAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

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
                String name = etName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String ageText = etAge.getText().toString();
                int age = 0;

                if(! TextUtils.isEmpty(ageText)) // If EditText is not empty
                    age = Integer.parseInt(ageText); // parse its content to integer
                //int age = Integer.parseInt(etAge.getText().toString());


                //validate the data
                if (name.isEmpty())
                {
                    Toast.makeText(register.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.isEmpty())
                {
                    Toast.makeText(register.this, "Username is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ageText.isEmpty())
                {
                    Toast.makeText(register.this, "Age is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6 )
                {
                    Toast.makeText(register.this, "Need more than 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }


            /*
                //sending information to database
                mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //if task sucessful create user
                        if (task.isSuccessful())
                        {
                            Toast.makeText(register.this, "User created!", Toast.LENGTH_SHORT).show();

                            //sending to main activity (application dashboard)
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        else
                        {
                            //Error for user if it can not be created
                            Toast.makeText(register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }); */

                //creating new user
               // user newUser = new user(name, age, username, password);
                break;

            case R.id.loginLink:
                //do something
                startActivity(new Intent(this, login.class));
                break;
        }
    }
}
