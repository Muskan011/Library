package hwdp;
import java.util.HashMap;

public class SourceObserver implements Observer {
	private String name;
	private LibraryLogger logger = LibraryLogger.getInstance();
	private HashMap<Subject, String> subjectToPastStateName = new HashMap<Subject,String>();
	public SourceObserver(String n) {
		this.name = n;
	}
	@Override
	public void update(Subject o){
		if(subjectToPastStateName.containsKey(o)){
			logger.writeLine(name + " OBSERVED " + o.toString() + " LEAVING STATE: " + subjectToPastStateName.get(o));
		}
		else{
			logger.writeLine(name + " OBSERVED " + o.toString() + " LEAVING STATE: " + "UNOBSERVED");
		}
		subjectToPastStateName.put(o,o.getStateName());
	}
	@Override
	public String toString() {
		return name;
	}
}
