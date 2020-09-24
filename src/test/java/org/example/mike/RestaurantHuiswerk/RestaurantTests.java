package org.example.mike.RestaurantHuiswerk;

import org.junit.jupiter.api.Test;

public class RestaurantTests {

    @Test
    void test(){
        Adres adresRestaurant1 = new Adres("Zeestraat", 5, "Apeldoorn");
        BoaController boaController = new BoaController();
        Gastenlijstmanager gastenlijstmanager = new Gastenlijstmanager(12, boaController.getCoronaregelsMaximaleCapaciteit());
        Restaurant restaurant1 = new Restaurant(adresRestaurant1,"Zee", 12, boaController, gastenlijstmanager);

        printLijstVanRestaurant(restaurant1, gastenlijstmanager);

        Persoon[] arrayPersonen = maakEenArrayVanPersonen();
        for(Persoon persoon : arrayPersonen)
        {
            gastenlijstmanager.voegPersoonToeAanGastenlijst(persoon);
        }

        System.out.println("");

        printGastenlijst(gastenlijstmanager);

        System.out.println("");
        boaController.toetsCoronaregels(gastenlijstmanager);

    }



    Persoon[] maakEenArrayVanPersonen()
    {
        Persoon persoon1 = new Persoon("Cihangir");
        Persoon persoon2 = new Persoon("Mike");
        Persoon persoon3 = new Persoon("Herd");
        Persoon persoon4 = new Persoon("Haast");
        Persoon persoon5 = new Persoon("Hela");
        Persoon persoon6 = new Persoon("Hir");
        Persoon persoon7 = new Persoon("Hanni");
        Persoon persoon8 = new Persoon("Hana");
        Persoon persoon9 = new Persoon("Help");
        Persoon persoon10 = new Persoon("Sjon");
        Persoon persoon11 = new Persoon("Sara");
        Persoon persoon12 = new Persoon("Son");
        Persoon persoon13 = new Persoon("Sana");
        Persoon persoon14 = new Persoon("Raga");
        Persoon persoon15 = new Persoon("Ree");
        Persoon persoon16 = new Persoon("Rehen");
        Persoon persoon17 = new Persoon("Rada");
        Persoon persoon18 = new Persoon("Tri");
        Persoon persoon19 = new Persoon("Troom");
        Persoon persoon20 = new Persoon("Tal");
        Persoon[] personen = {persoon1, persoon2, persoon3, persoon4, persoon5, persoon6, persoon7, persoon8, persoon9, persoon10, persoon11, persoon12, persoon13, persoon14, persoon15, persoon16, persoon17, persoon18, persoon19, persoon20};
        return personen;
    }

    void printLijstVanRestaurant(Restaurant restaurant, Gastenlijstmanager gastenlijstmanager)
    {
        System.out.println(restaurant.toStringRepresentation());
        System.out.println(gastenlijstmanager.toStringRepresentation());
        System.out.println(" ");
    }

    void printGastenlijst(Gastenlijstmanager gastenlijstmanager)
    {
        Gastenlijst gastenlijst = gastenlijstmanager.getGastenlijst();
        Persoon[] gastenlijstPersonen = gastenlijst.getGastenlijst();
        for(Persoon persoon : gastenlijstPersonen) {
            if(!(persoon == null)){
                System.out.println(persoon.getNaam());
            }
        }
    }
}
