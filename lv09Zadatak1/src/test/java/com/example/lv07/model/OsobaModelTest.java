package com.example.lv07.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaModelTest {
    private OsobaModel osobaModel;
    @Test
    void azurirajOsobu() {
        osobaModel = new OsobaModel();
        osobaModel.napuni();

        //id postoji
        String ocekivano1 = osobaModel.azurirajOsobu(1,"Nikic", null, null, null,null,null);
        assertEquals("Uspjesno azurirana trazena osoba.",ocekivano1);

        //testiranje da li se samo ime promijenilo
        Osoba ocekivana = osobaModel.dajOsobuPoId(1);
        assertEquals(ocekivana.getIme(),"Nikic");
        assertEquals(ocekivana.getPrezime(),"Nekic");//promjenilo se samo ime,a prezime je isto

        //id ne postoji
        String ocekivano2 = osobaModel.azurirajOsobu(3,"Novo ime", null, null, null,null,null);
        Osoba ocekivana2 = osobaModel.dajOsobuPoId(3);
        assertNull(ocekivana2); //ovo je testiranje dajOsobuPoId jer ona vraca null
        assertEquals("Osoba nije pronadjena.",ocekivano2); //azurirajOsobu vraca string
    }

    @Test
    void napuni() {
        osobaModel = new OsobaModel();
        osobaModel.napuni();
        Osoba osoba = new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25), "2509997123456", Uloga.STUDENT);
        Osoba ocekivana = osobaModel.dajOsobuPoId(1);
        assertEquals(ocekivana.getId(), osoba.getId());
        assertEquals(ocekivana.getMaticniBroj(), osoba.getMaticniBroj());
        assertEquals(ocekivana.getPrezime(), osoba.getPrezime());
        assertEquals(ocekivana.getIme(), osoba.getIme());
       /* ObservableList<Osoba> osobe = osobaModel.dajSveOsobe(); //Drugi nacin da izbjegnes incijaliziranje ocekivana
       Osoba osoba1 = osobe.get(0);
        assertEquals(1, osoba1.getId());
        assertEquals("Neko", osoba1.getIme());
        assertEquals("Nekic", osoba1.getPrezime());
        assertEquals("Neka adresa", osoba1.getAdresa());
        assertEquals(new Date(97, 8, 25), osoba1.getDatumRodjenja());
        assertEquals("2509997123456", osoba1.getMaticniBroj());
        assertEquals(Uloga.STUDENT, osoba1.getUloga());
*/
    }
}