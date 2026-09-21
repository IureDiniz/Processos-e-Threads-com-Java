import java.lang.Thread;

public class Questao1 {
	public static void main(String[] args) {
		// RacerInterface.executaMain(5);
		
		RacerClass.executaMain(2);
	}
}

class RacerInterface implements Runnable{
	private Thread t;
	private int id;
	
	public RacerInterface(int id) {
		this.id = id;
	}
	
	public void run() {
		while(true) {
			System.out.println("Racer " + this.id + " - Imprimido");
		}
	}
	
	public void start () {
		  if (t == null) {
		     t = new Thread (this);
		     t.start ();
		  }
	 }
	
	public static void executaMain(int n) {
		for(int i = 0; i < n; i++) {
			RacerInterface RI = new RacerInterface(i);
			RI.start();
		}
	}
}

class RacerClass extends Thread{
	private Thread t;
	private int id;
	
	public RacerClass(int id) {
		this.id = id;
	}
	
	public void run() {
		while(true) {
			System.out.println("Racer " + this.id + " - Imprimido");
		}
	}
	
	
	public static void executaMain(int n) {
		for(int i = 0; i < n; i++) {
			RacerClass rc = new RacerClass(i);
			rc.start();
		}
	}
}
