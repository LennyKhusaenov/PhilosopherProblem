package Philosophers;

/**
 * Created by Ленизка on 10.03.2017.
 */
public class TestDinner {

    private static final int NUMBER_OF_PHILOSOPHERS = 5;

    public static void main(String[] args) {


        Fork[] forks = new Fork[NUMBER_OF_PHILOSOPHERS];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork("Fork: " + i);
        }
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

        philosophers[0] = new Philosopher("Aristotel: 0 - ", forks[0], forks[1]);
        philosophers[1] = new Philosopher("Plato: 1 - ", forks[1], forks[2]);
        philosophers[2] = new Philosopher("Dekart: 2 - ", forks[2], forks[3]);
        philosophers[3] = new Philosopher("Nietzsche: 3 - ", forks[3], forks[4]);
        philosophers[4] = new Philosopher("Marx: 4 - ", forks[0], forks[4]);

        for (int i = 0; i < philosophers.length; i++) {
            Logger.message("Thred " + i);
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}

