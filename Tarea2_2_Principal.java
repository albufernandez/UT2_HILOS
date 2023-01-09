package Unidad2;

// Clase que contiene el main
public class Tarea2_2_Principal {

	// Main que ejecuta el programa
	public static void main(String[] args) {

		// Creamos el gestor
		Tarea2_2_Gestor gestor = new Tarea2_2_Gestor();

		// Bucle que simulara 30 dias
		for (int d = 1; d < 31; d++) {

			// Creamos 5 gallinas con 5 hilos distintos
			for (int i = 1; i < 6; i++) {
				Tarea2_2_Gallina gallina = new Tarea2_2_Gallina("Gallina numero " + i, gestor);
				gallina.start();
				
			}
			// Creamos el hilo granjero y se inicia
			Thread granjero = new Tarea2_2_Granjero(gestor);
			granjero.start();
		}
	}

}
