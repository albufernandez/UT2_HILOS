package Unidad2;

public class Prog2_4_TAC extends Thread{
	
	//se declara el objeto gestor
	private Prog2_4_Gestor gestor;
		
	//constructor de pasandole el gestor
		public Prog2_4_TAC(Prog2_4_Gestor gestor) {
			this.gestor = gestor;
		}
		
		//metodo que hace 20 veces el metodo tac de la clase gestor
		public void run() {
			for (int i =0; i<20; i++) {
				gestor.tac();
			}
		}

}
