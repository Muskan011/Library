package hwdp;

public class DestObserver implements Observer {
    private String name;
    private LibraryLogger logger = LibraryLogger.getInstance();
    public DestObserver(String n) {
        this.name = n;
    }
    @Override
    public void update(Subject o) {
        logger.writeLine(name + " OBSERVED " + o.toString() + " REACHING STATE: " + o.getStateName());
    }
    @Override
    public String toString() { return name;}
}



