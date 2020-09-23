package org.example.mike.RestaurantHuiswerk;

public class BoaController {
    private int coronaregelsMaximaleCapaciteit;

    BoaController(){
        coronaregelsMaximaleCapaciteit = 10;
    }


    //getters and setters
    public int getCoronaregelsMaximaleCapaciteit() {
        return coronaregelsMaximaleCapaciteit;
    }

    public void setCoronaregelsMaximaleCapaciteit(int coronaregelsMaximaleCapaciteit) {
        this.coronaregelsMaximaleCapaciteit = coronaregelsMaximaleCapaciteit;
    }
}
