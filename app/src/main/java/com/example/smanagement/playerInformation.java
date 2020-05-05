package com.example.smanagement;

public class playerInformation {
    private String name;
    private String age;
    private String country;
    private String dob;
    private String goals;
    private String injuries;
    private String morale;
    private String rCards;
    private String yCards;
    private String fitness;
    private String summary;
    private String assists;

    public playerInformation()
    {
        //empty
    }


    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
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

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public String getMorale() {
        return morale;
    }

    public void setMorale(String morale) {
        this.morale = morale;
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
