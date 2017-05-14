package me2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import me2.Keyboard;
import me2.Rg;
import me2.QueryHashTable;

public class Main {

	private static QueryHashTable alunos = new QueryHashTable();
	private static final String INSERT = "//mnt//sda4//listInsert.txt";
	private static final String SEARCH = "//mnt//sda4//listSearch.txt";

	public static void main(String[] args) {

		int opcao;
		do {
			Keyboard.clrscr();
			opcao = Keyboard.menu("Inserir Objeto/Buscar Objeto/Listar Objeto/Remover Objeto");
			switch (opcao) {
			case 1:
				inserir();
				break;
			case 2:
				buscar();
				break;
			case 3:
				listar();
				break;
			case 4:
				remover();
				break;
			}

		} while (opcao < 5);
		System.out.println("\nFim do programa");

	}

	static void inserir() {
		long temIni = System.currentTimeMillis();
		int cont=0;
		try (BufferedReader br = new BufferedReader(new FileReader(INSERT))) {
			String linhaAtual;
			Aluno aluno = new Aluno();
			while ((linhaAtual = br.readLine()) != null) {
				String[] textoSeparado = linhaAtual.split(";|;\\s");
				Rg rg = new Rg(textoSeparado[0]);
				aluno.setRg(rg);
				aluno.setNome(textoSeparado[1]);
				alunos.inserir(rg, aluno);
				cont++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Inserir " + (temFim - temIni));
		System.out.println("Nº de inserções : " + cont);
		System.out.println("Tamanho da tabela : " + alunos.tamanho());
		
		Keyboard.waitEnter();
	}

	static void buscar() { //não encontrou!
		long temIni = System.currentTimeMillis();
		int cont=0;
		try (BufferedReader br = new BufferedReader(new FileReader(SEARCH))) {
			String linhaAtual;

			if (alunos != null) {
				while ((linhaAtual = br.readLine()) != null) {
					String[] textoSeparado = linhaAtual.split(";|;\\s");
					Rg rg = new Rg(textoSeparado[0]);
					alunos.buscar(rg);
					cont++;
				}
			}
			System.out.println("Tabela Vazia!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Buscar " + (temFim - temIni));
		System.out.println("Nº de Buscas : " + cont);
		Keyboard.waitEnter();
	}

	static void listar() {
		long temIni = System.currentTimeMillis();
		
		if (alunos != null) {
			alunos.listar(); //listando apenas o último
		}
		System.out.println("Tabela Vazia!");
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Listar " + (temFim - temIni));
		Keyboard.waitEnter();

	}

	static void remover() {
		long temIni = System.currentTimeMillis();
		if (alunos != null) {
			String rgAluno = Keyboard.readString("Digite o rg");
			Rg rg = new Rg(rgAluno);
			alunos.remover(rg);
		}
		System.out.println("Tabela Vazia!");
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Remover " + (temFim - temIni));
		Keyboard.waitEnter();
	}

}
