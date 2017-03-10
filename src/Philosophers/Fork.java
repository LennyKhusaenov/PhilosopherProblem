package Philosophers;

class Fork{

    public boolean used;
    private String name;

    public Fork(String _name){
        this.name = _name;
    }

    public synchronized void take() {
        Logger.message("Used : " + name);
        this.used = true;
    }
    public synchronized void laid() {
        Logger.message("Laid : " + name);
        this.used = false ;
    }
}