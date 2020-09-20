package org.example.mike.HuizenHuiswerk;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HuizenTests {


    @Test
    void mainTest()
    {
        Huis[] arrayVanHuizen = maakEenArrayVanHuizenVoorTesten();
        Persoon[] arrayVanPersonen = maakEenArrayVanPersonenVoorTesten();
        BoaControllor boaControllor = new BoaControllor();

        int huidigeHuisIndex = 0;
        int huidigePersonenIndex = 0;
        int aantalPogingenToevoegenVanEenPersoon = 0;
        int aantalPersonenZonderWoonruimte = arrayVanPersonen.length;

        while((boaControllor.getErIsNogCoronaveiligeWoonruimteVrij() == true) && (aantalPersonenZonderWoonruimte > 0))
        {
            //Zijn er mensen zonder woonruimte en is er corona veilig plek, voeg dan toe. Hou aantal pogingen per persoon bij
            boolean persoonSuccesvolToegevoegd = voegEenPersoonToeAanEenHuis(arrayVanPersonen[huidigePersonenIndex],arrayVanHuizen[huidigeHuisIndex] ,boaControllor);
            aantalPogingenToevoegenVanEenPersoon = aantalPogingenToevoegenVanEenPersoon + 1;

            //als succesvol toegevoegd, verhoog persoonsindex zodat de volgende ronde van de while loop deze kan worden toegevoegd
            //als niet succesvol, verhoog huizenindex zodat de volgende ronde van de while loop dezelfde persoon in dat huis kan worden toegevoegd
            if(persoonSuccesvolToegevoegd == true)
            {
                huidigePersonenIndex = geefVolgendePersonenIndex(huidigePersonenIndex, arrayVanPersonen);
            }
            else
            {
                huidigeHuisIndex = geefVolgendeHuizenIndex(huidigeHuisIndex, arrayVanHuizen);

                //als niet succesvol is toegevoegd check dan of niet al te vaak geprobeerd
                if(aantalPogingenToevoegenVanEenPersoon > arrayVanHuizen.length)
                {
                    boaControllor.setErIsNogCoronaveiligeWoonruimteVrij(false);
                }
            }

            //check of er nog mensen zijn zonder woonruimte
            aantalPersonenZonderWoonruimte = telAantalPersonenInArrayZonderWoonruimte(arrayVanPersonen);

        }
        //Als while loop stopt zijn er of geen personen meer zonder woonruimte, print dan lijst van namen per woning
        if(aantalPersonenZonderWoonruimte == 0)
        {
            System.out.println("Er is voor iedereen woonruimte gevonden.");

            System.out.println("De woonruimtes zijn als volgend verdeeld:");
            printLijstVanHuizenMetNamenVanInwonenden(arrayVanHuizen);
        }

        //of is er geen veilige woonruimte meer, print dan
        if((boaControllor.getErIsNogCoronaveiligeWoonruimteVrij() == false) && (aantalPersonenZonderWoonruimte > 0))
        {
            System.out.println("Er is vanwege de Corona maatregelen helaas niet genoeg woonruimte beschikbaar.");

            System.out.println("De volgende personen zijn nog zonder woonruimte:");
            printPersonenZonderWoonruimte(arrayVanPersonen);
        }
    }


    boolean voegEenPersoonToeAanEenHuis(Persoon persoon, Huis huis, BoaControllor boaControllor)
    {
        boolean persoonSuccesvolToegevoegd = false;

        //zodat we alleen toevoegen als deze persoon nog geen woonruimte heeft
        if(persoon.getHeeftWoonruimte() == true)
        {
            persoonSuccesvolToegevoegd = true;
            return persoonSuccesvolToegevoegd;
        }
        else
        {
            //laat boa checken of in dit huis nog mag met corona, als ja voeg toe, anders return false
            if(boaControllor.checkDeCoronaRegelsOfToevoegenMag(huis) == true)
            {
                //Note that the hous class already checks if its maxcapacity is reached or not (now this could still give a problem if person is not added because of this)
                huis.persoonToevoegenAanHuis(persoon);
                persoon.setHeeftWoonruimte(true);
                persoonSuccesvolToegevoegd = true;
            }
            return persoonSuccesvolToegevoegd;
        }
    }

    void probeerEenAnderHuisTeVinden(Persoon persoon, int huidigeHuisIndex)
    {
       // voegEenPersoonToeAanEenHuis(persoon, );
    }


    Huis[] maakEenArrayVanHuizenVoorTesten()
    {
        Adres adresHuis0 = new Adres("Amsterdam", "Zilverweg", 44, "Nederland");
        Adres adresHuis1 = new Adres("Eindhoven", "Zegenstraat", 3, "Nederland");
        Huis huis0 = new Huis(adresHuis0,3);
        Huis huis1 = new Huis(adresHuis1, 4);
        Huis[] huizen = {huis0, huis1};
        return huizen;
    }


    Persoon[] maakEenArrayVanPersonenVoorTesten()
    {
        Persoon persoon0 = new Persoon("Cihangir", 18);
        Persoon persoon1 = new Persoon("Mike", 27);
        Persoon[] personen = {persoon0, persoon1};
        return personen;
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

    void printPersonenZonderWoonruimte(Persoon[] personenInLijst)
    {
        for(Persoon persoon : personenInLijst)
        {
            if(!(persoon == null) && (persoon.getHeeftWoonruimte() == false))
            {
                System.out.println(persoon.getNaam());;
            }
        }
    }

    void printLijstVanHuizenMetNamenVanInwonenden(Huis[] arrayVanHuizen)
    {
        for(Huis huis : arrayVanHuizen)
        {
            System.out.println(huis.toStringRepresentationOfAdres());
            huis.printLijstjeVanAlleInwonenden();
            System.out.println(" ");
        }
    }

    int geefVolgendePersonenIndex(int huidigePersonenIndex, Persoon[] arrayVanPersonen)
    {
        if(huidigePersonenIndex < arrayVanPersonen.length)
        {
            huidigePersonenIndex = huidigePersonenIndex + 1;
        }
        else
        {
            huidigePersonenIndex = 0;
        }
        return huidigePersonenIndex;
    }

    int geefVolgendeHuizenIndex(int huidigeHuizenIndex, Huis[] arrayVanHuizen)
    {
        if(huidigeHuizenIndex < arrayVanHuizen.length)
        {
            huidigeHuizenIndex = huidigeHuizenIndex + 1;
        }
        else
        {
            huidigeHuizenIndex = 0;
        }
        return huidigeHuizenIndex;
    }

}
