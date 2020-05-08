package com.example.smanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class playerCreation extends AppCompatActivity {
    private static final String TAG = "PLAYER_CREATION_TAG";
    public static  final String EXTRA_PLAYER_NAME = "com.example.smanagement.EXTRA_PLAYER_NAME";
    public static  final String EXTRA_PLAYER_AGE = "com.example.smanagement.EXTRA_PLAYER_AGE";
    public static  final String EXTRA_PLAYER_COUNTRY = "com.example.smanagement.EXTRA_PLAYER_COUNTRY";
    public static  final String EXTRA_PLAYER_DOB = "com.example.smanagement.EXTRA_PLAYER_DOB";



    //Variables
    EditText editName, editAge, editCountry, editDOB, editGoals,
             editAssists, editMorale, editInjuries, editYCards,
             editRCards, editFitness, editSummary;

    Button  saveBtn, deleteBtn, homeBtn, statsBtn, datab;

    ListView listView;

    ArrayList<String> arrayList2;



    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    String id;
    String manager;

    //sample
    public String playerUID;

    Player testPlayer = new Player();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_player_creation);



        //setting views
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editCountry = findViewById(R.id.editCountry);
        editDOB = findViewById(R.id.editDOB);
        editGoals = findViewById(R.id.editGoals);
        editAssists = findViewById(R.id.editAssists);
        editMorale = findViewById(R.id.editMorale);
        editInjuries = findViewById(R.id.editInjuries);
        editYCards = findViewById(R.id.editYCards);
        editRCards = findViewById(R.id.editRCards);
        editFitness = findViewById(R.id.editFitness);
        editSummary = findViewById(R.id.editSummary);
        saveBtn = findViewById(R.id.saveBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        homeBtn = findViewById(R.id.homeBtn);
        statsBtn = findViewById(R.id.statsBtn);

        datab = findViewById(R.id.datab);
        //listView = findViewById(R.id.listviewnigga);


        //setting onClick event for "DELETE" button
        deleteBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                //clear the fields
                clearfields();
            }
        });



        //send to homepage (Manager)
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playerCreation.this, MainActivity.class));
            }
        });

        //send to creation of player
        statsBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(playerCreation.this, playerCreation.class));
            }
        });

        datab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMatch();
            }
        });



        //setting onClick event for "SAVE" button
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //send off addName()
                addName();

                //getting all the values input (massive list.. :( )
                String name = editName.getText().toString().trim();
                String age = editAge.getText().toString().trim();
                String country = editCountry.getText().toString().trim();
                String dob = editDOB.getText().toString().trim();
                String goals = editGoals.getText().toString().trim();
                String assists = editAssists.getText().toString().trim();
                String morale = editMorale.getText().toString().trim();
                String injuries = editInjuries.getText().toString().trim();
                String rCards = editRCards.getText().toString().trim();
                String yCards = editYCards.getText().toString().trim();
                String fitness = editFitness.getText().toString().trim();
                String summary = editSummary.getText().toString().trim();


                //Validation of the information
                if (name.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter a Name", Toast.LENGTH_SHORT).show();
                }

                if (age.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter an age", Toast.LENGTH_SHORT).show();
                }

                if (country.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter a country", Toast.LENGTH_SHORT).show();
                }

                if (dob.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please add a D.O.B", Toast.LENGTH_SHORT).show();
                }

                if (goals.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter number of goals", Toast.LENGTH_SHORT).show();
                }

                if (assists.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter number of assists", Toast.LENGTH_SHORT).show();
                }

                if (morale.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter morale level", Toast.LENGTH_SHORT).show();
                }

                if (injuries.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter number of injuries", Toast.LENGTH_SHORT).show();
                }

                if (rCards.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter number of red cards received", Toast.LENGTH_SHORT).show();
                }

                if (yCards.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter number of yellow cards received", Toast.LENGTH_SHORT).show();
                }

                if (fitness.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please enter a fitness level", Toast.LENGTH_SHORT).show();
                }

                if (summary.isEmpty())
                {
                    Toast.makeText(playerCreation.this, "Please add a summary", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    public void clearfields()
    {
        //reset the fields
        editName.setText("");
        editAge.setText("");
        editCountry.setText("");
        editDOB.setText("");
        editGoals.setText("");
        editAssists.setText("");
        editMorale.setText("");
        editInjuries.setText("");
        editRCards.setText("");
        editYCards.setText("");
        editFitness.setText("");
        editSummary.setText("");
    }


    public void addName()
    {
        String name = editName.getText().toString().trim();
        String age = editAge.getText().toString().trim();
        String country = editCountry.getText().toString().trim();
        String dob = editDOB.getText().toString().trim();
        String goals = editGoals.getText().toString().trim();
        String assists = editAssists.getText().toString().trim();
        String morale = editMorale.getText().toString().trim();
        String injuries = editInjuries.getText().toString().trim();
        String rCards = editRCards.getText().toString().trim();
        String yCards = editYCards.getText().toString().trim();
        String fitness = editFitness.getText().toString().trim();
        String summary = editSummary.getText().toString().trim();

        testPlayer.setName(name);
        testPlayer.setAge(age);
        testPlayer.setCountry(country);
        testPlayer.setDob(dob);
        testPlayer.setGoals(goals);
        testPlayer.setAssists(assists);
        testPlayer.setMorale(morale);
        testPlayer.setInjuries(injuries);
        testPlayer.setrCards(rCards);
        testPlayer.setyCards(yCards);
        testPlayer.setFitness(fitness);
        testPlayer.setSummary(summary);

        Log.d(TAG, "Name: " + name);
        Log.d(TAG, "Age: " + age);
        Log.d(TAG, "Country: " + country);
        Log.d(TAG, "D.O.B: " + dob);
        Log.d(TAG, "goals: " + goals);
        Log.d(TAG, "Assists " + assists);
        Log.d(TAG, "Morale:  " + morale);
        Log.d(TAG, "Injuries " + injuries);
        Log.d(TAG, "Red Cards:  " + rCards);
        Log.d(TAG, "Yellow Cards: " + yCards);
        Log.d(TAG, "Yellow Cards: " + yCards);
        Log.d(TAG, "Fitness: " + fitness);
        Log.d(TAG, "Summary: " + summary);


        if(!TextUtils.isEmpty(name))
        {
            myRef = db.getReference("Information");
            //getting player uid
            id = myRef.push().getKey();



            //  getting the user logged in UID
            manager = FirebaseAuth.getInstance().getCurrentUser().getUid();


           myRef.child(manager).child(id).setValue(testPlayer);
           myRef.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    showData(dataSnapshot);
                    Log.d(TAG, "DATASNAPSHOT " + dataSnapshot);
               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });


           Toast.makeText(this, "Information sent by wizards to the database!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Please enter some Player", Toast.LENGTH_SHORT).show();
        }

    }


    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot snap : dataSnapshot.getChildren())
        {
            //new object to store information
            Player playerInfo = new Player();
            playerInfo.setName(snap.child(id).getValue(Player.class).getName());
            playerInfo.setAge(snap.child(id).getValue(Player.class).getAge());
            playerInfo.setCountry(snap.child(id).getValue(Player.class).getCountry());
            playerInfo.setDob(snap.child(id).getValue(Player.class).getDob());
            playerInfo.setGoals(snap.child(id).getValue(Player.class).getGoals());
            playerInfo.setAssists(snap.child(id).getValue(Player.class).getAssists());
            playerInfo.setMorale(snap.child(id).getValue(Player.class).getMorale());
            playerInfo.setInjuries(snap.child(id).getValue(Player.class).getInjuries());
            playerInfo.setrCards(snap.child(id).getValue(Player.class).getrCards());
            playerInfo.setyCards(snap.child(id).getValue(Player.class).getyCards());
            playerInfo.setFitness(snap.child(id).getValue(Player.class).getFitness());
            playerInfo.setSummary(snap.child(id).getValue(Player.class).getSummary());


            arrayList2 = new ArrayList<>();
            arrayList2.add(playerInfo.getName());
            arrayList2.add(playerInfo.getAge());
            arrayList2.add(playerInfo.getCountry());
            arrayList2.add(playerInfo.getDob());
            arrayList2.add(playerInfo.getGoals());
            arrayList2.add(playerInfo.getAssists());
            arrayList2.add(playerInfo.getMorale());
            arrayList2.add(playerInfo.getrCards());
            arrayList2.add(playerInfo.getyCards());
            arrayList2.add(playerInfo.getFitness());
            arrayList2.add(playerInfo.getSummary());

            String s = arrayList2.toString();



            Log.d(TAG, "This is the array list to String: " + s);

            //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList2);
            //listView.setAdapter(adapter);

        }
    }

    public void openMatch()
    {
        Intent intent = new Intent(this, Match.class);


        //new object to store information
        Player playerInfo = new Player();
        playerInfo.setName(testPlayer.getName());
        playerInfo.setAge(testPlayer.getAge());
        playerInfo.setCountry(testPlayer.getCountry());
        playerInfo.setDob(testPlayer.getDob());
        Log.d(TAG, "OpenMatch()   : " + playerInfo.getName());






        intent.putExtra(EXTRA_PLAYER_NAME, playerInfo.getName());
        intent.putExtra(EXTRA_PLAYER_AGE, playerInfo.getAge());
        intent.putExtra(EXTRA_PLAYER_COUNTRY, playerInfo.getCountry());
        intent.putExtra(EXTRA_PLAYER_DOB, playerInfo.getDob());

        startActivity(intent);
    }

}
