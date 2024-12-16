package com.example.lv07;

import com.example.lv07.controller.OsobaController;
import com.example.lv07.model.OsobaModel;
import com.example.lv07.view.OsobaView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        // launch(); // Ovo ostaje zakomentarisano jer se GUI ne koristi.

        // KOD ZA ZADATAK
        // Kreiranje modela i popunjavanje podacima.
        OsobaModel osobaModel = new OsobaModel();
        osobaModel.napuni();

        // Instanciranje View komponente i postavljanje ulaznog teksta.
        OsobaView osobaView = new OsobaView();
        osobaView.setUlazniTekst("Novo ime");

        // Instanciranje kontrolera na osnovu modela i view-a.
        OsobaController osobaController = new OsobaController(osobaModel, osobaView);

        // Ažuriranje imena osobe sa ID-jem 1.
        osobaController.azurirajIme(1);

        // Ispis rezultata u konzolu.
        System.out.println("1) View ispisuje: " + osobaView.getPoruka());
        System.out.println("   Ažurirana osoba je: " + osobaController.dajOsobuPoId(1).toString());

        // Pokušaj učitavanja podataka iz tekstualne datoteke.
        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());

        // Pokušaj učitavanja podataka iz XML datoteke.
        osobaController.dajOsobeIzXmlDatoteke("src/data/osobe.xml");
        System.out.println("3) View ispisuje: " + osobaView.getPoruka());
    }
}

/*
    public static void main(String[] args) {
        launch();
    }
}*/