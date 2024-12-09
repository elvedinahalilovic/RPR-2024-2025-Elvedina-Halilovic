package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Osoba {
    private Integer id;
    private String ime, prezime, adresa;
    private Date datumRodjenja;
    private String maticniBroj;
    private Uloga uloga;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga){
        setId(id);
        setIme(ime);
        setPrezime(prezime);
        setAdresa(adresa);
        setDatumRodjenja(datumRodjenja);
        setMaticniBroj(maticniBroj);
        setUloga(uloga);

    }
    public boolean ProvjeriMaticniBroj(String maticniBroj){
        boolean danIsti=datumRodjenja.getDate()==Integer.parseInt(maticniBroj.substring(0,2));
        boolean mjesecIsti = datumRodjenja.getMonth()+1==Integer.parseInt(maticniBroj.substring(2,4));
        boolean godinaIsta = datumRodjenja.getYear()+900==Integer.parseInt(maticniBroj.substring(4,7));

        return (danIsti && mjesecIsti && godinaIsta);
    }
    public Integer getId() {
        return id;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public Uloga getUloga() {
        return uloga;
    }

    private void setUloga(Uloga uloga) {
        this.uloga=uloga;
    }

    private void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja=datumRodjenja;
    }

    private void setAdresa(String adresa) {
        this.adresa=adresa;
    }

    public void setId(Integer id){
        this.id=id;}
    public void setPrezime(String prezime){
        this.prezime=prezime;}

    public void setIme(String ime){
        if(ime==null || ime.length()<2 || ime.length()>50){
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova. ");
        }
        this.ime=ime;
    }

    public String getIme(){
        return ime;
    }

    public void setMaticniBroj(String maticniBroj){
        if(maticniBroj.length()!=13 || maticniBroj == null || maticniBroj.trim().isEmpty()){
            throw new IllegalArgumentException("Maticni broj mora imati tacno 13 karaktera!");

        }else if(!ProvjeriMaticniBroj(maticniBroj)){
            throw new IllegalArgumentException("Maticni broj se ne poklapa sa datumom rodjenja!");

        }
        this.maticniBroj=maticniBroj;
    }

    public boolean mozeUcestvovatiUProjektu(boolean voditeljProjekta){
        if(this.uloga==Uloga.NASTAVNO_OSOBLJE || (!voditeljProjekta && this.uloga==Uloga.STUDENT)){
            return true;
        }
        return false;
    }
    public boolean imaPravoNaStipendiju(){
        if(this.uloga==Uloga.STUDENT){
            return true;
        }
        return false;
    }
    public static List<Osoba> ucitajOsobeIzTxtDatoteke(String putanjaDoDatoteke)throws IOException{
        List<Osoba> osobe = new ArrayList<>();
       // try {
            BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] polja = linija.split(",");
                if (polja.length == 7) {
                    try {
                        Integer id = Integer.parseInt(polja[0]);
                        String ime = polja[1];
                        String prezime = polja[2];
                        String adresa = polja[3];
                        Date datumRodjenja = dateFormat.parse(polja[4]);
                        String maticniBroj = polja[5];
                        Uloga uloga = Uloga.valueOf(polja[6].toUpperCase());


                        Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                        osobe.add(osoba);
                    } catch (ParseException e) {
                        System.err.println("Greska pri parsiranju.");
                    }
                }
            }

            reader.close();
      //  }catch(IOException e){System.err.println("Greska pri ucitavanju datoteke.");}
        return osobe;
    }
    public String toString() {
        return "Osoba{" +
                "id='" + id + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", maticniBroj='" + maticniBroj + '\'' + ", uloga=" + uloga + '}';
    }
}
