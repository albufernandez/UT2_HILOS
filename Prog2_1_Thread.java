package Unidad2;

public class Prog2_1_Thread extends Thread{

	private String cadena;
	
	public Prog2_1_Thread(String cadena) {
		this.cadena = cadena;
	}
	
	public void run() {
		
		for (int i = 0; i<100; i++) {
			System.out.println(cadena);
		}
	}
}
	
