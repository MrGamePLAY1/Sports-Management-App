package com.example.smanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Match extends AppCompatActivity {
    private static final String TAG = "MATCH_TAG";

    //Database Stuff
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    //Database
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    //variables
    String id;
    String manager;

    TextView name, age, country, dob ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        name = (TextView) findViewById(R.id.name);
        age = (TextView) findViewById(R.id.age);
        country = (TextView) findViewById(R.id.country);
        dob = (TextView) findViewById(R.id.dob);

        Intent intent = getIntent();
        String name2 = intent.getStringExtra(playerCreation.EXTRA_PLAYER_NAME);
        String age2 = intent.getStringExtra(playerCreation.EXTRA_PLAYER_AGE);
        String country2 = intent.getStringExtra(playerCreation.EXTRA_PLAYER_COUNTRY);
        String dob2 = intent.getStringExtra(playerCreation.EXTRA_PLAYER_DOB);



        name.setText(name2);
        age.setText(age2);
        country.setText(country2);
        dob.setText(dob2);

        Log.d(TAG, "NAME: " + name);
        Log.d(TAG, "NAME: " + age);
        Log.d(TAG, "NAME: " + country);
        Log.d(TAG, "NAME: " + dob);

    }






}

