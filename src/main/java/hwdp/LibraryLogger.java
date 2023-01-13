package hwdp;
import java.util.ArrayList;

public class LibraryLogger {
    private static LibraryLogger logger;
    ArrayList<String> libLogger = new ArrayList<String>();
    public void writeLine(String line) {
        libLogger.add(line);
        System.out.println("LibraryLogger: " + line);
    }
    public String[] getWrittenLines() {
        String linesWritten[] = new String[libLogger.size()];
        for(int i = 0 ; i < libLogger.size() ; i++){
            linesWritten[i] = libLogger.get(i);
        }
        return linesWritten;
    }
    public void clearWriteLog() {
        libLogger.clear();
    }
    public static LibraryLogger getInstance() {
        if (logger == null){
            logger = new LibraryLogger();
            ExpensiveComputeToy.performExpensiveLogSetup();
        }
        return logger;
    }
}
