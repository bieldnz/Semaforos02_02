package view;

import java.util.concurrent.Semaphore;

import controllerPessoa.Pessoa;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int x = 0; x < 4; x++) {
			Pessoa pessoa = new Pessoa(x, semaforo);
			pessoa.start();
		}
	}
}
