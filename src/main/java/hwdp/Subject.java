package hwdp;

public interface Subject {
	public void attach(Observer obs);
    public void detach(Observer obs);
    public void notifyObservers(Subject s);
    public String getStateName();
}
