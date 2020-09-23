package org.example.mike.HuizenHuiswerk;

public class Adres {
    private String woonplaats;
    private String straat;
    private int nummer;
    private String land;

    Adres(String woonplaats, String straat, int nummer, String land)
    {
        this.woonplaats = woonplaats;
        this.straat = straat;
        this.nummer = nummer;
        this.land = land;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getStraat() {
        return straat;
    }

    public int getNummer() {
        return nummer;
    }

    public String getLand() {
        return land;
    }

    String toStringRepresentation()
    {
        return "Straat: " + straat + " " + nummer + ", Plaats: " + woonplaats + ". " + land;
    }
}
