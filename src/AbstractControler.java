import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class AbstractControler  {
	
	//attribus
	protected AbstractModel absModel;
	protected ArrayList<Brique> briques = new ArrayList<Brique>(0); 
	protected Raquette raquette;
	protected Balle balle;
	//constructeur 
	
	public AbstractControler(AbstractModel absModel){
	    this.absModel = absModel;
	}
	
	
	//Méthode de contrôle de calcule ...
	  abstract void control();

	// methode qui fait bouger la raquette 
	public void moveRaquette(MouseEvent e) {
		raquette.setX(e.getX() - raquette.getWidth()/2);
	}
}
