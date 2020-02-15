package com.example.smanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class playerCreation extends AppCompatActivity {

    //Variables
    EditText editName, editAge, editCountry, editDOB, editGoals,
             editAssists, editMorale, editInjuries, editYCards,
             editRCards, editFitness, editSummary;

    Button  saveBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        //setting onClick event for "SAVE" button
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
                    Toast.makeText(playerCreation.this, "Please enter a Name", Toast.LENGTH_SHORT).show();;
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
}
