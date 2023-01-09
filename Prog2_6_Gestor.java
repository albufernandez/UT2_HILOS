package Unidad2;

import java.util.concurrent.Semaphore;

public class Prog2_6_Gestor {
	
	private Semaphore semPin, semPan, semPun;
	
	public Prog2_6_Gestor(Semaphore semPin,Semaphore semPan, Semaphore semPun ) {
		this.semPin = semPin;
		this.semPan = semPan;
		this.semPun = semPun;
		
	}
	
	
	public void pin() {
		try {
			semPin.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		
		System.out.println("PIN");
		semPan.release();

	}
	
	public void pan() {
		
		try {
			semPan.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		
		System.out.println("-PAN");
		semPun.release();
		
		
	}
	
	public void pun() {
		
		try {
			semPun.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		
		System.out.println("--PUN");
		semPin.release();
		
		
	}
	
	

}
