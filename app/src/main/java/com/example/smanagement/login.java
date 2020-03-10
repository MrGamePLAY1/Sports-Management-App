package com.example.smanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    FirebaseAuth mAuth;


    Button loginButton;
    EditText etUsername, etPassword;
    TextView registerLink;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //firebase instance
        mAuth = FirebaseAuth.getInstance();
        progressBar = new ProgressBar(this);

        //checking if user is logged in
        FirebaseUser user = mAuth.getCurrentUser();

        //send him off to main if logged in
      /*  if (user != null)
        {
            finish(); //destroy
            startActivity(new Intent(login.this, MainActivity.class));
        }*/

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        //setting the views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);


        //onclick
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                validation(etUsername.getText().toString(), etPassword.getText().toString());


            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
            }
        });


    }


    //cretaed when you enter details
    private void validation(String loginUser, String loginPass)
    {

        //validate the Player
        if (loginUser.isEmpty())
        {
            Toast.makeText(login.this, "Username is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (loginPass.isEmpty())
        {
            Toast.makeText(login.this, "Password is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if(loginPass.length() < 6)
        {
            Toast.makeText(login.this, "You're password must be longer than 6 characters", Toast.LENGTH_SHORT).show();
        }


        //logging in new user
        mAuth.signInWithEmailAndPassword(loginUser, loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(login.this, "You have successfully logged in!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, MainActivity.class));


                }

                else
                {
                    Toast.makeText(login.this, "No account found!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
