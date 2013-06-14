import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class Grafica extends JPanel implements MouseListener {

	Juego juego; 
	
	public Grafica(){
		setPreferredSize(new Dimension(800,400));
		addMouseListener(this);
		setVisible(true);
		juego = new Juego();
	}
	
	public void paintComponent(Graphics g){

		for(int i=0; i<20; i++){
			for(int j=0; j<40; j++){
				if(juego.getCelula(i,j).getEstado()==Estado.VIVA)
					g.setColor(Color.GREEN);		
				else
					g.setColor(Color.BLACK);
				g.fillRect(j*20, i*20, 20, 20);	
				
				g.setColor(Color.DARK_GRAY);
				g.fillRect(j*20, i*20, getWidth(), 1);
				g.fillRect(j*20, i*20, 1, getHeight());
			}
		}	
	}
	public Juego getJuego(){ return juego;}
	
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent e) {
		juego.setCelulaVivaOmuerta(Math.abs(e.getY()/20), Math.abs(e.getX()/20));
		repaint();
	}

	public void mouseReleased(MouseEvent arg0) {}
	
	
}
