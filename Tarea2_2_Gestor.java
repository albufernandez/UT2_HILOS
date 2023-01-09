package Unidad2;

// Clase gestor en la que tenemos los metodos que se ejecutaran en los run de Granjero y Gallina
public class Tarea2_2_Gestor {

	// Inciamos variables
	private int contadorHuevos = 0, nGallina = 0, dia = 1, rotos = 0, rotosTotal = 0;

	private int[] horas = new int[5];
	private int[] horasAnterior = new int[5];

	// Metodo que nos devuelve un numero aleatorio entre 1 y 24
	private long dameHora() {
		long aleatorio = (long) (Math.random() * 24 + 1);
		return aleatorio;
	}

	// Metodo que hace que el granjero pase a por huevos
	public synchronized void pasaGranjero() {

		// Mientras que no sepamos la hora de las 5 gallinas espera
		while (nGallina != 5) {
			espera();
		}
		// Si ya sabemos la hora de las 5 gallinas llama al metodo recoger y notifica
		recoge();
		notify();
	}

	// Metodo que decide duerme el hilo en funcion del dia que sea, notifica de los
	// huevos recogidos y pone el contador de gallinas que han puesto a 0
	private void recoge() {

		// Llamamos al metodo comprobar dia que en fundion del dia que sea recoge unos
		// huevos u otros
		compruebaDia(dia);

		// Una vez se recogen los huevos se ponene a cero las variables de huevos y
		// gallinas y sumamos un dia
		contadorHuevos = 0;
		nGallina = 0;
		dia++;

	}

	// Metodo que comprueba que dia es y realiza una accion u otra en funcion de eso
	private void compruebaDia(int dia) {

		// Si es el primer dia paramos el hilo 12 (pasa a las 12)
		if (dia == 1) {
			try {
				Thread.sleep(12);

				// Imprimmos cuantos ha recogido
				System.out.println(
						"El granjero ha pasado a las 12 y ha recogido " + contadorHuevos + " huevo(s) el día " + dia);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// Si no es el primer dia paramos el hilo 24 (vuelva a pasar a las 12)
		else {
			try {
				Thread.sleep(24);

				// Calculamos los huevos recogidos y los que se rompen
				contadorHuevos = compruebaRecogidos(horas, horasAnterior);
				rotos = compruebaRotos(contadorHuevos);
				rotosTotal = rotosTotal + rotos;

				// Los imprimimos
				System.out.println("El granjero ha pasado a las 12 y ha recogido " + contadorHuevos
						+ " y se han perdido " + rotos + " huevo(s) el día " + dia);

				// Ademas si es dia 30 imprimos los huevos que se han roto en total
				if (dia == 30) {
					System.out.println("HOY ES DIA 30 Y SE HAN PERDIDO " + rotosTotal + " HUEVOS");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo que hace que la gallina ponga huevos
	public synchronized void poneHuevo(String numeroGallina) {

		// Si ya han puesto las 5 gallinas espera
		while (nGallina == 5) {
			espera();
		}

		// Si no han puesto las 5 gallinas
		try {
			// Si ninguna gallina ha puesto pasamos el valor del array a ser el valor del
			// dia anterior
			if (nGallina == 0) {
				cambiaArray(horas, horasAnterior);
			}

			// Pedimos la hora a la que la gallina pone
			int hora = (int) dameHora();
			Thread.sleep(hora);
			System.out.println(numeroGallina + " ha puesto huevo a las " + hora);

			// Al array de las horas de las gallinas le adjudicamos la hora
			horas[nGallina] = hora;

			// Si es el primer dia sumamos los huevos que se ponen antes de las 12 (los que
			// se recogeran) que luego lo imprimirá el granjero
			if (dia == 1) {
				if (hora <= 12) {
					contadorHuevos++;
				}
			}

			// Sumamos uno al contador del numero de gallinas que han puesto y notificamos
			nGallina++;
			notify();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// Metodo que contiene las instrucciones del wait()
	private void espera() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Metodo que resta al total que podrian romperse (5) los que hemos recogido
	// para saber cuantos se han roto
	private int compruebaRotos(int recogidos) {
		int rotos = 0;
		rotos = 5 - recogidos;
		return rotos;
	}

	// Metodo que comprueba los huevos recogidos, se reocgen todos excepto que una
	// gallina pusiera despues de las 12 y al dia siguiente antes de las 12
	private int compruebaRecogidos(int[] horas, int[] horasAnterior) {
		int recogidos = 0;

		// recorremos las 5 gallinas
		for (int i = 0; i < 5; i++) {
			// si el dia antes la gallina puso despues de las 12 y el dia en el que estamos
			// tambien puso despues de las 12 recogemos ese huevo
			if (horasAnterior[i] > 12 && horas[i] > 12) {
				recogidos++;
			}
			// si el dia anterior la gallina habia puesto antes de las 12 y este dia tambien
			// puso antes de las 12 se recoge
			if (horasAnterior[i] < 12 && horas[i] < 12) {
				recogidos++;
			}
			// si el dia anterior la gallina habia puesto antes de las 12 y este dia mas
			// tarde de las 12 se recoge
			if (horasAnterior[i] < 12 && horas[i] > 12) {
				recogidos++;
			}

		}
		return recogidos;
	}

	// Metodo que con el cambio de dia cambia el valor de los arrays (al final del
	// dia el valor del array de hoy pasa a ser ayer)
	private void cambiaArray(int[] horas, int[] horasAnterior) {
		for (int i = 0; i < 5; i++) {
			horasAnterior[i] = horas[i];
		}
	}

}
