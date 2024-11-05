package Klase;

import java.util.List;

public abstract class Namjernice implements IZdravlje {
    protected String latinskiNaziv;
    protected String zemljaPorijekla;
    protected List<Double> nutritivneVrijednosti;

    public Namjernice(String latinskiNaziv, String zemljaPorijekla, List<Double> nutritivneVrijednosti) {
        this.latinskiNaziv = latinskiNaziv;
        this.zemljaPorijekla = zemljaPorijekla;
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

    public double DajBrojKalorija() {
        double suma = 0.0;
        for (double vrijednost : nutritivneVrijednosti) {
            suma += vrijednost;
        }
        return suma;
    }
}
