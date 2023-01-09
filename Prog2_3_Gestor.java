package Unidad2;

public class Prog2_3_Gestor {
	
	//iniciamos la variable que va a gestionar por donde entra
	private int pan = 0;
	
	public synchronized void hacer() {
		
		while (pan == 2) {
			try { 
				wait();//si pan SI es 2 ESPERA
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} //fuera del while
		
		//si pan NO es 2 CREA barra de pan
		System.out.println("Se ha creado una barra de pan");
		pan++;
		notify(); //avisa que revisen
	}
	
	public synchronized void vender() {
		while (pan == 0) {
			try {
				wait(); //si pan SI es 0 ESPERA
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//si pan NO es 0 CREA barra de pan
		System.out.println("Se ha vendido una barra de pan");
		pan--;
		notify(); //avisa que revisen
	}

}
