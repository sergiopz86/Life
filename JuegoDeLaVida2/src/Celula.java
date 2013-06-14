import java.awt.Color;
import java.awt.Graphics;


public class Celula {
	Estado estado;
	int fila, colum;
	
	public Celula(int fila, int colum , Estado estado){
		this.estado=estado;
		this.fila=fila;
		this.colum=colum;
	}
	
	public Estado getEstado(){return estado;}
	public void setEstado(Estado estado){ this.estado=estado;}
}
