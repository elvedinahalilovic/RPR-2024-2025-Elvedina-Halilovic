public class SortiranjeNiti extends Thread{
    private final int id;

    public SortiranjeNiti(int id) {
        this.id = id;
    }

    public void run() {
        while (!Main.sortirano.get()) {
            synchronized (Main.brojevi) {
                boolean promjena = false;
                for (int i = 0; i < Main.brojevi.size() - 1; i++) {
                    if (Main.brojevi.get(i) > Main.brojevi.get(i + 1)) {

                        int temp = Main.brojevi.get(i);
                        Main.brojevi.set(i, Main.brojevi.get(i + 1));
                        Main.brojevi.set(i + 1, temp);
                        promjena = true;
                    }
                }


                if (!promjena) {
                    Main.sortirano.set(true);
                    System.out.println("Nit " + id + " je završila sortiranje.");
                }
            }
        }
    }

}
