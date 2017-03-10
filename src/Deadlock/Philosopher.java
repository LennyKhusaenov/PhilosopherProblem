package Deadlock;

import java.util.Random;

/**
 * Created by Ленизка on 10.03.2017.
 */
public class Philosopher implements Runnable {

    private final String name;
    private Fork leftFork;
    private Fork rightFork;
    private Random rand = new Random();

    public Philosopher(String name,Fork leftFork, Fork right) {
        this.leftFork = leftFork;
        this.rightFork = right;
        this.name = name;
    }


    public void run() {
        try {
            while (!Thread.interrupted()) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            System.err.println("Deadlock on "+ name +"!");
        }
    }

    public void eat() throws InterruptedException {
        leftFork.take();
        rightFork.take();
        System.out.println("Philosoph " + name + " eating");
        rightFork.laid();
        leftFork.laid();


    }

    public void think() throws InterruptedException {
        System.out.println("Philosoph " + name + " thinking");
    }

}