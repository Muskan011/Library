package hwdp;
public class Borrowed implements LBState {
    private static Borrowed borrowed = new Borrowed();
    LibraryLogger logger = LibraryLogger.getInstance();
    private Borrowed() {}
    public String toString(){
        return "Borrowed";
    }
    public static Borrowed getInstance() {
        return borrowed;
    }
    @Override
    public void shelf(LibraryBook libBk) {
        String methodName = "shelf";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
    @Override
    public void issue(LibraryBook libBk) {
        String methodName = "issue";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
    @Override
    public void extend(LibraryBook libBk) {
        Borrowed borrowedInstance = Borrowed.getInstance();
        logger.writeLine("Leaving State Borrowed for State Borrowed");
        libBk.setPresentState(borrowedInstance);
        libBk.notifyObservers(libBk);
    }
    @Override
    public void returnIt(LibraryBook libBk) {
        GotBack gotBackInstance = GotBack.getInstance();
        logger.writeLine("Leaving State Borrowed for State GotBack");
        libBk.setPresentState(gotBackInstance);
        libBk.notifyObservers(libBk);
    }
}