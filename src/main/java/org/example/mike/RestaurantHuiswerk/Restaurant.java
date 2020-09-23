package org.example.mike.RestaurantHuiswerk;



public class Restaurant {
    Gastenlijstmanager gastenlijstmanager;
    private Adres adres;
    private String naamRestaurant;
    private int totaleCapaciteitRestaurant;
    private BoaController boaController;

    Restaurant(Adres adres, String naamRestaurant, int totaleCapaciteitRestaurant, BoaController boaController, Gastenlijstmanager gastenlijstmanager)
    {
        setAdres(adres);
        setNaamRestaurant(naamRestaurant);
        setTotaleCapaciteitRestaurant(totaleCapaciteitRestaurant);
        setBoaController(boaController);
        setGastenlijstmanager(gastenlijstmanager);
    }



    String toStringRepresentation(){
        return "Restaurant: " + naamRestaurant + "; " + adres.toStringRepresentation() ;
    }

    //getters and setters
    BoaController getBoaController() {
        return this.boaController;
    }
    void setBoaController(BoaController boaController) {
        this.boaController = boaController;
    }

     Gastenlijstmanager getGastenlijstmanager() {
        return gastenlijstmanager;
    }

     void setGastenlijstmanager(Gastenlijstmanager gastenlijstmanager) {
        this.gastenlijstmanager = gastenlijstmanager;
    }

     Adres getAdres() {
        return adres;
    }

     void setAdres(Adres adres) {
        this.adres = adres;
    }

     String getNaamRestaurant() {
        return naamRestaurant;
    }

     void setNaamRestaurant(String naamRestaurant) {
        this.naamRestaurant = naamRestaurant;
    }

     int getTotaleCapaciteitRestaurant() {
        return totaleCapaciteitRestaurant;
    }

     void setTotaleCapaciteitRestaurant(int totaleCapaciteitRestaurant) {
        this.totaleCapaciteitRestaurant = totaleCapaciteitRestaurant;
    }
}
