package Deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DeadlockingTest {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newFixedThreadPool(NUM_PHILOSOPHERS);
        Fork[] forks = new Fork[NUM_PHILOSOPHERS];
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Fork("Fork: " + i);
        }
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

        philosophers[0] = new Philosopher("Aristotel: 0 - ", forks[0], forks[1]);
        philosophers[1] = new Philosopher("Plato: 1 - ", forks[1], forks[2]);
        philosophers[2] = new Philosopher("Dekart: 2 - ", forks[2], forks[3]);
        philosophers[3] = new Philosopher("Nietzsche: 3 - ", forks[3], forks[4]);
        philosophers[4] = new Philosopher("Marx: 4 - ", forks[4], forks[0]);
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            exec.execute(philosophers[i]);
        }
        exec.shutdownNow();

    }
}
