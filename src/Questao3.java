import java.lang.Thread;

public class Questao3 {

	public static void main(String[] args) throws InterruptedException {
		Deposito dep = new Deposito();
		Produtor p = new Produtor(dep, 50);
		
		Consumidor c1 = new Consumidor(dep, 150);
		Consumidor c2 = new Consumidor(dep, 100);
		Consumidor c3 = new Consumidor(dep, 150);
		Consumidor c4 = new Consumidor(dep, 100);
		Consumidor c5 = new Consumidor(dep, 150);
		
		p.start();
		
		c1.start(); 
		c2.start(); 
		c3.start();
		c4.start(); 
		c5.start();

		
		System.out.println("Execucao do main da classe Deposito terminada");

	}
}

class Produtor extends Thread {
	private Deposito dep;
	private int n;
	
	Produtor(Deposito dep, int n) throws InterruptedException{
		this.dep = dep;
		this.n = n;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			dep.colocar();
			dep.informaItens();
			try {
				Thread.sleep(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumidor extends Thread {
	private Deposito dep;
	private int n;
	
	Consumidor(Deposito dep, int n) throws InterruptedException{
		this.dep = dep;
		this.n = n;
	}
	
	public void run() {
		for(int i = 0; i < 20;) {
			try {
				if(dep.retirar()) {
					dep.informaItens();
					i++;
					Thread.sleep(n);
				} else {
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

class Deposito extends Thread{
	private int itens = 0;
	private final int capacidade = 100;
	
	public int getNumItens() {
		return itens;
	}
	
	public boolean retirar() {
		if(itens > 0) {
			itens = getNumItens() - 1;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean colocar() {
		itens = getNumItens() + 1;
		return true;
	}
	
	public void informaItens() {
		System.out.println("O deposito possui " + this.getNumItens() + " itens");
	}


}
