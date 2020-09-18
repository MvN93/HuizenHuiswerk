package org.example.mike.HuizenHuiswerk;

public class Persoon {
    private String naam;
    private int leeftijd;


    Persoon(String naam, int leeftijd)
    {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    String getNaam()
    {
        return naam;
    }

    int getLeeftijd()
    {
        return leeftijd;
    }

    void setNaam(String newNaam)
    {
        naam = newNaam;
    }

    void setLeeftijd(int newLeeftijd)
    {
        leeftijd = newLeeftijd;
    }
}

