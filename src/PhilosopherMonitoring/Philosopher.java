package PhilosopherMonitoring;

import java.util.Random;


public class Philosopher implements Runnable {

    private Random numGenerator = new Random();


    private int id;


    private PhilosopherMonitor monitor;


    public Philosopher(int id, PhilosopherMonitor monitor) {
        this.id = id;
        this.monitor = monitor;
    }


    public void run() {
        try {
            while (true) {
                think();
                monitor.pickUpForks(id);
                eat();
                monitor.putDownForks(id);
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + id + " was interrupted.");
        }
    }


    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        System.out.flush();
        Thread.sleep(numGenerator.nextInt(10));
    }


    private void eat() throws InterruptedException {
        Thread.sleep(numGenerator.nextInt(10));
    }


}