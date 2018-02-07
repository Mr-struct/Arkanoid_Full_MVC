import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Drawing extends JPanel{
	
	private AbstractControler controler;
	Image imgFond;
	protected Drawing(int width, int height,AbstractControler controler) {

		this.controler = controler;
		this.setSize(width, height);
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		//dessine le fond 
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	
		// dessine les briques 
		g2d.setColor(Color.RED);
		for(Brique br : controler.briques) {
			
			g2d.fillRect(br.getX(), br.getY(), br.getWidth(), br.getHeight());
		}
		
		//dessine la raquette
		g2d.setColor(Color.GRAY);
		g2d.fillRect(controler.raquette.getX(), controler.raquette.getY() ,controler.raquette.getWidth() , controler.raquette.getHeight());
		
		g2d.setColor(Color.YELLOW);
		//dessine la balle 
		g2d.fillOval(controler.balle.getX(), controler.balle.getY(),10,10 );
	}
	

}
