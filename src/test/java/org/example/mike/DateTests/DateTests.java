package org.example.mike.DateTests;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTests {

    @Test
    void eersteTestMetDate(){
        System.out.println(LocalDateTime.now());

        LocalDateTime eenTestDatum = LocalDateTime.of(2012,3,4,3,2);
        LocalTime hoeLaatKomtReservering = eenTestDatum.toLocalTime();
        System.out.println(eenTestDatum);
        System.out.println(hoeLaatKomtReservering);
    }

    @Test
    void testenMetZelfdeTijdVerschillendeDatum(){
        LocalDateTime eenTestDatum = LocalDateTime.of(2012,3,4,3,2);
        LocalTime hoeLaatKomtReservering = eenTestDatum.toLocalTime();
        LocalDateTime eenTweedeTestDatum = LocalDateTime.of(2015,4,4,3,2);
        LocalTime hoeLaatKomtTweedeReservering = eenTweedeTestDatum.toLocalTime();
        if(hoeLaatKomtReservering.equals(hoeLaatKomtTweedeReservering)){
            System.out.println("Zelfde tijd, kan niet reserveren! Maar hebben we de datum gechecked?");
        }
        else{
            System.out.println("Kan reserveren.");
        }

    }

    @Test
    void assertThatLocalDateTimeZelfGemaakt(){
        LocalDate datumVandaag = LocalDate.now();
        LocalTime tijdNu = LocalTime.now();
        LocalDateTime datumVandaagEnTijdNu = LocalDateTime.of(datumVandaag, tijdNu);
        LocalDateTime localDateTime = LocalDateTime.now();

        assertThat(datumVandaagEnTijdNu).isEqualTo(localDateTime);
    }
}
