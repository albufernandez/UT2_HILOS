package Unidad2;

public class Prog2_6_PUN extends Thread {

	private Prog2_6_Gestor gestor;
	
	public Prog2_6_PUN ( Prog2_6_Gestor gestor) {
		this.gestor = gestor;
	}
	
	
	public void run() {
		for (int i =0; i<3;i++) {
			gestor.pun();
		}
	}
}
