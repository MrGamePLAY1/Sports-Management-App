package com.example.smanagement;

public class user
{
    //variables
    String name, username, password;
    int age;

    //object
    public user(String name, String username, String password, int age)
    {
        this.name = name;
        this.age = age;
        this.password = password;
        this.username = username;
    }

    public user(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.age = -1;
        this.name = "";
    }
}
