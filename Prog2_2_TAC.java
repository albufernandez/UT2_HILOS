package Unidad2;

public class Prog2_2_TAC extends Thread{ 
	
	//se declara objeto de la clase gestor
	private Prog2_2_Gestor gestor;
	
	//se inicializa el constructor pasando el gestor
	public Prog2_2_TAC(Prog2_2_Gestor gestor) {
		this.gestor = gestor;
	}
	
	//el metodo hace 20 veces el metodo tac de clase gestor
	public void run () {
		for (int i =0; i<200; i++) {
			gestor.tac();
		}
	}

}
