
public class Main {

	public static void main(String[] args) {
	
		//Instanciation de notre modèle

	    AbstractModel model = new MyModel();

	    //Création du contrôleur

	    AbstractControler controler = new Mycontroler(model);

	    //Création de notre fenêtre avec le contrôleur en paramètre

	    Vue vue = new Vue(600,800,controler);

	    //Ajout de la fenêtre comme observer de notre modèle

	}

}
