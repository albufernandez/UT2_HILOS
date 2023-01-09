package Unidad2;

public class Prog2_2_Principal {

	
	public static void main(String[] args) {
		
		//se crea un gestor de clase gestor
		Prog2_2_Gestor gestor = new Prog2_2_Gestor();
		
		//se crean los hilos pasando el gestor
		Thread tic = new Prog2_2_TIC(gestor);
		Thread tac = new Prog2_2_TAC(gestor);
		
		tic.start();
		tac.start();

	}

}
