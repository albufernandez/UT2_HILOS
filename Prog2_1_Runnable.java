package Unidad2;

public class Prog2_1_Runnable implements Runnable {
	
	private String cadena;
	
	public Prog2_1_Runnable(String cadena) {
		this.cadena = cadena;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i<100; i++) {
			System.out.println(cadena);
		}
		
	}

}
