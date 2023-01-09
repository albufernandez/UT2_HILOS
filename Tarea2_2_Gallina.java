package Unidad2;

// Clase Gallina que tendra su run
public class Tarea2_2_Gallina extends Thread {

	// Declaramos la clase gestor y variables
	private Tarea2_2_Gestor gestor;
	private String numeroGallina;

	// Iniciamos el constructor con el gestor y el numero de gallina
	public Tarea2_2_Gallina(String numeroGallina, Tarea2_2_Gestor gestor) {
		this.numeroGallina = numeroGallina;
		this.gestor = gestor;

	}

	// Metodo que llama al metodo poneHuevo de la clase gestor
	public void run() {
		gestor.poneHuevo(numeroGallina);

	}

}
