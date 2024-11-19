import java.util.Date;

public abstract class Ljubimac implements Objekat{
    protected String ime;
    protected Date datum;
    protected String zdravstvenoStanje;
    public Ljubimac(String ime, Date datum, String zdravstvenoStanje){
        this.ime = ime;
        this.datum = datum;
        this.zdravstvenoStanje=zdravstvenoStanje;
    }
    public String PrikaziInformacije(){
        return ime+": ";
    }
}
