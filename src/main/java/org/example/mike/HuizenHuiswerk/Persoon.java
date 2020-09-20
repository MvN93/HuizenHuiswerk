package org.example.mike.HuizenHuiswerk;

public class Persoon {
    private String naam;
    private int leeftijd;
    private boolean heeftWoonruimte;


    Persoon(String naam, int leeftijd)
    {
        this.naam = naam;
        this.leeftijd = leeftijd;
        heeftWoonruimte = false;
    }

    String getNaam()
    {
        return naam;
    }

    int getLeeftijd()
    {
        return leeftijd;
    }

    boolean getHeeftWoonruimte() { return heeftWoonruimte;}

    void setNaam(String newNaam)
    {
        naam = newNaam;
    }

    void setLeeftijd(int newLeeftijd)
    {
        leeftijd = newLeeftijd;
    }
}

