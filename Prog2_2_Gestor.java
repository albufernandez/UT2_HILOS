package Unidad2;

public class Prog2_2_Gestor {
	
	//iniciamos contador que da prioridades
	private int contador =0;
	
	//metodo que imprime tic si contador es 0 
	public synchronized void tic() {           //no olvidar el sync
		while (contador !=0) {
			try {
				wait(); //le manda esperar si el contador NO es 0 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//si el contador es 0 entra por aqui
		System.out.println("TIC");
		contador++; //contador = 1;
		notify(); //avisa a los demás que miren si les toca
	}
	
	
	//metodo que imprime tac si el contador es 1
	//y luego pone contador a 0
	public synchronized void tac() {
		while (contador ==0) {
			try {
				wait(); //si el contador SI es 0 espera
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//si el contador NO es 0 imprime
		System.out.println("-TAC");
		contador--; //contador se pone en 0
		notify(); //avisa a los demas de que comprueben
	}
}
