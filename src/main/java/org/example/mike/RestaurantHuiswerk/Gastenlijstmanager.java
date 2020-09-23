package org.example.mike.RestaurantHuiswerk;

public class Gastenlijstmanager {
    private int maxCapaciteitGastenlijst;
    private Gastenlijst gastenlijst;
    private int foutmarge;
    private int coronaregelsMaximaleCapaciteit;

    Gastenlijstmanager(int maxCapaciteitGastenlijst, int coronaregelsMaximaleCapaciteit)
    {
        setMaxCapaciteitGastenlijst(maxCapaciteitGastenlijst);
        this.gastenlijst = new Gastenlijst(maxCapaciteitGastenlijst);
        maakFoutmargeAan();
        this.coronaregelsMaximaleCapaciteit = coronaregelsMaximaleCapaciteit;
    }

    String toStringRepresentation(){
        return "" + maxCapaciteitGastenlijst + foutmarge + coronaregelsMaximaleCapaciteit;
    }

    void voegPersoonToeAanGastenlijst(Persoon persoon){
        if(gastenlijst.telAantalPersonenOpGastenlijst() < (coronaregelsMaximaleCapaciteit + foutmarge))
        {
            gastenlijst.schrijfPersoonInGastenlijst(persoon);
        }
        else{
            System.out.println("Excuses, het restaurant is vol op dit moment. Probeer het later nogmaals.");
        }
    }

    void haalPersoonUitGastenlijst(Persoon persoon){
        gastenlijst.schrijfPersoonUitGastenlijst(persoon);
    }

    void maakFoutmargeAan() {
        double randomNumber = Math.random();
        if(randomNumber < 0.1){
            foutmarge = -2;
        }
        else if(randomNumber < 0.2){
            foutmarge = -1;
        }
        else if(randomNumber < 0.6){
            foutmarge = 0;
        }
        else if(randomNumber < 0.8){
            foutmarge = 1;
        }
        else{
            foutmarge = 2;
        }
    }

    //getters and setters
    void setMaxCapaciteitGastenlijst(int maxCapaciteitGastenlijst) {
        this.maxCapaciteitGastenlijst = maxCapaciteitGastenlijst;
    }

    int getMaxCapaciteitGastenlijst() {
        return maxCapaciteitGastenlijst;
    }
}


