package com.example.zadatak2lv08.controller;

import com.example.zadatak2lv08.model.Predmet;
import com.example.zadatak2lv08.model.PredmetModel;
import com.example.zadatak2lv08.view.PredmetView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PredmetController {

    @FXML
    private TextField nazivField;

    @FXML
    private TextField ectsField;

    @FXML
    private Button dodajPredmetButton;

    @FXML
    private ListView<Predmet> predmetiListView;

    @FXML
    private Label statusLabel;

    private PredmetModel model;

    public PredmetController(PredmetModel model) {
        this.model = model;
    }



    private void dodajPredmet() {
        String naziv = nazivField.getText();
        String ectsText = ectsField.getText();

        if (naziv.isEmpty() || ectsText.isEmpty()) {
            statusLabel.setText("Sva polja moraju biti popunjena!");
            statusLabel.setVisible(true);
            return;
        }

        try {

            Double ECTS = Double.parseDouble(ectsText);
            String message = model.dodajPredmet(naziv, ECTS);

            if (message.equals("Predmet je uspješno dodan!")) {
                // Očisti polja za unos
                nazivField.clear();
                ectsField.clear();
                statusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
                statusLabel.setText(message);
                statusLabel.setVisible(true);


                predmetiListView.setItems(model.dajSvePredmete());

                model.dajSvePredmete().forEach(predmet -> System.out.println(predmet.toString()));
            } else {
                statusLabel.setTextFill(javafx.scene.paint.Color.RED);
                statusLabel.setText(message);
                statusLabel.setVisible(true);
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("ECTS mora biti broj!");
            statusLabel.setVisible(true);
        }
    } // Ažuriranje naziva predmeta
   /* public void azurirajNaziv(String stariNaziv) {
        try {
            model.azurirajPredmet(stariNaziv, view.getUlazniTekst(), null);
            view.setPoruka("Naziv predmeta je uspješno ažuriran!");
        } catch (Exception e) {
            view.setPoruka("Greška: " + e.getMessage());
        }
    }*/
}


