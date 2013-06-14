import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Ventana extends JFrame implements ActionListener{
	
	JToolBar tool = new JToolBar();
	JPanel panel = new JPanel();
	JButton empezar = new JButton("Empezar");
	JButton aleatorias = new JButton("Aleatorias");
	JButton borrar = new JButton("Borrar");
	BorderLayout border = new BorderLayout();
	Grafica grafica = new Grafica();
	Thread t = new Thread();
	JOptionPane dialogo = new JOptionPane();
	
	public Ventana(){
		setTitle("El Juego de la Vida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(border);
		construirTool();
		add(grafica, BorderLayout.CENTER);
		setResizable(false);
		pack();
		setVisible(true);
		t = null;
		dialogo.showMessageDialog(this,"Pulsa casillas para crear células, y después pulsa empezar"); 
	}
	public static void main(String [] args){
		Ventana ventana = new Ventana();
	}
	public void construirTool(){
		add(tool, BorderLayout.NORTH);
		tool.add(borrar);
		tool.add(aleatorias);
		tool.add(empezar);
		tool.setFloatable(false);
		borrar.addActionListener(this);
		aleatorias.addActionListener(this);
		empezar.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==empezar){
			if(empezar.getText()=="Empezar"){
				empezar.setText("Parar");
				if (t == null){
					t = new Thread(new Runnable() {
						public void run() {
							Thread aux = Thread.currentThread();
							while (t == aux) {
								grafica.getJuego().recorrerArray();
								grafica.getJuego().recorrerMatarYnacer();
								repaint();
								try { Thread.sleep(200); } catch (InterruptedException e1) {}
							}
						}
					});
					t.start();
				}
			}
			else{
				empezar.setText("Empezar");
				t = null;
			}
		}
		else if(e.getSource()==borrar){
			grafica.getJuego().borrar();
			t = null;
			empezar.setText("Empezar");
			repaint();
		}
		else if(e.getSource()==aleatorias){
			grafica.getJuego().aleatorias();
			repaint();
		}
	}
}