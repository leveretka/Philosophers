import java.util.ArrayList;
import java.util.List;

/**
 * Created by margarita on 09.09.15.
 */
public class Main {

    public static void main (String[] args) {

        List<Fork> forks = new ArrayList<>();
        List<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            forks.add(new Fork());
        }

        for (int i = 0; i < 5; ++i) {
            philosophers.add(new Philosopher(forks.get(i), forks.get((i + 1) % 5)));
        }

        for (Philosopher philosopher: philosophers) {
            philosopher.start();
        }

    }
}
