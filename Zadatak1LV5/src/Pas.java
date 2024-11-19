import java.util.Date;

public class Pas extends Ljubimac{
    private VrstaPsa vrsta;
    public Pas(String ime, Date datum, String zdravstvenoStanje, VrstaPsa vrsta){
        super(ime, datum, zdravstvenoStanje);
        this.vrsta=vrsta;
    }
    public String PrikaziInformacije(){
        String izlaz="Pas: ";
        if(vrsta == VrstaPsa.ZlatniRetreiver){
            return izlaz +"Zlatni Retreiver";
        }else{
        return izlaz+vrsta;}
    }
}
