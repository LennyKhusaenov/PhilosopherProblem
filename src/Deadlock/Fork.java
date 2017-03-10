package Deadlock;

public class Fork {
    private boolean used = false;
    private String name;

    public Fork(String name) {
        this.name = name;
    }

    public synchronized void take() throws InterruptedException {
        while (used) {
            wait();
        }
        used = true;
        System.out.println("Fork " + name + " taken");
    }

    public synchronized void laid() {
        used = false;
        notifyAll();
        System.out.println("Fork " + name + " laided");

    }
}
