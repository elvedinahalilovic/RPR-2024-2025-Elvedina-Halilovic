import controller.PredmetController;
import model.Predmet;
import view.PredmetView;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Predmet predmet = new Predmet("Diskretna", 5.0);
        System.out.println(predmet.getECTS());

        PredmetView view = new PredmetView();
        PredmetController predmetController = new PredmetController(null,view);
        predmetController.dajOsobeIzTxtDatoteke("src/data/predmeti.txt");
        System.out.println("View ispisuje: " + view.getPoruka());


    }
}
