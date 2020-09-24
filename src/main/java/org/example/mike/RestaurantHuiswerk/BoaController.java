package org.example.mike.RestaurantHuiswerk;

public class BoaController {
    private int coronaregelsMaximaleCapaciteit;

    BoaController(){
        coronaregelsMaximaleCapaciteit = 10;
    }

    void toetsCoronaregels(Gastenlijstmanager gastenlijstmanager){
        Gastenlijst gastenlijst = gastenlijstmanager.getGastenlijst();
        if(gastenlijst.telAantalPersonenOpGastenlijst() <= coronaregelsMaximaleCapaciteit) {
            System.out.println("Bedankt voor het naleven van de regels.");
        }
        else{
            System.out.println("Uw restaurant krijgt een boete!");
        }
    }

    //getters and setters
    public int getCoronaregelsMaximaleCapaciteit() {
        return coronaregelsMaximaleCapaciteit;
    }

    public void setCoronaregelsMaximaleCapaciteit(int coronaregelsMaximaleCapaciteit) {
        this.coronaregelsMaximaleCapaciteit = coronaregelsMaximaleCapaciteit;
    }
}
