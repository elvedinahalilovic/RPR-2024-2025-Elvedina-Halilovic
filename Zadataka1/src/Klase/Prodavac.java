package Klase;

public class Prodavac implements IZdravlje {
    private String ime;
    private String prezime;
    private int brojStanda;
    private String idBrojLicence;

    public Prodavac(String ime, String prezime, int brojStanda, String idBrojLicence) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojStanda = brojStanda;
        this.idBrojLicence = idBrojLicence;
    }

    public boolean Zdravlje(double koeficijentZdravlja) {
        return idBrojLicence.length() >= 2 && idBrojLicence.substring(idBrojLicence.length() - 2).equals("01");
    }
}
