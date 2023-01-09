package Unidad2;

public class Prog2_5_PAN extends Thread{
	
private Prog2_5_Gestor gestor;
	
	public Prog2_5_PAN ( Prog2_5_Gestor gestor) {
		this.gestor = gestor;
	}
	
	public void run() {
		for (int i =0; i<5 ; i++) {
			gestor.pan();
		}
	}

}
