package org.example.mike.RestaurantHuiswerk;

public class Gastenlijst {
    private Persoon[] gastenlijst;


    Gastenlijst(int maxCapaciteitGastenlijst) {
        gastenlijst = new Persoon[maxCapaciteitGastenlijst];
    }

    void schrijfPersoonInGastenlijst(Persoon persoon){
        gastenlijst[vindtEersteVrijeIndexOpGastenlijst()] = persoon;
    }

    void schrijfPersoonUitGastenlijst(Persoon persoon){
        //constructie vanwege Array's vaststaande lengte
        int index = 0;
        for(Persoon persoonOpLijst : this.gastenlijst) {
            if(gastenlijst[index] == persoon) {
                gastenlijst[index] = null;
            }
            else{
                index = index + 1;
            }
        }
    }

    int telAantalPersonenOpGastenlijst(){
        int index = 0;
        for(Persoon persoon : gastenlijst)
        {
            if(!(persoon == null))
            {
                index = index + 1;
            }
        }
        return index;
    }

    int vindtEersteVrijeIndexOpGastenlijst(){
        if(telAantalPersonenOpGastenlijst() < gastenlijst.length){
            int index = 0;
            while(!(gastenlijst[index] == null)){
                index = index +1;
            }
            return index;
        }
        else{
            return 0;
        }
    }

    void print(){
        for(Persoon persoon : gastenlijst){
            System.out.println(persoon.getNaam());
        }
    }

    //getter
    public Persoon[] getGastenlijst() {
        return gastenlijst;
    }
}
