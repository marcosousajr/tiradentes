package me2;

import me.Keyboard;
import me2.Rg;
import me2.QueryHashTable;

public class App {
	
	
	static QueryHashTable alunos = new QueryHashTable();
	
	public static void main(String[] args) {
		int cont = 0;
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
	
	static void inserir(){
		Aluno aluno = new Aluno();
		String rgAluno = Keyboard.readString("Digite o rg");
		Rg rg = new Rg(rgAluno);
		String nome = Keyboard.readString("Digite o nome do aluno");
		aluno.setRg(rg);
		aluno.setNome(nome);
		alunos.inserir(rg, aluno);
	}
	
	static void buscar(){
		if(alunos != null){
			String rgAluno = Keyboard.readString("Digite o rg");
			Rg rg = new Rg(rgAluno);
			alunos.buscar(rg);
		}
		System.out.println("Tabela Vazia!");
	}
	
	static void listar(){
		if (alunos != null) {
			alunos.listar();
		}
		System.out.println("Tabela Vazia!");
	}
	
	static void remover(){
		if (alunos != null) {
			String rgAluno = Keyboard.readString("Digite o rg");
			Rg rg = new Rg(rgAluno);
			alunos.remover(rg);
		}
		System.out.println("Tabela Vazia!");
	}

}
