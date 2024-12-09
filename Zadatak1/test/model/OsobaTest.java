package model;

import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaTest {
    @org.junit.jupiter.api.Test
    void testOsobaIspravnoKreirana(){

        Osoba osoba = new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"2509997123456", Uloga.STUDENT);
        Date datumRodjenja = new Date(97,8,25);
        assertEquals(1, osoba.getId());
        assertEquals("Neko", osoba.getIme());
        assertEquals("Nekic", osoba.getPrezime());
        assertEquals("Neka adresa", osoba.getAdresa());
        assertEquals(datumRodjenja, osoba.getDatumRodjenja());
        assertEquals("2509997123456", osoba.getMaticniBroj());
        assertEquals(Uloga.STUDENT, osoba.getUloga());
    }
    @org.junit.jupiter.api.Test
    void testImeNeispravno(){
        assertThrows(IllegalArgumentException.class, () -> new Osoba(1,"N","Nekic","Neka adresa",
                new Date(97,8,25),"2509997123456", Uloga.STUDENT));
        assertThrows(IllegalArgumentException.class, () -> new Osoba(1,null,"Nekic","Neka adresa",
                new Date(97,8,25),"2509997123456", Uloga.STUDENT));

    }

    @org.junit.jupiter.api.Test
    void testDuzinaMaticnogBroja() {
        assertThrows(IllegalArgumentException.class, ()-> new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"2506", Uloga.STUDENT));
    }
    @org.junit.jupiter.api.Test
    void testMaticniBrojNepodudaranSaDatumomRodjenja() throws Exception {
        assertThrows(IllegalArgumentException.class, ()-> new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,20),"2509997123456", Uloga.STUDENT));
    }
   @org.junit.jupiter.api.Test
   void testNeispravnaPutanja() {
       assertThrows(IOException.class, () -> { Osoba.ucitajOsobeIzTxtDatoteke("src/data/neispravna.txt");
       });
   }
}