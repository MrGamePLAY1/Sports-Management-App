package com.example.smanagement;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class match extends AppCompatActivity {
    private static final String TAG = "ViewDatabase";

    //Database Stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private String Useruid;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //finding elements
        listView = findViewById(R.id.listview);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        Useruid = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            playerInformation pInfo = new playerInformation();

            //setting information from db
            pInfo.setName(ds.child(Useruid).getValue(playerInformation.class).getName()); //set the name
           // pInfo.setAge(ds.child(Useruid).getValue(playerInformation.class).getAge());
           // pInfo.setCountry(ds.child(Useruid).getValue(playerInformation.class).getCountry());
           // pInfo.setDob(ds.child(Useruid).getValue(playerInformation.class).getDob());
           // pInfo.setFitness(ds.child(Useruid).getValue(playerInformation.class).getFitness());
           // pInfo.setGoals(ds.child(Useruid).getValue(playerInformation.class).getGoals());
           // pInfo.setInjuries(ds.child(Useruid).getValue(playerInformation.class).getInjuries());
           // pInfo.setMorale(ds.child(Useruid).getValue(playerInformation.class).getMorale());
           // pInfo.setrCards(ds.child(Useruid).getValue(playerInformation.class).getrCards());
           // pInfo.setyCards(ds.child(Useruid).getValue(playerInformation.class).getyCards());
           // pInfo.setSummary(ds.child(Useruid).getValue(playerInformation.class).getSummary());
           // pInfo.setAssists(ds.child(Useruid).getValue(playerInformation.class).getAssists());

            //logging information
            Log.d(TAG, "ShowData: name: " + pInfo.getName());
            //Log.d(TAG, "ShowData: age: " + pInfo.getAge());
            //Log.d(TAG, "ShowData: country: " + pInfo.getCountry());
            //Log.d(TAG, "ShowData: dob: " + pInfo.getDob());
            //Log.d(TAG, "ShowData: fitness: " + pInfo.getFitness());
            //Log.d(TAG, "ShowData: goals: " + pInfo.getGoals());
            //Log.d(TAG, "ShowData: injuries: " + pInfo.getInjuries());
            //Log.d(TAG, "ShowData: morale: " + pInfo.getMorale());
            //Log.d(TAG, "ShowData: red cards: " + pInfo.getrCards());
            //Log.d(TAG, "ShowData: yellow cards: " + pInfo.getyCards());
            //Log.d(TAG, "ShowData: summary: " + pInfo.getSummary());
            //Log.d(TAG, "ShowData: assists: " + pInfo.getAssists());

            //putting all elements into a list view
            ArrayList<String> array = new ArrayList<>();
            array.add(pInfo.getName());
            //array.add(pInfo.getAge());
            //array.add(pInfo.getCountry());
            //array.add(pInfo.getDob());
            //array.add(pInfo.getFitness());
            //array.add(pInfo.getGoals());
            //array.add(pInfo.getInjuries());
            //array.add(pInfo.getMorale());
            //array.add(pInfo.getrCards());
            //array.add(pInfo.getyCards());
            //array.add(pInfo.getSummary());
            //array.add(pInfo.getAssists());

            //attaching array adapter to list
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 ,array);
            listView.setAdapter(adapter);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
