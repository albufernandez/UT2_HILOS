package Unidad2;

// Clase cliente que ejecutara en el main el metodo tomar de la clase gestor 
public class Tarea2_1_Cliente extends Thread {
	
	//declaramos la clase gestor y variables
	private Tarea2_1_Gestor gestor ;
	private String nombre;
	
	//Se inicia el constructor pasando el gestor
	public Tarea2_1_Cliente (String nombre, Tarea2_1_Gestor gestor) {
		this.gestor = gestor;
		this.nombre = nombre;
	}
		
	//metodo que llama al metodo tomar de la clase gestor 20 veces
	public void run() {
			gestor.tomar(nombre);
	
	}
}
