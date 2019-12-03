package com.example.smanagement;

import android.content.Context;
import android.content.SharedPreferences;

public class userLocal
{
    public static final String SP_NAME = "userDetails";
    //allows store data on the phone
    SharedPreferences userLocalDatabase;

    //constructor
    public userLocal(Context context)
    {
        //forcing all activities to pass all information to create the new database
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    //methods to get information from local DB
    public void StoredUSerData(user user)
    {
        //allows us to edit local database
        SharedPreferences.Editor editor = userLocalDatabase.edit();

        //storing
        editor.putString("name", user.name);
        editor.putString("username", user.username);
        editor.putInt("age", user.age);
        editor.putString("password", user.password);

        //commit
        editor.commit();

    }

    public user getLoggedIn()
    {
        //getting name
        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        int age = userLocalDatabase.getInt("age", -1);


        //creating new user
        user StoredUser = new user(name, age, username, password);
        return StoredUser;

    }

    //if logged in
    public void setUserLogginIn(boolean loggedIn)
    {
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.putBoolean("loggedIn", loggedIn);

        //commit
        editor.commit();
    }

    //clearing all data
    public void clearUserData()
    {
        SharedPreferences.Editor editor = userLocalDatabase.edit();
        editor.clear();

        //then commit
        editor.commit();

    }
}
