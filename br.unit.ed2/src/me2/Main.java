package me2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import me.Keyboard;
import me2.Rg;
import me2.QueryHashTable;

public class Main {

	private static QueryHashTable alunos = new QueryHashTable();
	private static final String FILENAME = "//mnt//sda4//listaTeste.txt";
	private static int cont = 0;

	public static void main(String[] args) {

		int opcao;
		do {
			// Keyboard.clrscr();
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
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String linhaAtual;
			Aluno aluno = new Aluno();
			while ((linhaAtual = br.readLine()) != null) {
				String[] textoSeparado = linhaAtual.split(";|;\\s");
				String rgAluno = textoSeparado[0];
				String nome = textoSeparado[1];
				Rg rg = new Rg(rgAluno);
				aluno.setRg(rg);
				aluno.setNome(nome);
				alunos.inserir(rg, aluno);
				cont++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Inserir " + (temFim - temIni));
		System.out.println("Nº de inserções : " + cont);
	}

	static void buscar() {
		if (alunos != null) {
			String rgAluno = Keyboard.readString("Digite o rg");
			Rg rg = new Rg(rgAluno);
			alunos.buscar(rg);
		}
		System.out.println("Tabela Vazia!");
	}

	static void listar() {
		if (alunos != null) {
			alunos.listar();
		}
		System.out.println("Tabela Vazia!");
	}

	static void remover() {
		if (alunos != null) {
			String rgAluno = Keyboard.readString("Digite o rg");
			Rg rg = new Rg(rgAluno);
			alunos.remover(rg);
		}
		System.out.println("Tabela Vazia!");
	}

}
