package PhilosopherMonitoring;


public class PhilosopherMonitor {

    private enum State {THINKING, HUNGRY, EATING}


    private State[] philosopherState;


    public PhilosopherMonitor(int numPhilosophers) {
        philosopherState = new State[numPhilosophers];
        for (int i = 0; i < philosopherState.length; i++) {
            philosopherState[i] = State.THINKING;
        }
    }


    public synchronized void pickUpForks(int philosopherId) throws InterruptedException {

        philosopherState[philosopherId] = State.HUNGRY;
        System.out.println("Philosopher " + philosopherId + " is hungry.\n");
        System.out.flush();


        while (someNeighborIsEating(philosopherId)) {
            wait();
        }


        philosopherState[philosopherId] = State.EATING;
        System.out.println("Philosopher " + philosopherId + " is eating.\n");
        System.out.flush();
    }


    private boolean someNeighborIsEating(int philosopherId) {

        if (philosopherState[(philosopherId + 1) % philosopherState.length] == State.EATING) {
            return true;
        }


        if (philosopherState[(philosopherId + philosopherState.length - 1) % philosopherState.length] == State.EATING) {
            return true;
        }


        return false;
    }


    public synchronized void putDownForks(int philosopherId) {
        philosopherState[philosopherId] = State.THINKING;
        notifyAll();
    }

}
