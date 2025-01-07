import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static List<Integer> brojevi = new ArrayList<Integer>();
    public static AtomicBoolean sortirano = new AtomicBoolean(false);
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            brojevi.add(random.nextInt(1000)); // Brojevi od 0 do 999
        }

        System.out.println("Nesortirana kolekcija: " + brojevi);

        List<Thread> niti = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            niti.add(new SortiranjeNiti(i));
            niti.get(i).start();
        }
        try {
            for (Thread nit : niti)
                nit.join();
            System.out.print(brojevi);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Sortirana kolekcija: " + brojevi);
    }
}

