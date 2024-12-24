package com.example.zadatak2lv08.model;


import javafx.beans.property.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Predmet {

    private StringProperty naziv;
    private DoubleProperty ECTS;
    public Predmet(String naziv, Double ECTS){
        this.naziv = new SimpleStringProperty();
        this.ECTS=new SimpleDoubleProperty();
        setECTS(ECTS);
        setNaziv(naziv);
    }
    public String getNaziv(){
        return naziv.get();
    }
    public StringProperty nazivProperty() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        if(naziv.length()<5 || naziv.length()>100){
            throw new IllegalArgumentException("Naziv mora imati duzinu izmedju 5 i 100 znakova.");
        }

        this.naziv.set(naziv);
    }

    public Double getECTS(){
        return ECTS.get();
    }
    public DoubleProperty ECTSProperty() {
        return ECTS;
    }

    public void setECTS(Double ECTS) {
        if(ECTS<5.0 || ECTS>20.0) throw new IllegalArgumentException("ECTS minimalno moze imati vrijednost 5, a maksimalno 20.");
        double n = ECTS*10;
        int cijeli = (int)n;
        if(cijeli%10!=5 && cijeli%10!=0) throw new IllegalArgumentException("ECTS moze imati samo 0 ili 5 kao vrijednost prve decimale.");

        this.ECTS.set(ECTS);
    }

   /* public static List<Predmet> ucitajPredmeteIzTxtDatoteke(String putanjaDoDatoteke) throws IOException {
        List<Predmet> predmeti = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] polja = linija.split(",");
                if (polja.length == 2) {
                    String naziv = polja[0];
                    Double ECTS=Double.parseDouble(polja[1]);
                    Predmet predmet = new Predmet(naziv, ECTS);
                    predmeti.add(predmet);
                }
            }
            reader.close();
        }catch(IOException e){System.err.println("Greska pri ucitavanju datoteke.");}
        return predmeti;
    }*/
    public String toString() {
        return "Predmet{" + "naziv=" + naziv +", ECTS=" + ECTS + '}';
    }

}