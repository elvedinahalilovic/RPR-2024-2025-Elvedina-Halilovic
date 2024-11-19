import java.util.Date;

public class Macka extends Ljubimac{
    private VrstaMacke vrsta;
    public Macka(String ime, Date datum, String zdravstvenoStanje, VrstaMacke vrsta){
        super(ime, datum, zdravstvenoStanje);
        this.vrsta=vrsta;
    }
    public String PrikaziInformacije(){
        return "Mačka: "+vrsta;
    }
}
