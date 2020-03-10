package com.example.smanagement;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


public class register extends AppCompatActivity  {

    Button registerButton;
    EditText etName, etUsername, etPassword, etAge;
    TextView loginLink;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        super.onCreate(savedInstanceState);

        //firebase
        mAuth = FirebaseAuth.getInstance();

        //Is already Logged in, send to main activity
        if (mAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        //setting views
        etName = findViewById(R.id.etName);
        etUsername =  findViewById(R.id.etUsername);
        etPassword =  findViewById(R.id.etPassword);
        etAge =  findViewById(R.id.etAge);
        registerButton =  findViewById(R.id.registerButton);
        loginLink =  findViewById(R.id.loginLink);


        //onClick
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //getting name, username, password, age
                String name = etName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();   //email address
                String password = etPassword.getText().toString().trim();   //password
                String ageText = etAge.getText().toString();


                //validate the Player
                if (name.isEmpty())
                {
                    Toast.makeText(register.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (ageText.isEmpty())
                {
                    Toast.makeText(register.this, "Age is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.isEmpty())
                {
                    Toast.makeText(register.this, "Username is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6 )
                {
                    Toast.makeText(register.this, "Password needs more than 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Reg user to firebase
                mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(register.this, "User Created!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(register.this, login.class));
                        }

                        else
                        {
                            Toast.makeText(register.this, "Error!" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, login.class));
            }
        });




    }

}
