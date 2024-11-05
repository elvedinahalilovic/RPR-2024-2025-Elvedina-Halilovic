package Klase;

import java.util.List;

public class Povrce extends Namjernice {
    public Povrce(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }
    public boolean Zdravlje(double koeficijentZdravlja) {
        return DajBrojKalorija() < 100 && koeficijentZdravlja >= 0.5 && koeficijentZdravlja <= 0.7;
    }
}
