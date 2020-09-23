package org.example.mike.RestaurantHuiswerk;



public class Restaurant {
    private Gastenlijstmanager gastenlijstmanager;
    private Adres adres;
    private String naamRestaurant;
    private int totaleCapaciteitRestaurant;
    private BoaController boaController;

    Restaurant(Adres adres, String naamRestaurant, int totaleCapaciteitRestaurant)
    {
        setAdres(adres);
        setNaamRestaurant(naamRestaurant);
        setTotaleCapaciteitRestaurant(totaleCapaciteitRestaurant);
        Gastenlijstmanager gastenlijstmanager = new Gastenlijstmanager(totaleCapaciteitRestaurant, boaController.getCoronaregelsMaximaleCapaciteit());
    }



    //getters and setters
    public Gastenlijstmanager getGastenlijstmanager() {
        return gastenlijstmanager;
    }

    public void setGastenlijstmanager(Gastenlijstmanager gastenlijstmanager) {
        this.gastenlijstmanager = gastenlijstmanager;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getNaamRestaurant() {
        return naamRestaurant;
    }

    public void setNaamRestaurant(String naamRestaurant) {
        this.naamRestaurant = naamRestaurant;
    }

    public int getTotaleCapaciteitRestaurant() {
        return totaleCapaciteitRestaurant;
    }

    public void setTotaleCapaciteitRestaurant(int totaleCapaciteitRestaurant) {
        this.totaleCapaciteitRestaurant = totaleCapaciteitRestaurant;
    }
}
