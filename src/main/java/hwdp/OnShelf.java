package hwdp;

public class OnShelf implements LBState {
    private static OnShelf onShelf = null;
    LibraryLogger logger = LibraryLogger.getInstance();
    private OnShelf() {}
    public static OnShelf getInstance() {
        if (onShelf == null) {
            onShelf = new OnShelf();
        }
        return onShelf;
    }
    public String toString() {
        return "OnShelf";
    }
    @Override
    public void shelf(LibraryBook libBk) {
        String methodName = "shelf";
        String currentStateName = this.toString();
        BadOperationException.badOp(methodName, currentStateName);
    }
    @Override
    public void issue(LibraryBook libBk) {
        Borrowed borrowedInstance = Borrowed.getInstance();
        logger.writeLine("Leaving State OnShelf for State Borrowed");
        libBk.setPresentState(borrowedInstance);
        libBk.notifyObservers(libBk);
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