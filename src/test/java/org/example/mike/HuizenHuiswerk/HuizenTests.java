package org.example.mike.HuizenHuiswerk;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HuizenTests {


    @Test
    void mainTest()
    {
        Huis[] arrayVanHuizen = maakEenArrayVanHuizenVoorTesten();
        Persoon[] arrayVanPersonen = maakEenArrayVanPersonenVoorTesten();

        int huidigeHuisIndex = 0;
        int huidigePersonenIndex = 0;

        while(telAantalPersonenInArrayZonderWoonruimte(arrayVanPersonen) > 0)
        {
            //blijf personen toevoegen
        }
        //if boa says cant because of corona dont put person
        //already checked in huisen class, if more than huizencapaciteit dont put person
        //else put person
    }


    void voegEenPersoonToeAanEenHuis(Persoon persoon, Huis huis)
    {
        BoaControllor boaControllor = new BoaControllor();
        if(boaControllor.checkDeCoronaRegelsOfToevoegenMag(huis) == true)
        {
            //Note that the hous class already checks if its maxcapacity is reached or not
            huis.persoonToevoegenAanHuis(persoon);
        }
        else
        {
            //vindt ander huis
            //make sure to add a stop if no house is found
        }
        //if boa says cant because of corona dont put person
        //already checked in huisen class, if more than huizencapaciteit dont put person
        //else put person
    }

    void probeerEenAnderHuisTeVinden(Persoon persoon, int huidigeHuisIndex)
    {
       // voegEenPersoonToeAanEenHuis(persoon, );
    }


    Huis[] maakEenArrayVanHuizenVoorTesten()
    {

    }


    Persoon[] maakEenArrayVanPersonenVoorTesten()
    {

    }


    int telAantalPersonenInArrayZonderWoonruimte(Persoon[] personenInLijst){
        int aantalPersonenInLijstZonderWoonruimte = 0;
        for(Persoon persoon : personenInLijst)
        {
            if(!(persoon == null) && (persoon.getHeeftWoonruimte() == false))
            {
                aantalPersonenInLijstZonderWoonruimte = aantalPersonenInLijstZonderWoonruimte + 1;
            }
        }
        return aantalPersonenInLijstZonderWoonruimte;
    }

}
