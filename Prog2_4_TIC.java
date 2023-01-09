package Unidad2;

public class Prog2_4_TIC extends Thread{
	
	//se declara el objeto gestor
private Prog2_4_Gestor gestor;

//constructor pasando el gestor
	public Prog2_4_TIC(Prog2_4_Gestor gestor) {
		this.gestor = gestor;
	}
	
	//lo que hace el hilo (imprimr 20 veces el metodo tic de la clase gestor)
	public void run() {
		for (int i =0; i<20; i++) {
			gestor.tic();
		}
	}
	

}
