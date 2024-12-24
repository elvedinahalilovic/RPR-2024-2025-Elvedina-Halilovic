package com.example.zadatak2lv08.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class PredmetModel {
    private ObservableList<Predmet> predmeti;

    public PredmetModel() {
        predmeti = FXCollections.observableArrayList();
    }
    // CREATE
    public String dodajPredmet(String naziv, Double ECTS) {
        try {
            Predmet noviPredmet = new Predmet(naziv, ECTS);
            predmeti.add(noviPredmet);
            return "Predmet je uspješno dodan!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    // READ
    public ObservableList<Predmet> dajSvePredmete() {
        return predmeti;
    }

    public Predmet dajPredmetPoNazivu(String naziv) {
        for (Predmet predmet : predmeti) {
            if (predmet.getNaziv().equals(naziv)) {
                return predmet;
            }
        }
        return null;
    }

    // UPDATE
    public String azurirajPredmet(String naziv, String noviNaziv, Double noviECTS) {
        Predmet trazeniPredmet = dajPredmetPoNazivu(naziv);
        try {
            if (trazeniPredmet != null) {
                if (noviNaziv != null) trazeniPredmet.setNaziv(noviNaziv);
                if (noviECTS != null) trazeniPredmet.setECTS(noviECTS);
                return "Uspješno ažuriran traženi predmet.";
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Predmet nije pronađen.";
    }

    // DELETE
    public String obrisiPredmet(String naziv) {
        for (Predmet predmet : predmeti) {
            if (predmet.getNaziv().equals(naziv)) {
                predmeti.remove(predmet);
                return "Predmet je uspješno obrisan!";
            }
        }
        return "Predmet nije pronađen!";
    }

    public void napuni() {
        predmeti.add(new Predmet("Matematika", 6.0));
        predmeti.add(new Predmet("Fizika", 7.5));
    }


    public void napuniPodatkeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException {
        predmeti = FXCollections.observableArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));

        String linija;
        while ((linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 2) {
                String naziv = polja[0];
                Double ECTS = Double.parseDouble(polja[1]);

                Predmet predmet = new Predmet(naziv, ECTS);
                predmeti.add(predmet);
            }
        }
        reader.close();
    }


    public void napuniPodatkeIzXmlDatoteke(String putanjaDoDatoteke) throws Exception {
        predmeti = FXCollections.observableArrayList();
        File xmlFile = new File(putanjaDoDatoteke);

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList listaCvorova = doc.getElementsByTagName("predmet");

        for (int i = 0; i < listaCvorova.getLength(); i++) {
            Node cvor = listaCvorova.item(i);

            if (cvor.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) cvor;

                String naziv = element.getElementsByTagName("naziv").item(0).getTextContent();
                Double ECTS = Double.parseDouble(element.getElementsByTagName("ECTS").item(0).getTextContent());

                Predmet predmet = new Predmet(naziv, ECTS);
                predmeti.add(predmet);
            }
        }
    }

}
