package Unidad2;

public class Prog2_3_Vendedor extends Thread {
	
	//crea un objeto gestor de la clase Gestor
	private Prog2_3_Gestor gestor;
	
	//constructor de vendedor que le pasamos gestor como parametro
	public Prog2_3_Vendedor (Prog2_3_Gestor gestor) {
		this.gestor = gestor;
	}
	
	//metodo que llama al metodo vender de la clase Gestor
	public void run() {
		for (int i=0 ; i< 50 ; i++) {
			gestor.vender();
		}
	}

}
