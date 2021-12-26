import java.util.Observable;
import java.util.Observer;

public class VueTexte implements Observer {

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("cpt=" + (int) o);
    }
}
