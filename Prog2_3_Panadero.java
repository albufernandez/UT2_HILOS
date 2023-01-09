package Unidad2;

public class Prog2_3_Panadero extends Thread{
		
	//creamos un objeto de la clase gestor
	private Prog2_3_Gestor gestor;
	
		//constructor de panadero que le pasamos gestor como parametro
		public Prog2_3_Panadero(Prog2_3_Gestor gestor) {
			this.gestor = gestor;
		}
		
		//metodo que llama a metodo de la clase gestor
		public void run() {
			for (int i =0; i< 50 ;i++) {
				gestor.hacer();
			}
		}
}
