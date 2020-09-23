package org.example.mike.RestaurantHuiswerk;

import org.junit.jupiter.api.Test;

public class RestaurantTests {

    @Test
    void test(){
        Restaurant[] restaurants = maakRestaurantsAan();
    }

    @Test
    Restaurant[] maakRestaurantsAan(){
        Adres adresRestaurant1 = new Adres("Zeestraat", 5, "Apeldoorn");
        Adres adresRestaurant2 = new Adres("Zabstraat", 2, "Amsterdam");
        Adres adresRestaurant3 = new Adres("Steenworp", 52, "Utrecht");
        Adres adresRestaurant4 = new Adres("Uver", 21, "Bergen");
        Adres adresRestaurant5 = new Adres("Kabeldreef", 33, "Almere");

        Restaurant restaurant1 = new Restaurant(adresRestaurant1,"Zee", 12);
        Restaurant restaurant2 = new Restaurant(adresRestaurant1,"Zab", 11);
        Restaurant restaurant3 = new Restaurant(adresRestaurant1,"Steen", 15);
        Restaurant restaurant4 = new Restaurant(adresRestaurant1,"Uver", 22);
        Restaurant restaurant5 = new Restaurant(adresRestaurant1,"Kabel", 33);

        Restaurant[] restaurants = {restaurant1, restaurant2, restaurant3, restaurant4, restaurant5};
        return restaurants;
    }
}
