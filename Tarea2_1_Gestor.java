package Unidad2;

// Clase gestor que contiene los metodos que se ejecutaran en los run de las clases barista y cliente
public class Tarea2_1_Gestor {

	// inciamos la variable que va a hacer como contador
	private int cafeSolo = 0;
	private int cafeLeche = 0;

	// metodo que hace café e informa del tiempo que ha tardado en hacerlos
	public synchronized void hacer() {

		// si ambos cafes no estan a 0
		while (cafeSolo != 0 && cafeLeche != 0) {

			try {
				wait(); // espera
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Si algun cafe esta a cero
		try {
			// calculamos el tiempo que esta haciendo un cafe
			long aleatorio = (long) (Math.random() * 300 + 1);
			Thread.sleep(aleatorio);

			System.out.println("El barista tarda en hacer café: " + aleatorio);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// llama al metodo que hacer cafe
		haceCafe();

		// llama al metodo que iprime los cafes que hay y notifica para que se
		// sincronicen
		imprimeNotifica();
	}

	// metodo que toma un café aleatoriamente de los que hay hechos e informa del
	// tiempo
	// que ha tardado en tomarselo
	public synchronized void tomar(String nombre) {

		// si alguno de los cafes estan a 0
		while (cafeSolo == 0 || cafeLeche == 0) {

			try {
				wait(); // espera
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// si ningun cafe esta a 0
		try {
			// calculamos el tiempo que esta tomando un cafe
			long aleatorio = (long) (Math.random() * 200 + 1);
			Thread.sleep(aleatorio);

			System.out.println(nombre + " tarda en tomar " + aleatorio);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// llama al metodo tomar cafe que toma uno de los dos de forma aleatoria
		tomaCafe();

		// imprime que cafes hay y notifica para que se sincronice
		imprimeNotifica();

		System.out.println();

	}

	// metodo que comprueba que cafe face falta y lo hace
	private void haceCafe() {

		if (cafeSolo == 0) {
			cafeSolo++;
			System.out.println("El barista hace café solo");
		}
		if (cafeLeche == 0) {
			cafeLeche++;
			System.out.println("El barista hace café con leche");
		}

	}

	// metodo que imprime los cafes que hay y notifica para que se sincronicen
	private void imprimeNotifica() {
		System.out.println("Número de cafés solos: " + cafeSolo);
		System.out.println("Número de cafés con leche: " + cafeLeche);

		notifyAll();
	}

	// metodo que hace que un cliente tome cafe de forma aleatoria
	private void tomaCafe() {

		System.out.println("El cliente empieza a tomar café");

		// creamos un numero aleatorio entre 1 y 10 para hacer de forma aleatoria que
		// tome el solo o con leche
		int aleatorio = (int) (Math.random() * 10 + 1);

		if (aleatorio % 2 != 0) {
			System.out.println("El cliente se ha tomado un café solo");
			cafeSolo--;
		}
		if (aleatorio % 2 == 0) {
			System.out.println("El cliente se ha tomado un café con leche");
			cafeLeche--;
		}

	}

}
