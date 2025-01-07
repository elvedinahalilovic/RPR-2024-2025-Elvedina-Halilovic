public class SabiranjeNit extends Thread{

    Integer pocetak, kraj, suma;
    public SabiranjeNit(Integer poc, Integer kraj) {
        this.pocetak = poc;
        this.kraj = kraj;
        suma = 0;
    }
    public Integer getSuma(){
        return suma;
    }
    public void run ()
    {
        System.out.println("Nit [" + pocetak + "," + kraj + ") započinje s radom");
        for (int i = pocetak; i < kraj; i++)
            suma += Main.brojevi.get(i);
        System.out.println("Nit [" + pocetak + "," + kraj + ") završava s radom");
    }

}
