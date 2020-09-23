package org.example.mike.RestaurantHuiswerk;

public class Persoon {
    private String naam;

    Persoon(String naam)
    {
        setNaam(naam);
    }

    String getNaam()
    {
        return naam;
    }

    void setNaam(String newNaam)
    {
        naam = newNaam;
    }

}
