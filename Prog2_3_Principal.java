package Unidad2;

public class Prog2_3_Principal {

	public static void main(String[] args) {
		// Panadero y vendedor, en el mostrador solo puede haber dos barras de pan como maximo (no se fabrican mas hasta que se vendan)
		//hay que simular fabricacion y venta de 50 barras de pan
		
		
		//creamos un gestor de la clase Gestor
		Prog2_3_Gestor gestor = new Prog2_3_Gestor();
		
		
		//dos hilos pasandoles el gestor
		Thread panadero = new Prog2_3_Panadero(gestor);
		Thread vendedor= new Prog2_3_Vendedor (gestor);
		
		panadero.start();
		vendedor.start();
	}

}
