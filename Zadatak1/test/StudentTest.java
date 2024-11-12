import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private static Student s;
    @BeforeAll
    static void beforeAll() {
        s = new Student("Student", "1", "", new Date(98, 2, 2), "12345", 2, 0.0);
    }

    @Test
    void dajInformacije() {
        //Student st = new Student("Student", "1", "", new Date(98, 2, 2), "12345", 2, 0.0);
        String ocekivaniRezultat = "Student: Student 1, broj indeksa: 12345";
        assertEquals(s.DajInformacije(), ocekivaniRezultat);
    }

    @org.junit.jupiter.api.Test
    void provjeriMaticniBroj() {
        assertTrue(s.ProvjeriMaticniBroj("0203998123456")); //mjesec+1
        assertFalse(s.ProvjeriMaticniBroj("3112991123456"));
    }
}