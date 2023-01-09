package Unidad2;
import java.util.concurrent.*;

public class Prog2_4_Gestor {
	
	//se declaran los semaforos
	private Semaphore semaforoTic;
	private Semaphore semaforoTac;
	
	//constructor del gestor pasando los semaforos
	Prog2_4_Gestor( Semaphore semaforoTic, Semaphore semaforoTac){
		this.semaforoTic = semaforoTic;
		this.semaforoTac = semaforoTac;
	}

//metodo tic acquire para que le toque a este semaforo, 
//debajo lo que hace el metodo y liberar
public void tic() {
	try {
		semaforoTic.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
		}

	System.out.println("TIC");
	semaforoTac.release();
				}


public void tac() {
	try {
		semaforoTac.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
		}

	System.out.println("-TAC");
	semaforoTic.release();
				}



}
