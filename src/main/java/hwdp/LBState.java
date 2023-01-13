package hwdp;

public interface LBState{
    public void shelf(LibraryBook libBk);
    public void issue(LibraryBook libBk);
    public void extend(LibraryBook libBk);
    public void returnIt(LibraryBook libBk);
}