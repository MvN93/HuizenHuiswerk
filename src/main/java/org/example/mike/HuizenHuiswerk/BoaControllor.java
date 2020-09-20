package org.example.mike.HuizenHuiswerk;

public class BoaControllor {
    private int maxCapaciteitHuisVolgensCoronaRegels;
    //onbetrouwbaarheid boa

    BoaControllor()
    {
        maxCapaciteitHuisVolgensCoronaRegels = 6;

        //voeg 20 prozent kans op een random onbetrouwbaarheid toe
    }

    boolean checkDeCoronaRegelsOfToevoegenMag(Huis huis)
    {
        boolean persoonToevoegenMag = false;
        if(huis.telAantalPersonenInHuis() < maxCapaciteitHuisVolgensCoronaRegels) //+onbetrouwbaarheid)
        {
            persoonToevoegenMag = true;
        }
        return persoonToevoegenMag;
    }
}
