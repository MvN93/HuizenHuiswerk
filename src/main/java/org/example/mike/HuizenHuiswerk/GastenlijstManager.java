package org.example.mike.HuizenHuiswerk;

public class GastenlijstManager {

    private int maxCapaciteitOnderCoronaMaatregel;
    private Persoon[] gastenLijst; //dit kan als losse klasse misschien?

    GastenlijstManager(int maxCapaciteitOnderCoronaMaatregel)
    {
        setMaxCapaciteitOnderCoronaMaatregel(maxCapaciteitOnderCoronaMaatregel);
        this.gastenLijst = new Persoon[maxCapaciteitOnderCoronaMaatregel];
    }

    void voegPersoonToeAanGastenlijst(Persoon persoon)
    {
        if(telPersonenOpGastenlijst()<6)
        {
            int toevoegenOpIndex = telPersonenOpGastenlijst();
            gastenLijst[toevoegenOpIndex] = persoon;
        }
        else
        {
            System.out.println("Te veel personen!");
        }
    }

    int telPersonenOpGastenlijst()
    {

        int index = 0;
        for(Persoon persoon : gastenLijst)
        {
            if(!(persoon == null))
            {
                index = index + 1;
            }
        }
        return index;
    }



    void setMaxCapaciteitOnderCoronaMaatregel(int maxCapaciteitOnderCoronaMaatregel) {
        this.maxCapaciteitOnderCoronaMaatregel = maxCapaciteitOnderCoronaMaatregel;
    }


    int getMaxCapaciteitOnderCoronaMaatregel() {
        return maxCapaciteitOnderCoronaMaatregel;
    }

    Persoon[] getGastenLijst() {
        return gastenLijst;
    }
}
