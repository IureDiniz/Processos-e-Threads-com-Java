import java.lang.Thread;

public class Questao1 {
	public static void main(String[] args) {
		//RacerInterface.executaMain();
		
		RacerClass.executaMain();
	}
}

class RacerInterface implements Runnable{
	private Thread t;
	private String id;
	
	public RacerInterface(String id) {
		this.id = id;
	}
	
	public void run() {
		while(true) {
			System.out.println("Racer " + this.id + "- Imprimido");
		}
	}
	
	public void start () {
		  System.out.println("Starting " +  id );
		  if (t == null) {
		     t = new Thread (this, id);
		     t.start ();
		  }
	 }
	
	public static void executaMain() {
		RacerInterface RI1 = new RacerInterface("Pele");
		RI1.start();

		RacerInterface RI2 = new RacerInterface("Garrimcha");
		RI2.start();
	}
}

class RacerClass extends Thread{
	private Thread t;
	private String id;
	
	public RacerClass(String id) {
		this.id = id;
	}
	
	public void run() {
		while(true) {
			System.out.println("Racer " + this.id + "- Imprimido");
		}
	}
	
	public void start () {
		  System.out.println("Starting " +  id );
		  if (t == null) {
		     t = new Thread (this, id);
		     t.start ();
		  }
	 }
	
	public static void executaMain() {
		RacerClass RI1 = new RacerClass("Pele");
		RI1.start();

		RacerClass RI2 = new RacerClass("Garrimcha");
		RI2.start();
	}
}
