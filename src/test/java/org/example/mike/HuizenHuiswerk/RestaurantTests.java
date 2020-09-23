package org.example.mike.HuizenHuiswerk;

import org.junit.jupiter.api.Test;

public class RestaurantTests {

    @Test
    void testGastenLijstManager()
    {
        Persoon[] personenArray = maakEenArrayVanPersonenVoorTesten();
        GastenlijstManager gastenlijstManager = new GastenlijstManager(6);
        gastenlijstManager.voegPersoonToeAanGastenlijst(personenArray[0]);
        System.out.println(gastenlijstManager.getGastenLijst());
    }

    Persoon[] maakEenArrayVanPersonenVoorTesten()
    {
        Persoon persoon0 = new Persoon("Cihangir", 18);
        Persoon persoon1 = new Persoon("Mike", 27);
        Persoon persoon2 = new Persoon("Hennie", 99);
        Persoon persoon3 = new Persoon("Hans", 88);
        Persoon persoon4 = new Persoon("Halve", 77);
        Persoon persoon5 = new Persoon("Hextra", 66);
        Persoon persoon6 = new Persoon("Hema", 55);
        Persoon persoon7 = new Persoon("Helaas", 44);
        Persoon persoon8 = new Persoon("Handy", 33);
        Persoon persoon9 = new Persoon("Hesse", 11);
        Persoon persoon10 = new Persoon("Hanna", 22);
        Persoon persoon11 = new Persoon("Hely", 35);
        Persoon persoon12 = new Persoon("Honas", 56);
        Persoon persoon13 = new Persoon("Hrandy", 74);
        Persoon[] personen = {persoon0, persoon1, persoon2, persoon3, persoon4, persoon5, persoon6, persoon7, persoon8, persoon9, persoon10, persoon11, persoon12, persoon13};
        return personen;
    }
}
