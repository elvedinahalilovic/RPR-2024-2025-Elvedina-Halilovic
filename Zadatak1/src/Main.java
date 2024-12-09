import controller.OsobaController;
import model.Osoba;
import model.Uloga;
import view.OsobaView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Osoba osoba1 = new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25),"2509997123456", Uloga.STUDENT);
        System.out.println("Osoba ima pravo na stipendiju: " + osoba1.imaPravoNaStipendiju());

        OsobaView osobaView1 = new OsobaView();
        osobaView1.setUlazniTekst("Novo ime");

        OsobaController osobaController1 = new OsobaController(osoba1, osobaView1);
        osobaController1.azurirajIme();

       System.out.println("1) View ispisuje: " + osobaView1.getPoruka());


        OsobaView osobaView = new OsobaView();
        OsobaController osobaController = new OsobaController(null, osobaView);
        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());
    }
}