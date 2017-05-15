package me2;

import java.util.Random;
import me2.Keyboard;
import me2.QueryHashTable;

/**
 * @author marcosousajr
 *
 */
public class Main {

	private static QueryHashTable tabela = new QueryHashTable();
	private static int cont = 0;

	public static void main(String[] args) {

		int opcao;
		do {
			Keyboard.clrscr();
			opcao = Keyboard.menu("Inserir Todos/Inserir Um/Buscar/Listar/Remover");
			switch (opcao) {
			case 1:
				int numInsert = Keyboard.readInt("Digite o Nº de inserções: ");
				inserir(numInsert);
				break;
			case 2:
				inserirUm();
				break;
			case 3:
				int numSearch = Keyboard.readInt("Digite o Nº a buscar: ");
				buscar(numSearch);
				break;
			case 4:
				listar();
				break;
			case 5:
				int numRemove = Keyboard.readInt("Digite o Nº a remover: ");
				remover(numRemove);
				break;
			}

		} while (opcao < 6);
		System.out.println("\nFim do programa");

	}

	public int getCont() {
		return cont;
	}

	static void inserir(int quantidade) {
		Random aleatorio = new Random();
		int numeros = aleatorio.nextInt();
		long temIni = System.nanoTime();
		for (int i = 0; i < quantidade; i++) {
			tabela.inserir(i + 1, numeros);
			cont++;
		}
		long temFim = System.nanoTime();
		float resultado = (temFim - temIni);
		String tempo = String.format("%.5f", resultado / 1000000000);
		System.out.println("Tempo total Inserir: " + tempo);

		Keyboard.waitEnter();
	}

	static void inserirUm() {
		Random aleatorio = new Random();
		int numeros = aleatorio.nextInt();
		long temIni = System.nanoTime();
		tabela.inserir(cont + 1, numeros);
		cont++;
		long temFim = System.nanoTime();
		float resultado = (temFim - temIni);
		String tempo = String.format("%.5f", resultado / 1000000000);
		System.out.println("Tempo total Inserir: " + tempo);

		Keyboard.waitEnter();
	}

	static void buscar(int numero) {
		long temIni = System.nanoTime();
		for (int i = 0; i < tabela.tamanho(); i++) {
			tabela.buscar(numero);
			cont++;
		}
		long temFim = System.nanoTime();
		float resultado = (temFim - temIni);
		String tempo = String.format("%.5f", resultado / 1000000000);
		System.out.println("Tempo total Buscar: " + tempo);

		Keyboard.waitEnter();
	}

	static void listar() {
		long temIni = System.nanoTime();
		if (tabela != null) {
			tabela.listar();
		} else
			System.out.println("Tabela Vazia!");
		long temFim = System.nanoTime();
		float resultado = (temFim - temIni);
		String tempo = String.format("%.5f", resultado / 1000000000);
		System.out.println("Tempo total Listar: " + tempo);
		Keyboard.waitEnter();

	}

	static void remover(int numero) {
		long temIni = System.nanoTime();
		for (int i = 0; i < tabela.tamanho(); i++) {
			tabela.remover(numero);
			cont++;
		}
		long temFim = System.nanoTime();
		float resultado = (temFim - temIni);
		String tempo = String.format("%.5f", resultado / 1000000000);
		System.out.println("Tempo total Remover: " + tempo);
		Keyboard.waitEnter();
	}

}