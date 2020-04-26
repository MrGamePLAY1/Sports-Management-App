package com.example.smanagement;

public class Player
{
    private String name;
    private String age;
    private String country;
    private String dob;
    private String goals;
    private String assists;
    private String morale;
    private String injuries;
    private String rCards;
    private String yCards;
    private String fitness;
    private String summary;


    public Player()
    {
        //empty constructor
    }


    //constructor
    public Player(String name, String age, String country, String dob, String goals, String assists, String morale, String injuries, String rCards, String yCards, String fitness, String summary) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.dob = dob;
        this.goals = goals;
        this.assists = assists;
        this.morale = morale;
        this.injuries = injuries;
        this.rCards = rCards;
        this.yCards = yCards;
        this.fitness = fitness;
        this.summary = summary;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getMorale() {
        return morale;
    }

    public void setMorale(String morale) {
        this.morale = morale;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public String getrCards() {
        return rCards;
    }

    public void setrCards(String rCards) {
        this.rCards = rCards;
    }

    public String getyCards() {
        return yCards;
    }

    public void setyCards(String yCards) {
        this.yCards = yCards;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
