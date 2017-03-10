package PhilosopherMonitoring;

public class TestPhilosophersWithMonitor {

    private static final int NUM_PHILOSOPHERS = 5;


    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

        PhilosopherMonitor monitor = new PhilosopherMonitor(NUM_PHILOSOPHERS);

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, monitor);
            new Thread(philosophers[i]).start();
        }
    }

}
