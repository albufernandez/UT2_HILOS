package Unidad2;

// Clase granjero que tendra un run
public class Tarea2_2_Granjero extends Thread {

	// Declaramos la clase gestor
	private Tarea2_2_Gestor gestor;

	// Se inicia el constructor pasando el gestor
	public Tarea2_2_Granjero(Tarea2_2_Gestor gestor) {
		this.gestor = gestor;
	}

	// Metodo que llama al metodo pasaGranjero
	public void run() {
		gestor.pasaGranjero();
	}

}
