package Unidad2;

public class Prog2_5_Principal {

	public static void main(String[] args) {
		
		Prog2_5_Gestor gestor = new Prog2_5_Gestor();

		
		Thread pin = new Prog2_5_PIN(gestor);
		Thread pan = new Prog2_5_PAN(gestor);
		Thread pun = new Prog2_5_PUN(gestor);
		
		pin.start();
		pan.start();
		pun.start();
		
	}

}
