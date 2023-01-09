package Unidad2;

import java.util.concurrent.Semaphore;

public class Prog2_6_Principal {
	
	
	public static void main(String[] args) {
		
		Semaphore semPin = new Semaphore (1);
		Semaphore semPan = new Semaphore (0);
		Semaphore semPun = new Semaphore (0);
		
		Prog2_6_Gestor gestor = new Prog2_6_Gestor(semPin, semPan, semPun);
		
		Thread pin = new Prog2_6_PIN(gestor);
		Thread pan = new Prog2_6_PAN(gestor);
		Thread pun = new Prog2_6_PUN(gestor);
		
		pin.start();
		pan.start();
		pun.start();
	}

}
