import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static Double Plus(Double el1, Double el2){
        return el1 + el2;
    }
    public static Double Podijeljeno(Double el1, Double el2) throws Exception{
        if(el2 == 0) {
            throw new Exception("Nije dozvoljeno dijeljenje s nulom!");}

        Double zaokruzeniBroj = (Math.round(el1/el2 * 100)) / 100.0;
        return zaokruzeniBroj;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> brojevi = new ArrayList<>();
        String operacija;
        System.out.print("Unesite operaciju ('plus' za sabiranje, 'podijeljeno' za dijeljenje): ");
        operacija = scanner.nextLine();
        Double n;
        System.out.print("Unesite brojeve: ");
        do {
            n = scanner.nextDouble();
            if(n!=-400){
                brojevi.add(n);
            }
        }while(n!=-400);
        Double rez = 0.0;
try {
    rez = brojevi.get(0);
    if (operacija.equals("plus")) {
        for (int i = 1; i < brojevi.size(); i++) {
            rez = Plus(rez, brojevi.get(i));
        }
    } else {
        for (int i = 1; i < brojevi.size(); i++) {
            rez = Podijeljeno(rez, brojevi.get(i));
        }
    }
    System.out.println("Konacni rezultat je:"+ rez);

}catch (Exception e){System.out.println(e.getMessage());}


    }


}