import Klase.Meso;
import Klase.Povrce;
import Klase.Prodavac;
import Klase.Voce;
import Klase.VrstaMesa;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Kreiranje objekata
        Voce jabuka = new Voce("Malus domestica", "Hrvatska", List.of(10.0, 15.9, 20.0, 5.0));
        Povrce mrkva = new Povrce("Daucus carota", "Bosna i Hercegovina", List.of(10.0, 15.9, 20.0, 5.0));
        Meso piletina = new Meso(VrstaMesa.PILETINA, "Srbija", List.of(30.3, 10.0, 50.0));
        Prodavac prodavac = new Prodavac("Amir", "Alic", 1, "18246201");
        System.out.println("Jabuka kalorije: " + jabuka.DajBrojKalorija());
        System.out.println("Jabuka zdrava: " + jabuka.Zdravlje(0.8));

        System.out.println("Mrkva kalorije: " + mrkva.DajBrojKalorija());
        System.out.println("Mrkva zdrava: " + mrkva.Zdravlje(0.6));

        System.out.println("Piletina kalorije: " + piletina.DajBrojKalorija());
        System.out.println("Piletina zdrava: " + piletina.Zdravlje(0.96));

        System.out.println("Prodavač zdrav: " + prodavac.Zdravlje(0));
    }
}