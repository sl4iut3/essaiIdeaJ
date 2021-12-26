import java.util.Observable;

public class Compteur extends Observable implements Runnable {
    private int cpt;

    public Compteur() {
        this.cpt = 0;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            this.cpt++;
            this.setChanged();
            this.notifyObservers(this.cpt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hi");
        Compteur c=new Compteur();
        VueTexte vt=new VueTexte();
        c.addObserver(vt);
        VueGraphique dialog = new VueGraphique();
        c.addObserver(dialog);
        dialog.pack();
        dialog.setVisible(true);
    }
}
