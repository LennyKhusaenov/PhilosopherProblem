package Philosophers;

class Logger {

    public static void message(String msg) {
        System.out.println(msg);
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}