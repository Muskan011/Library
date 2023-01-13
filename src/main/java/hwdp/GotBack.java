package hwdp;
public class GotBack implements LBState {
    private static GotBack gotBack = new GotBack();
    LibraryLogger logger = LibraryLogger.getInstance();
    private GotBack() {}
    public String toString(){
        return "GotBack";
    }
    public static GotBack getInstance() { return gotBack;}
    @Override
    public void shelf(LibraryBook libBk) {
        OnShelf onShelfInstance = OnShelf.getInstance();
        logger.writeLine("Leaving State GotBack for State OnShelf");
        libBk.setPresentState(onShelfInstance);
        libBk.notifyObservers(libBk);
    }
    @Override
    public void issue(LibraryBook libBk) {
        String methodName = "issue";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
    @Override
    public void extend(LibraryBook libBk) {
        String methodName = "extend";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
    @Override
    public void returnIt(LibraryBook libBk) {
        String methodName = "returnIt";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
}