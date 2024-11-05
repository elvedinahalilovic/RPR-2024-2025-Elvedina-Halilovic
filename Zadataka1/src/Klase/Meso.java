package Klase;
import Klase.VrstaMesa;
import java.util.List;

public class Meso extends Namjernice {
    private VrstaMesa vrsta;

    public Meso(VrstaMesa vrsta, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(vrsta.name(), zemljaPorijekla, nutritivneVrijednosti);
        this.vrsta = vrsta;
    }

    public double DajBrojKalorija() {
        return Math.round(super.DajBrojKalorija() * 1.2 * 100.0) / 100.0;
    }

    public boolean Zdravlje(double koeficijentZdravlja) {
        return koeficijentZdravlja > 0.95;
    }
}
