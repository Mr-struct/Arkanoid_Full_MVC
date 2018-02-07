import java.util.ArrayList;

public abstract class AbstractModel implements Observable {
	
	//notre liste d'observateur du modele
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();  
}
