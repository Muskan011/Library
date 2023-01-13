package hwdp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Student_muskumar_Test {
    @BeforeEach
    public void resetLog() {
        LibraryLogger.getInstance().clearWriteLog();
    }
    @Test
    void myStudentTest(){
        LibraryBook book1 = new LibraryBook("Divergent");
        LibraryBook book2 = new LibraryBook("Insurgent");
        LibraryBook book3 = new LibraryBook("Mindset");
        book1.returnIt();
        book2.issue();
        book2.issue();
        book3.issue();
        book2.returnIt();
        book3.shelf();
        book3.returnIt();
        book1.extend();
        assertArrayEquals(
                new String [] {
                        "BadOperationException - Can't use returnIt in OnShelf state",
                        "Leaving State OnShelf for State Borrowed",
                        "BadOperationException - Can't use issue in Borrowed state",
                        "Leaving State OnShelf for State Borrowed",
                        "Leaving State Borrowed for State GotBack",
                        "BadOperationException - Can't use shelf in Borrowed state",
                        "Leaving State Borrowed for State GotBack",
                        "BadOperationException - Can't use extend in OnShelf state"
                },
            LibraryLogger.getInstance().getWrittenLines()
        );
    }  
}