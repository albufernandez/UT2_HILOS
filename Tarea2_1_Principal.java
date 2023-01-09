package Unidad2;

//clase que contiene el main
public class Tarea2_1_Principal {
	
	//main que ejecutara el programa
	public static void main (String[]args) {
		
	//se crea el gestor
	Tarea2_1_Gestor gestor= new Tarea2_1_Gestor();
	
	//se crean el hilo barista
	Thread barista = new Tarea2_1_Barista(gestor);

	//se inicia el hilo barista
	barista.start();
	
	//se crean e inician 20 hilos que van a ser los clientes
	for (int i=0; i<20 ; i++) {
		new Tarea2_1_Cliente("Cliente numero " + i, gestor).start();
	}
	
	}
}
