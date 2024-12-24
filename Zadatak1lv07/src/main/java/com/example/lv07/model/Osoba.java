package com.example.lv07.model;

import javafx.beans.property.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Osoba {
    private IntegerProperty id;
    private StringProperty ime, prezime, adresa;
    private ObjectProperty<Date> datumRodjenja;
    private StringProperty maticniBroj;
    private ObjectProperty<Uloga> uloga;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        // inicijalizacija polja
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
        this.datumRodjenja = new SimpleObjectProperty<>(datumRodjenja);
        this.maticniBroj = new SimpleStringProperty();
        this.uloga = new SimpleObjectProperty<>(uloga);


        // validacija polja
        setIme(ime);
        setMaticniBroj(maticniBroj);
    }

  /*  public boolean ProvjeriMaticniBroj(String maticniBroj){
        boolean danIsti=datumRodjenja.getDate()==Integer.parseInt(maticniBroj.substring(0,2));
        boolean mjesecIsti = datumRodjenja.getMonth()+1==Integer.parseInt(maticniBroj.substring(2,4));
        boolean godinaIsta = datumRodjenja.getYear()+900==Integer.parseInt(maticniBroj.substring(4,7));

        return (danIsti && mjesecIsti && godinaIsta);
    }
    */


    //id
    public Integer getId(){
        return id.get();
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public void setId(Integer id) {
        this.id.set(id);
    }
// prezime
    public String getPrezime() {
        return prezime.get();
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }
// adresa
public String getAdresa() {
    return adresa.get();
}

    public StringProperty adresaProperty() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }
//datumRodjenja
public Date getDatumRodjenja() {
    return datumRodjenja.get();
}

    public ObjectProperty<Date> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }
    //maticniBroj

    public String getMaticniBroj() {
        return maticniBroj.get();
    }

    public StringProperty maticniBrojProperty() {
        return maticniBroj;
    }
    public void setMaticniBroj(String maticniBroj) {
        if (maticniBroj == null || maticniBroj.trim().isEmpty() || maticniBroj.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera");
        }
      /*  else if(!ProvjeriMaticniBroj(maticniBroj)){
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");
        }*/
        this.maticniBroj.set(maticniBroj);
    }
//uloga
public Uloga getUloga() {
    return uloga.get();
}

    public ObjectProperty<Uloga> ulogaObjectProperty() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }
    //ime
    public void setIme(String ime) {
        if (ime == null || ime.length() < 2 || ime.length() > 50) {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
        this.ime.set(ime);
    }

    public String getIme() {
        return ime.get();
    }

    public StringProperty imeProperty() {
        return ime;
    }
    public String toString() {
        return "Osoba{" +
                "id='" + id + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", maticniBroj='" + maticniBroj + '\'' + ", uloga=" + uloga + '}';
    }

}
