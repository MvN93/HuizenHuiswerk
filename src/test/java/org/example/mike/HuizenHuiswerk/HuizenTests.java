package org.example.mike.HuizenHuiswerk;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HuizenTests {


    @Test
    void mainTestGenoegWoonruimte()
    {
        Huis[] arrayVanHuizen = maakEenArrayVanHuizenVoorTesten();
        Persoon[] arrayVanPersonen = maakEenArrayVanPersonenVoorTesten();
        voegPersonenToeAanHuizenVolgensCoronaMaatregelen(arrayVanHuizen, arrayVanPersonen);
    }

    @Test
    void mainTestTeWeinigWoonruimte()
    {
        Huis[] arrayVanHuizen = maakEenArrayVanHuizenVoorTesten();
        Persoon[] arrayVanPersonen = maakEenArrayVanTeVeelPersonenVoorTesten();
        voegPersonenToeAanHuizenVolgensCoronaMaatregelen(arrayVanHuizen, arrayVanPersonen);
    }

    void voegPersonenToeAanHuizenVolgensCoronaMaatregelen(Huis[] arrayVanHuizen, Persoon[] arrayVanPersonen)
    {
        BoaControllor boaControllor = new BoaControllor();

        int huidigeHuisIndex = 0;
        int huidigePersonenIndex = 0;
        int aantalPogingenToevoegenVanEenPersoon = 0;
        int aantalPersonenZonderWoonruimte = arrayVanPersonen.length;

        while((boaControllor.getErIsNogCoronaveiligeWoonruimteVrij() == true) && (aantalPersonenZonderWoonruimte > 0))
        {
            //check of er nog mensen zijn zonder woonruimte
            aantalPersonenZonderWoonruimte = telAantalPersonenInArrayZonderWoonruimte(arrayVanPersonen);

            //Zijn er mensen zonder woonruimte en is er corona veilig plek, voeg dan toe. Hou aantal pogingen per persoon bij
            boolean persoonSuccesvolToegevoegd = voegEenPersoonToeAanEenHuis(arrayVanPersonen[huidigePersonenIndex], arrayVanHuizen[huidigeHuisIndex], boaControllor);
            aantalPogingenToevoegenVanEenPersoon = aantalPogingenToevoegenVanEenPersoon + 1;

            //als succesvol toegevoegd, verhoog persoonsindex zodat de volgende ronde van de while loop deze kan worden toegevoegd
            //als niet succesvol, verhoog huizenindex zodat de volgende ronde van de while loop dezelfde persoon in dat huis kan worden toegevoegd
            if(persoonSuccesvolToegevoegd == true)
            {
                huidigePersonenIndex = geefVolgendePersonenIndex(huidigePersonenIndex, arrayVanPersonen);
                huidigeHuisIndex = 0;
                aantalPogingenToevoegenVanEenPersoon = 0;
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

            System.out.println(" ");
            System.out.println("De andere personen zijn als volgend verdeeld:");
            printLijstVanHuizenMetNamenVanInwonenden(arrayVanHuizen);
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
        else if(huis.telAantalPersonenInHuis() == huis.getTotaleCapaciteitHuis()) //als totale capaciteit huis bereikt is return dat niet succesvol is toegevoegd
        {
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
        Adres adresHuis1 = new Adres("Berlin", "Saga", 3, "Duitsland");
        Huis huis0 = new Huis(adresHuis0,3);
        Huis huis1 = new Huis(adresHuis1, 3);
        Huis[] huizen = {huis0, huis1};
        return huizen;
    }


    Persoon[] maakEenArrayVanPersonenVoorTesten()
    {
        Persoon persoon0 = new Persoon("Cihangir", 18);
        Persoon persoon1 = new Persoon("Mike", 27);
        Persoon persoon2 = new Persoon("Hennie", 99);
        Persoon persoon3 = new Persoon("Hans", 88);
        Persoon persoon4 = new Persoon("Halve", 77);
        Persoon persoon5 = new Persoon("Hextra", 66);
        Persoon persoon6 = new Persoon("Hema", 55);
        Persoon persoon7 = new Persoon("Helaas", 44);
        Persoon persoon8 = new Persoon("Handy", 33);
        Persoon[] personen = {persoon0, persoon1, persoon2, persoon3, persoon4, persoon5, persoon6, persoon7, persoon8};
        return personen;
    }

    Persoon[] maakEenArrayVanTeVeelPersonenVoorTesten()
    {
        Persoon persoon0 = new Persoon("Cihangir", 18);
        Persoon persoon1 = new Persoon("Mike", 27);
        Persoon persoon2 = new Persoon("Hennie", 99);
        Persoon persoon3 = new Persoon("Hans", 88);
        Persoon persoon4 = new Persoon("Halve", 77);
        Persoon persoon5 = new Persoon("Hextra", 66);
        Persoon persoon6 = new Persoon("Hema", 55);
        Persoon persoon7 = new Persoon("Helaas", 44);
        Persoon persoon8 = new Persoon("Handy", 33);
        Persoon persoon9 = new Persoon("Hesse", 11);
        Persoon persoon10 = new Persoon("Hanna", 22);
        Persoon persoon11 = new Persoon("Hely", 35);
        Persoon persoon12 = new Persoon("Honas", 56);
        Persoon persoon13 = new Persoon("Hrandy", 74);
        Persoon[] personen = {persoon0, persoon1, persoon2, persoon3, persoon4, persoon5, persoon6, persoon7, persoon8, persoon9, persoon10, persoon11, persoon12, persoon13};
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
        if(huidigePersonenIndex < (arrayVanPersonen.length - 1))
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
        if(huidigeHuizenIndex < (arrayVanHuizen.length - 1))
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
