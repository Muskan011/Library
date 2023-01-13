package hwdp;

import java.util.ArrayList;

public class LibraryBook implements Subject {
    private String name;
    private LBState presentState;
    LibraryLogger logger = LibraryLogger.getInstance();
    private ArrayList<Observer> arr_observers = new ArrayList<Observer>();
    public LibraryBook(String name) {
        this.name = name;
        this.presentState = this.getState();
    }
    public void setPresentState(LBState presentState) {
        this.presentState = presentState;
    }
    public LBState getState() {
        if(this.presentState == null){
            this.presentState = OnShelf.getInstance();
        }
        return this.presentState;
    }
    public void shelf() { presentState.shelf(this);}
    public void issue() { presentState.issue(this);}
    public void extend() { presentState.extend(this);}
    public void returnIt() { presentState.returnIt(this);}
    @Override
    public String toString() {
        return name;
    }
    @Override
    public void attach(Observer obs){
        if(arr_observers.contains(obs)){
            logger.writeLine(obs.toString() + " is already watching " + this.toString());
        }
        else{
            arr_observers.add(obs);
            logger.writeLine(obs.toString() + " is now watching " + this.toString());
        }
    }
    @Override
    public void detach(Observer obs){
        if(arr_observers.contains(obs)){
            arr_observers.remove(obs);
            logger.writeLine(obs.toString() + " is no longer watching " + this.toString());
        }
    }
    @Override
    public void notifyObservers(Subject s){
        for(Observer observer:arr_observers){
            observer.update(this);
        }
    }
    @Override
    public String getStateName(){
        return presentState.toString();
    }
}