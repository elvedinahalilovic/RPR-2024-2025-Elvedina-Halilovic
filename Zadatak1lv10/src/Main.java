import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static List<Integer> brojevi;
    public static Integer trazeniBroj;
    public static boolean pronadjen;
    public static void main(String[] args) {

        Random random = new Random();
        pronadjen=false;
        List<Integer> brojevi = new ArrayList<>();
        for(int i=0; i<100000000; i++){
            brojevi.add(random.nextInt(0,10000));

        }
        Main.brojevi=brojevi; //zasto sam ovo morala uraditi?
        List<PretragaNiti> niti = new ArrayList<PretragaNiti>();
        trazeniBroj = brojevi.get(random.nextInt(0, 100000000));
        System.out.println("Traženi broj je: " + trazeniBroj);

        for(int i=0; i<16; i++){
            Integer pocetak = i* brojevi.size() / 16;
            Integer kraj = (i+1)* brojevi.size() / 16;
            PretragaNiti nit = new PretragaNiti(pocetak, kraj);
            niti.add(nit);
            nit.start();
        }
        for (Thread nit : niti) {
            try {
                nit.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (pronadjen) {
            System.out.println("Traženi broj je pronađen!");
        } else {
            System.out.println("Traženi broj nije pronađen.");
        }


    }

}
