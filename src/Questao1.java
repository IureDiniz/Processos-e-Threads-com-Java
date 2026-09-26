import java.lang.Thread;
import java.util.ArrayList;

public class Questao1 {
	public static void main(String[] args) {
		try {
			RacerInterface.executaMain(10);
			
			// RacerClass.executaMain(10);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class RacerInterface implements Runnable{
	private Thread t;
	private int id;
	
	public RacerInterface(int id) {
		this.id = id;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println("Racer " + this.id + " - Imprimido");
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start () {
		  if (t == null) {
		     t = new Thread (this);
		     t.start ();
		  }
	 }
	
	public void join() throws InterruptedException {
		if(t == null) {
			t = new Thread (this);
			t.join();
		} else {
			t.join();
		}
	}
	
	public static void executaMain(int n) throws InterruptedException {
		ArrayList<RacerInterface> impares = new ArrayList<RacerInterface>();
		ArrayList<RacerInterface> pares = new ArrayList<RacerInterface>();
		
		for(int i = 0; i < n; i++) {
			RacerInterface ri = new RacerInterface(i);
			
			if(ri.id % 2 != 0) {
				impares.add(ri);
			} else {
				pares.add(ri);
			}
		}
		
		for(RacerInterface ri : impares) {
			ri.start();
		}
		
		for(RacerInterface ri : impares) {
			ri.join();
		}
		
		for(RacerInterface ri : pares) {
			ri.start();
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
		for(int i = 0; i < 1000; i++) {
			System.out.println("Racer " + this.id + " - Imprimido");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void executaMain(int n) throws InterruptedException {
		ArrayList<RacerClass> impares = new ArrayList<RacerClass>();
		ArrayList<RacerClass> pares = new ArrayList<RacerClass>();
		for(int i = 0; i < n; i += 1) {
			if(i % 2 != 0) {
				impares.add(new RacerClass(i));
			}else {
				pares.add(new RacerClass(i));
			}
		}
		
		for(RacerClass rc : impares) {
			rc.start();
		}
		
		for(RacerClass rc : impares) {
			rc.join();
		}
		
		for(RacerClass rc : pares) {
			rc.start();
		}
	}
}
