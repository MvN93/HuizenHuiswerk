package org.example.mike.HuizenHuiswerk;

public class Huis {
    private Adres adres;
    private int aantalKamers;
    private int capaciteitKamer;
    private int totaleCapaciteitHuis;
    private Persoon[] personenInHuis;

    Huis(Adres adres, int aantalKamers)
    {
        this.adres = adres;
        this.aantalKamers = aantalKamers;
        capaciteitKamer = 2;
        totaleCapaciteitHuis = aantalKamers * capaciteitKamer;
        personenInHuis = new Persoon[totaleCapaciteitHuis];
    }

    void persoonToevoegenAanHuis(Persoon persoon){
        if((telAantalPersonenInHuis() < totaleCapaciteitHuis)) {
            //Bijv als 1 persoon in huis komt nieuwe persoon op de 2e plek oftewel op index 1
            personenInHuis[telAantalPersonenInHuis()] = persoon;
        }
    }

    int getTotaleCapaciteitHuis() {
        return totaleCapaciteitHuis;
    }

    void printLijstjeVanAlleInwonenden()
    {
        for(Persoon persoon : personenInHuis)
        {
            if(!(persoon == null))
            {
                System.out.println("Naam: " + persoon.getNaam() + ", Leeftijd: " + persoon.getLeeftijd() + ".");
            }
        }
    }

    int telAantalPersonenInHuis(){
        int aantalPersonenInHuis = 0;
        for(Persoon persoon : personenInHuis)
        {
            if(!(persoon == null))
            {
                aantalPersonenInHuis = aantalPersonenInHuis + 1;
            }
        }
        return aantalPersonenInHuis;
    }

    String toStringRepresentationOfAdres()
    {
        return adres.toStringRepresentation();
    }

}

