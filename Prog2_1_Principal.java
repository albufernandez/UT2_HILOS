package Unidad2;

import java.util.Scanner;

public class Prog2_1_Principal {

	Scanner teclado = new Scanner(System.in);

	public void arrancarPrograma() {
		int opcion = 0;
		do {
			System.out.println("Biendenid@ al programa 2_1");
			mostrarMenu();
			opcion = cogerOpcion();
			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	public void mostrarMenu() {
		System.out.println("Opcion 1. Crear un hilo con Thread");
		System.out.println("Opcion 2. Crear un hilo con Runnable");
		System.out.println("Opcion 3. Crear 4 hilos, dos de cada tipo");
		System.out.println("Opcion 0. Salir");
	}

	public int cogerOpcion() {
		int opcion = Integer.parseInt(teclado.nextLine());
		return opcion;
	}

	public void procesarOpcion(int numero) {
		switch (numero) {

		case 1:
			hiloThread();
			break;

		case 2:
			hiloRunnable();
			break;

		case 3:
			hilosMixtos();
			break;

		case 0:
			System.out.println("Fin del programa");
			break;

		default:
			System.out.println("Datos erroneos");
			break;
		}

	}

	public void hiloThread() {

		System.out.println("Dime la cadena a introducir");
		String cadena = teclado.nextLine();

		Thread hilo = new Prog2_1_Thread(cadena);
		hilo.start();

		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void hiloRunnable() {

		System.out.println("Dime la cadena a introducir");
		String cadena = teclado.nextLine();

		Thread hilo = new Thread(new Prog2_1_Runnable(cadena));
		hilo.start();

		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void hilosMixtos() {

		System.out.println("Dime la cadena numero 1 a introducir");
		String cadena1 = teclado.nextLine();
		System.out.println("Dime la cadena numero 2 a introducir");
		String cadena2 = teclado.nextLine();
		System.out.println("Dime la cadena numero 3 a introducir");
		String cadena3 = teclado.nextLine();
		System.out.println("Dime la cadena numero 4 a introducir");
		String cadena4 = teclado.nextLine();

		Thread hilo1 = new Prog2_1_Thread(cadena1);
		Thread hilo2 = new Prog2_1_Thread(cadena2);

		Thread hilo3 = new Thread(new Prog2_1_Runnable(cadena3));
		Thread hilo4 = new Thread(new Prog2_1_Runnable(cadena4));

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();

		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Prog2_1_Principal programa = new Prog2_1_Principal();
		programa.arrancarPrograma();

	}

}
