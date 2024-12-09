package controller;

import model.Predmet;
import view.PredmetView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PredmetController {
    private Predmet model;
    private PredmetView view;

    public PredmetController(Predmet model, PredmetView view){
        setModel(model);
        setView(view);
    }
    public Predmet getModel() {
        return model;
    }

    public void setModel(Predmet model) {
        this.model = model;
    }


    public PredmetView getView() {
        return view;
    }

    public void setView(PredmetView view) {
        this.view = view;
    }

    public void azurirajNaziv(){
        try {
            model.setNaziv(view.getUlazniTekst());
            view.setPoruka("Naziv uspjeno azuriran.");
        }catch(Exception e){
            view.setPoruka("Greska: "+ e.getMessage());
        }

    }
    public void azurirajECTS() {
        try {
            model.setECTS(Double.parseDouble(view.getUlazniTekst()));
            view.setPoruka("Vrijednost ECTS kredita uspjeno azurirana.");
        } catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void dajOsobeIzTxtDatoteke(String filePath)
    {
        try
        {
            List<Predmet> predmeti = Predmet.ucitajPredmeteIzTxtDatoteke(filePath);
            String poruka = "Predmeti ucitani iz txt datoteke su:\n";
            for (Predmet predmet : predmeti)
            {
                poruka += predmet.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    }


