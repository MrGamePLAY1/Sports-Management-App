package com.example.smanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class message extends AppCompatActivity {

    TextView username;
    ImageButton btn_send;
    EditText text_send;

    //database
    DatabaseReference ref;
    FirebaseUser user;
    FirebaseAuth mAuth;

    //intent
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        //send him off to main if logged in
       if (user != null)
        {
            finish(); //destroy
            startActivity(new Intent(message.this, MainActivity.class));
        }

        //firebase instance
        mAuth = FirebaseAuth.getInstance();
        mAuth.getCurrentUser();

        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setTitle("Messaging");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.username);
        btn_send = findViewById(R.id.btn_send);
        text_send = findViewById(R.id.text_send);

        intent = getIntent();

        final String userid = intent.getStringExtra("userid");

        //onlcick
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String msg = text_send.getText().toString();

                //if message is empty
                if (!msg.equals(""))
                {
                    //sendMessage(user.getUid(), userid, msg);
                }

                else
                {
                    Toast.makeText(message.this, "You need to send a message", Toast.LENGTH_SHORT).show();
                }

                //reset the message
                text_send.setText("");
            }
        });

        //getting user logged in
        //user = FirebaseAuth.getInstance().getCurrentUser();
        //ref = FirebaseDatabase.getInstance().getReference("Users").child(userid);

        /*ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Player player = dataSnapshot.getValue(Player.class);
                //get the usersname messaging the person
                username.setText(player.getName());
                //profile picture

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

    }

    /*private void sendMessage(String sender, String receiver, String message)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //storing information into hashmap
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sender", sender);
        hashMap.put("receiver", receiver);
        hashMap.put("sender", sender);
        hashMap.put("message", message);

        //putting into the db
        reference.child("Chats").push().setValue(hashMap);
    }*/
}
