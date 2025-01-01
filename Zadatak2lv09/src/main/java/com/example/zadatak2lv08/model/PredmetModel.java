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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PredmetModel {
    private ObservableList<Predmet> predmeti;
    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public PredmetModel() {
        predmeti = FXCollections.observableArrayList();
    }
    // CREATE
    public static void kreirajTabeluAkoNePostoji() {
        String kreirajOsobaTabeluSql = """
      CREATE TABLE IF NOT EXISTS Osoba (
          naziv TEXT,
          ECTS INTEGER
      );
   """;


        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajOsobaTabeluSql);
            System.out.println("Tabela je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String dodajPredmet(String naziv, Double ECTS) {
        try {
            Predmet noviPredmet = new Predmet(naziv, ECTS);
            predmeti.add(noviPredmet);
            return "Predmet je uspješno dodan!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    private static PredmetModel instance = null;


    public static PredmetModel getInstance() {
        if (instance == null) {
            instance = new PredmetModel();
        }
        return instance;
    }


    public static void removeInstance() {
        instance = null;
    }

    // READ
  /* public ObservableList<Predmet> dajSvePredmete() {
        return predmeti;
    }

   */
    public List<Predmet> dajSvePredmete() {
        String upit = "SELECT * FROM Predmet";
        List<Predmet> predmeti = new ArrayList<>();

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(upit)) {
            while (rs.next()) {
                Predmet predmet = new Predmet(rs.getString("naziv"), rs.getDouble("ETCS"));
                predmeti.add(predmet);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmeti;
    }

  /*  public Predmet dajPredmetPoNazivu(String naziv) {
        for (Predmet predmet : predmeti) {
            if (predmet.getNaziv().equals(naziv)) {
                return predmet;
            }
        }
        return null;
    }*/
  public static Predmet dajPredmetPoNazivu(String naziv) {
      Predmet predmet = null;
      String upit = "SELECT * FROM Predmet WHERE naziv = ?";

      try (Connection conn = connect();
           PreparedStatement pstmt = conn.prepareStatement(upit)) {

          pstmt.setString(1, naziv);
          ResultSet rs = pstmt.executeQuery();

          if (rs.next()) {
              predmet = new Predmet(
                      rs.getString("naziv"),
                    rs.getDouble("ETCS")
              );
          }
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      return predmet;
  }


    // UPDATE
   /* public String azurirajPredmet(String naziv, String noviNaziv, Double noviECTS) {
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
    }*/

    // DELETE
    public static void isprazniTabeluPredmet(){
        String upit = "DELETE FROM Predmet";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(upit);
            System.out.println("Obrisani redovi tabele. Broj obrisanih redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String azurirajPredmet(String naziv, Double noviECTS){
        StringBuilder upit = new StringBuilder("UPDATE Osoba SET ");
        boolean imaPromjene = false;

        // lista koja cuva parametre
        List<Object> parametri = new ArrayList<>();

        // provjera vrijednosti pojedinih polja (da li su prazna ili ne)
        if (noviECTS != null && noviECTS!=0) {
            upit.append("ECTS = ?, ");
            parametri.add(noviECTS);
            imaPromjene = true;
        }
        upit.delete(upit.length() - 2, upit.length());
        upit.append(" WHERE naziv = ?");

        // dodaj id kao parametar
        parametri.add(naziv);
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(upit.toString())) {

            // dodavanje parameatara u PreparedStatement
            for (int i = 0; i < parametri.size(); i++) {
                pstmt.setObject(i + 1, parametri.get(i));
            }

            int promijenjeniRedovi = pstmt.executeUpdate();
            if (promijenjeniRedovi > 0) {
                return "Predmet je uspjesno azurirana";
            } else {
                return "Ne postoji predmet sa datim nazivom";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }


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
