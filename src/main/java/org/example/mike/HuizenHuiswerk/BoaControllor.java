package org.example.mike.HuizenHuiswerk;

public class BoaControllor {
    private int maxCapaciteitHuisVolgensCoronaRegels;
    private boolean erIsNogCoronaveiligeWoonruimteVrij;

    BoaControllor()
    {
        maxCapaciteitHuisVolgensCoronaRegels = 6;
        erIsNogCoronaveiligeWoonruimteVrij = true;
    }

    int getMaxCapaciteitHuisVolgensCoronaRegels() {
        return maxCapaciteitHuisVolgensCoronaRegels;
    }

    void setMaxCapaciteitHuisVolgensCoronaRegels(int maxCapaciteitHuisVolgensCoronaRegels) {
        this.maxCapaciteitHuisVolgensCoronaRegels = maxCapaciteitHuisVolgensCoronaRegels;
    }

    boolean getErIsNogCoronaveiligeWoonruimteVrij()
    {
        return erIsNogCoronaveiligeWoonruimteVrij;
    }

    void setErIsNogCoronaveiligeWoonruimteVrij(boolean erIsNogCoronaveiligeWoonruimteVrij)
    {
        this.erIsNogCoronaveiligeWoonruimteVrij = erIsNogCoronaveiligeWoonruimteVrij;
    }

    boolean checkDeCoronaRegelsOfToevoegenMag(Huis huis)
    {
        boolean persoonToevoegenMag = false;
        if(huis.telAantalPersonenInHuis() < maxCapaciteitHuisVolgensCoronaRegels)
        {
            persoonToevoegenMag = true;
        }
        return persoonToevoegenMag;
    }
}
