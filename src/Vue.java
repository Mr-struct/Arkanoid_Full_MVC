import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Vue extends JFrame implements Observer{

	
	//L'instance de notre objet contrôleur
	private AbstractControler controler;
	
	//l'instance de Jpanel ou on dessine
	Drawing draw;
	
	public Vue(int width, int height,AbstractControler controler) {
		
		super("Arkanoid");
		
		this.controler = controler;
		
		this.setSize(width,height);
		
		
		
		draw = new Drawing(width, height,controler);
		
		this.getContentPane().add(draw, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		setVisible(true);
		
		initGame();
		
		redraw();
	}
	
	// initialise le jeu 
	public void initGame() {
		
		//on initialise nos objets
		
		controler.raquette = new Raquette(400,600,100,20,Color.CYAN);// la raquette
		
		controler.balle = new Balle (controler.raquette.getX()+50 ,controler.raquette.getY()-10,5,5); // la balle
		
		// le mure de birque
		
		for(int i = 0; i < 10; i++) {
			
			for(int j= 0; j < 3;j++) {
				
				controler.briques.add(new Brique( (i*50)+150, (j*100)+30 ,40 ,20 ) ); // les brique
			}
		}
		
		// on rajoute des listner
		this.addMouseMotionListener(new RaquetteListener());
	}
	
	// on réactualise l'affichage toute les 20miliseconde
	public void redraw() {
		
		Timer timerAffichage = new Timer();
		timerAffichage.schedule(new TimerTask(){
			public void run(){
				draw.repaint();
			}
		}, 0, 20);
	}
	
	// on prévien le modele qu'on a changer d'état
	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		
	}
	
	//ici on implement les listener
	class RaquetteListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			controler.moveRaquette(e);
		}
		
	}

}
