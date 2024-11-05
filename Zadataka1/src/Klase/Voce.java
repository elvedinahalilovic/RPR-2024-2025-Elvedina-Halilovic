package Klase;

import java.util.List;

public class Voce extends Namjernice {
    public Voce(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        super(latinskiNaziv, zemljaPorijekla, nutritivneVrijednosti);
    }
    public boolean Zdravlje(double koeficijentZdravlja) {
        return DajBrojKalorija() < 50 && koeficijentZdravlja > 0.75;
    }
}
