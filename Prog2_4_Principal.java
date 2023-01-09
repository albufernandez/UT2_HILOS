package Unidad2;

import java.util.concurrent.Semaphore;

public class Prog2_4_Principal {
	
	public static void main(String[] args) {
		
		//de claramos los objetos de tipo semaforo con su prioridad
		 Semaphore semaforoTic = new Semaphore(1);
		 Semaphore semaforoTac = new Semaphore(0);
		 
		 //creamos el gestor pasando los objetos semaforo
		 Prog2_4_Gestor gestor = new Prog2_4_Gestor(semaforoTic,semaforoTac);
		 
		 
		 //creamos los objetos Hilo pasano el gestor y los iniciamos
		 Thread tic = new Prog2_4_TIC(gestor);
		 Thread tac = new Prog2_4_TAC(gestor);
		 
		 tic.start();
		 tac.start();
	}

}
