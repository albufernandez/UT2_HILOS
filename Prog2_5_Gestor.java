package Unidad2;

public class Prog2_5_Gestor {
	private int contador = 0;

	public synchronized void pin() {

		while (contador != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

			System.out.println("PIN");
			contador++;
			notifyAll();

	}

	public synchronized void pan() {

		while (contador != 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("-PAN");
		contador++;
		notifyAll();

	}

	public synchronized void pun() {

		while (contador != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("--PUN");
		contador = 0;
		notifyAll();

	}

}
