package com.example.lv07.controller;


import com.example.lv07.model.Osoba;
import com.example.lv07.model.OsobaModel;
import com.example.lv07.view.OsobaView;
import javafx.collections.ObservableList;

import java.util.List;

public class OsobaController
    {
        private OsobaModel model;
        private OsobaView view;


        public OsobaController(OsobaModel model, OsobaView view) {
            this.model = model;
            this.view = view;
        }

        public Osoba dajOsobuPoId(Integer id) {
            return model.dajOsobuPoId(id);
         /*   Osoba osoba = model.dajOsobuPoId(id);

            if (osoba == null) {
                view.setPoruka("Osoba nije pronađena!");
            } else {
                view.setPoruka(osoba.toString());
            }*/
        }


        public void azurirajIme(Integer id){
            try {
                model.azurirajOsobu(id, view.getUlazniTekst(), null, null, null, null, null);
                view.setPoruka("Ime je uspjesno azurirano!");
            }
            catch(Exception e){view.setPoruka("Greska: " + e.getMessage());
            }
        }
        public void dajOsobeIzTxtDatoteke(String filePath)
        {
            try
            {
               model.napuniPodatkeIzTxtDatoteke(filePath);
                String poruka = "Osobe ucitane iz txt datoteke su:\n";
                for (Osoba osoba : model.dajSveOsobe())
                {
                    poruka += osoba.toString() + "\n";
                }
                view.setPoruka(poruka);
            }
            catch(Exception e)
            {
                view.setPoruka("Greska: " + e.getMessage());
            }
        }
        public void dajOsobeIzXmlDatoteke(String filePath)
        {
            try
            {
                model.napuniPodatkeIzXmlDatoteke(filePath);
                String poruka = "Osobe ucitane iz txt datoteke su:\n";
                for (Osoba osoba : model.dajSveOsobe())
                {
                    poruka += osoba.toString() + "\n";
                }
                view.setPoruka(poruka);
            }
            catch(Exception e)
            {
                view.setPoruka("Greska: " + e.getMessage());
            }
        }


    }

