package com.example.smanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //variables
    TextView managerLogout;

    //buttons (navbar)
    Button homeBtn, statsBtn, checklistBtn, calenderBtn, messagingBtn, viewDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting views
        managerLogout = findViewById(R.id.logout);
        homeBtn = findViewById(R.id.homeBtn);
        statsBtn = findViewById(R.id.statsBtn);
        checklistBtn = findViewById(R.id.checklistBtn);
        calenderBtn = findViewById(R.id.calenderBtn);
        messagingBtn = findViewById(R.id.messagingBtn);

        viewDB = findViewById(R.id.viewdb);

        managerLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, login.class)); //Go back to home page
                    finish();
            }
        });

        viewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, match.class));
            }
        });

        //send to homepage (Manager)
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        //send to creation of player
        statsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, playerCreation.class));
            }
        });

        //send to creation of player
        messagingBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, chatMessage.class));
            }
        });


    }
}
