package Philosophers;

class Philosopher implements Runnable {
    private Fork leftFork;
    private Fork rightFork;

    private String name;
    private int state;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.state = 1;
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void eat() throws InterruptedException {
        if (!leftFork.used && !rightFork.used) {
            leftFork.take();
            rightFork.take();

            Logger.message(name + " : Eating");

            leftFork.laid();
            rightFork.laid();
        }
        Logger.delay(1000);
    }



    public void think() throws InterruptedException{
        this.state = 1;
        Logger.message(name + " : Thinking");
        Logger.delay(1000);

    }

    @Override
    public void run() {
        while (true) {
            try {
                eat();
                think();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}