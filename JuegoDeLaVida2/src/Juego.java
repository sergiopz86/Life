import java.util.Random;


public class Juego {
	Celula arrayCel[][]= new Celula[20][40];
	Random r = new Random();
	
	public Juego(){
		for(int i=0; i<20; i++){
			for(int j=0; j<40; j++){
				arrayCel[i][j]= new Celula(i,j,Estado.MUERTA);
			}
		}	
	}

	public void recorrerArray(){
		int contadorV;
		for(int i=0; i<arrayCel.length; i++){
			for(int j=0; j<arrayCel[i].length; j++){		
					contadorV=contarVecinos(i,j);
				if(contadorV==3 && arrayCel[i][j].getEstado()==Estado.MUERTA)
					arrayCel[i][j].setEstado(Estado.EMBRION);
				else if((contadorV<2 || contadorV>3) && arrayCel[i][j].getEstado()==Estado.VIVA)
					arrayCel[i][j].setEstado(Estado.MORIBUNDA);
			}
		}
	}
	public int contarVecinos(int i, int j){
		int contadorV=0;
		for(int fila=i-1; fila<=i+1; fila++){
			for(int colum=j-1; colum<=j+1; colum++){
				try {
					if((arrayCel[fila][colum].getEstado()==Estado.VIVA
							|| arrayCel[fila][colum].getEstado()==Estado.MORIBUNDA)
							&& (fila!=i || colum!=j))
						contadorV++;	
				} catch(IndexOutOfBoundsException e){}						
			}
		}
		return contadorV;
	}
	public void recorrerMatarYnacer(){
		for(int h=0; h<arrayCel.length; h++){
			for(int k=0; k<arrayCel[h].length; k++){		
				if(arrayCel[h][k].getEstado()==Estado.MORIBUNDA)
					arrayCel[h][k].setEstado(Estado.MUERTA);
				else if(arrayCel[h][k].getEstado()==Estado.EMBRION)
					arrayCel[h][k].setEstado(Estado.VIVA);
			}
		}
	}
	
	public void borrar(){
			for(int h=0; h<arrayCel.length; h++){
				for(int k=0; k<arrayCel[h].length; k++){		
						arrayCel[h][k].setEstado(Estado.MUERTA);
				}
			}
	}
	
	public void aleatorias(){
		int aux;
		for(int h=0; h<arrayCel.length; h++){
			for(int k=0; k<arrayCel[h].length; k++){
				aux = r.nextInt(2);
				if(aux == 1)
					arrayCel[h][k].setEstado(Estado.VIVA);
				else
					arrayCel[h][k].setEstado(Estado.MUERTA);
			}
		}
	}
	public Celula getCelula(int fila, int col){
		return arrayCel[fila][col];
	}
	
	public void setCelulaVivaOmuerta(int f, int c){
		if(arrayCel[f][c].getEstado()==Estado.MUERTA || arrayCel[f][c].getEstado()==Estado.MORIBUNDA)
			arrayCel[f][c].setEstado(Estado.VIVA);
		else
			arrayCel[f][c].setEstado(Estado.MUERTA);
	}

}
