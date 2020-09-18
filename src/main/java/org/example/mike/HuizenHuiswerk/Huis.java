package org.example.mike.HuizenHuiswerk;

public class Huis {
    private Adres adres;
    private int aantalKamers;
    private int capaciteitKamer = 2;

    Huis(Adres adres, int aantalKamers)
    {
        this.adres = adres;
        this.aantalKamers = aantalKamers;
    }

}

