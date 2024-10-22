//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static boolean DaLiJeProst(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        int n=0;
        do {
            System.out.print("Unesite cijeli broj n: ");
            n = scanner.nextInt();
            if(n>500) System.out.print("Uneseni broj je prevelik.");
        }while(n>=500);

        for(int i=2; i<=2*n; i++){
            if(DaLiJeProst(i))  System.out.print(i+" ");
        }
    }


}