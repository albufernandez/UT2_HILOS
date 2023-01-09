package Unidad2;

public class Prog2_2_TIC extends Thread{ 
	
//se declara gestor de la clase gestor
private Prog2_2_Gestor gestor;
	
	//se inicia el constructor pasandole por parametro el gestor
	public Prog2_2_TIC(Prog2_2_Gestor gestor) {
		this.gestor = gestor;
	}
	
	//hace 20 veces el metodo tic de la clase gestor
	public void run () {
		for (int i =0; i<200; i++) {
			gestor.tic();
		}
	}

}
