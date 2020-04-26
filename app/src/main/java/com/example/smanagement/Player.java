package com.example.smanagement;

public class Player
{
    private String id;
    private String name;
    private String age;


    public Player()
    {
        //empty constructor
    }


    //constructor
    public Player(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
