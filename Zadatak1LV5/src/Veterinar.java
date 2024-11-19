import java.util.ArrayList;
import java.util.List;

public class Veterinar implements Objekat{
    private String ime;
    private Specijalizacija spec;
    private List<Ljubimac> pregledi;

    public Veterinar(String ime, Specijalizacija spec){
        this.ime=ime;
        this.spec=spec;
        this.pregledi=new ArrayList<>();
}
    public List<Ljubimac> getPregledi() {
        return pregledi;
    }
    public void PregledajLjubimca(Ljubimac ljubimac) throws ValidacijaVrsteException {
        if ((spec == Specijalizacija.Psi && !(ljubimac instanceof Pas)) ||
                (spec == Specijalizacija.Macke && !(ljubimac instanceof Macka))) {
            throw new ValidacijaVrsteException("Nevalidna vrsta ljubimca za ovog veterinara.");
        }
        pregledi.add(ljubimac);
    }
    public String PrikaziInformacije(){
        return "Veterinar: " + ime;
    }
}
