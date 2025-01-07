import java.util.List;

public class PretragaNiti extends Thread{
    Integer pocetak, kraj;

    public PretragaNiti(Integer pocetak, Integer kraj){
        this.pocetak= pocetak;
        this.kraj=kraj;

    }

    public void run() {

        for (int i = pocetak; i < kraj && !Main.pronadjen; i++) {
            if (Main.brojevi.get(i) == Main.trazeniBroj) {
                Main.pronadjen = true;
                System.out.println("Broj pronađen u dijelu [" + pocetak + ", " + kraj + ") na poziciji: " + i);
                return;
            }
        }
    }
}
