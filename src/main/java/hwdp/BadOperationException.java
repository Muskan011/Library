package hwdp;

public class BadOperationException extends Exception {
    public static void badOp(String methodName, String currentStateName) {
        LibraryLogger logger = LibraryLogger.getInstance();
        logger.writeLine("BadOperationException - Can't use " + methodName + " in " + currentStateName +" state");
    }
}
