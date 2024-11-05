import Klase.Meso;
import Klase.Povrce;
import Klase.Prodavac;
import Klase.Voce;
import Klase.VrstaMesa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> nutritivneVrijednostiVoce = new ArrayList<>();
        nutritivneVrijednostiVoce.add(3.9);
        nutritivneVrijednostiVoce.add(15.9);
        nutritivneVrijednostiVoce.add(20.2);
        nutritivneVrijednostiVoce.add(5.0);

        Voce jabuka = new Voce("Malus domestica", "Hrvatska", nutritivneVrijednostiVoce);

        System.out.println("Jabuka kalorije: " + jabuka.DajBrojKalorija());
        System.out.println("Jabuka je zdrava: " + jabuka.Zdravlje(0.8));

        List<Double> nutritivneVrijednostiPovrce = new ArrayList<>();
        nutritivneVrijednostiPovrce.add(5.0);
        nutritivneVrijednostiPovrce.add(10.0);
        nutritivneVrijednostiPovrce.add(2.5);
        nutritivneVrijednostiPovrce.add(3.0);

        Povrce mrkva = new Povrce("Daucus carota", "Srbija", nutritivneVrijednostiPovrce);

        System.out.println("Mrkva kalorije: " + mrkva.DajBrojKalorija());
        System.out.println("Mrkva je zdrava: " + mrkva.Zdravlje(0.6));

        List<Double> nutritivneVrijednostiMeso = new ArrayList<>();
        nutritivneVrijednostiMeso.add(25.0);
        nutritivneVrijednostiMeso.add(10.0);

        Meso piletina = new Meso(VrstaMesa.PILETINA, "Bosna i Hercegovina", nutritivneVrijednostiMeso);

        System.out.println("Piletina kalorije: " + piletina.DajBrojKalorija());
        System.out.println("Piletina je zdrava: " + piletina.Zdravlje(0.96));

        Prodavac prodavac = new Prodavac("Amir", "Alic", 1, "1875601");

        System.out.println("Prodavac je zdrav: " + prodavac.Zdravlje(0));
    }
}