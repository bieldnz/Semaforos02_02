package controllerPessoa;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{
	
	int idPessoa;
	Semaphore semaforo;
	
	public Pessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		andar();
		try {
			semaforo.acquire();
			atravessar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			semaforo.release();
		}
	}
	
	public void andar() {
		int distanciaPercorrida = 0;
		while(distanciaPercorrida <= 200) {
			distanciaPercorrida += ((int)(Math.random()*2)+4);
			System.out.println("#"+idPessoa+" andou "+distanciaPercorrida+" metros");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void atravessar() {
		int tempo = ((int)(Math.random()*1000)+1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#"+idPessoa+" atravessou a porta");
	}
}
