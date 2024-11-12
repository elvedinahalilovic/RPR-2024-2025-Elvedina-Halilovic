import java.util.Date;

public class Asistent extends NastavnoOsoblje{

    private String laboratorija;
    private String termin;

    public Asistent(String ime, String prezime, String adresa, Date datumRodjenja, Integer norma, Integer godinaZaposlenja,
                    String kancelarija, String laboratorija, String termin) {
        super(ime, prezime, adresa, datumRodjenja,norma, godinaZaposlenja, kancelarija);
        this.laboratorija=laboratorija;
        this.termin=termin;
    }

}
