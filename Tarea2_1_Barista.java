package Unidad2;

// Clasebarista que ejecutara en el run el metodo hacer de la clase gestor
public class Tarea2_1_Barista extends Thread {
	
	//declaramos la clase gestor
	private Tarea2_1_Gestor gestor ;

	//Se inicia el constructor pasando el gestor
	public Tarea2_1_Barista (Tarea2_1_Gestor gestor) {
		this.gestor = gestor;
	}
	
	//metodo que llama al metodo hacer de la clase gestor 20 veces
	public void run() {
		for (int i=0 ; i<20 ; i++) {
			gestor.hacer();
		
		}
	}
}
