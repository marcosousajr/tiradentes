package me;

import java.util.Comparator;
import diversos.*;

public class App {

	private static Treap<Aluno> alunos = new Treap<Aluno>(false);
	private static Treap<Turma> turmas = new Treap<Turma>(false);

	
	static void incluirAluno() {
		char resp;
		do {
			Keyboard.clrscr();
			String rgAluno = Keyboard.readString("Informe o número de RG: ");
			Aluno aluno = new Aluno(rgAluno);
			if (!alunos.contains(aluno)) {
				String nmAluno = Keyboard.readString("Informe o nome do aluno: ");
				aluno.setNmAluno(nmAluno);
			} else {
				System.err.println("Aluno já cadastrado.");
			}

			alunos.add(aluno);

			resp = Keyboard.readChar("Outro aluno? (s/n): ");
		} while (resp == 's');
	}
	
	static void listarAlunos() {
		Keyboard.clrscr();
		System.out.println("NumMat  Nome");
		System.out.println("------  --------------------");
		MyIterator<Aluno> it = alunos.iterator();
		Aluno aluno = it.getFirst();
		while (aluno != null) {
			System.out.printf("%6d  %-20s\n", aluno.getNumMat(),
					aluno.getNmAluno());
			aluno = it.getNext();
		}
		Keyboard.waitEnter();
	}

	static void excluirAlunos() {
		char resp;
		do {
			Keyboard.clrscr();
			int numMat = Keyboard.readInt("Informe o número de matrícula: ");
			Aluno aluno = alunos.retrieve(new Aluno(numMat));
			if (aluno == null) {
				System.err.println("Aluno não cadastrado");
			} else {
				char rem;
				System.out.println("NumMat  Nome");
				System.out.println("------  ------------------");
				System.out.printf("%6d  %-20s\n", aluno.getNumMat(),
						aluno.getNmAluno());
				rem = Keyboard.readChar("Deseja remover? (s/n): ");
				if (rem == 's') {
					alunos.remove(aluno);
					System.err.println("Aluno removido com sucesso");
				} else {
					System.err.println("Aluno não removido");
				}
			}
			resp = Keyboard.readChar("\nOutro aluno? (s/n): ");
		} while (resp == 's');
	}
	
	static void matricularAluno() {
		char resp;
		do {
			Keyboard.clrscr();
			int numMat = Keyboard.readInt("Informe o número de matrícula: ");
			Aluno aluno = alunos.retrieve(new Aluno(numMat));
			if (aluno == null) {
				System.err.println("Aluno não cadastrado");
			} else {
				int codDisc = Keyboard
						.readInt("Informe o código da disciplina: ");
				Disciplina disciplina = disciplinas.retrieve(new Disciplina(
						codDisc));
				if (disciplina == null) {
					System.err.println("Disciplina não cadastrada");
				} else {
					String codTurma = Keyboard
							.readString("Informe o código da turma: ");
					Turma turma = turmas.retrieve(new Turma(codDisc, codTurma));
					if (turma == null) {
						System.err.println("Turma não cadastrada");
					} else {
						MyIterator<Turma> it = aluno.getTurmas().iterator();
						Turma turmaAluno = it.getFirst();
						while (turmaAluno != null) {
							if (turmaAluno.getCodDisc() == codDisc
									&& turmaAluno.getCodTurma()
											.equalsIgnoreCase(codTurma)) {
								System.err
										.println("Este aluno já está matriculado"
												+ "nesta turma");
								break;
							}
							turmaAluno = it.getNext();
						}
						aluno.getTurmas().add(turma);
					}
				}
			}
			resp = Keyboard.readChar("Deseja matricular outro aluno? (s/n): ");
		} while (resp == 's');
	}
	
	static void listarAlunosMatriculados() {
		Keyboard.clrscr();
		String codTurma = Keyboard.readString("Informe o código da disciplina: ");
		int nrMaxAlunos = Keyboard.readInt("Digite o número máximo de alunos: ");
		Turma turma = turmas.retrieve(new Turma(codTurma,nrMaxAlunos));
		if (turma == null) {
			System.err.println("Turma não cadastrada");
		} else {
			System.out.println("Cod. da Turma: " + turma.getCodTurma()
			+ " Máx. alunos: " + turma.getNrMaxAlunos());
			System.out.println("NumMat  Nome do Aluno");
			System.out.println("------  --------------------------");
			Aluno[] arrayAlunos = new Aluno[alunos.size() - 1];
			int cont = 0;
			MyIterator<Aluno> it = alunos.iterator();
			Aluno p = it.getFirst();
			while (p != null) {
				if (!p.getTurmas().isEmpty()) {
					arrayAlunos[cont] = p;
					cont++;
				}
				p = it.getNext();
			}
			Sort.quickSort(arrayAlunos, new Comparator<Aluno>() {
				@Override
				public int compare(Aluno o1, Aluno o2) {
					return o1.getRgAluno().compareTo(o2.getRgAluno());
				}
			});
			for (int i = 0; i < cont; i++) {
				System.out.printf("%6d  %-30s\n",
						arrayAlunos[i].getRgAluno(),
						arrayAlunos[i].getNmAluno());
			}
		}
		Keyboard.waitEnter();
	}
	
	static void incluirTurma() {
		char resp;
		do {
			Keyboard.clrscr();
			int codDisc = Keyboard.readInt("Informe o código da disciplina: ");
			Disciplina disciplina = disciplinas
					.retrieve(new Disciplina(codDisc));
			if (disciplina == null) {
				System.err.println("Disciplina não cadastrada");
			} else {
				String codTurma = Keyboard
						.readString("Informe o código da turma: ");
				Turma turma = new Turma(codDisc, codTurma);
				if (!turmas.add(turma)) {
					System.err.println("Turma já cadastrada nessa disciplina");
				} else {
					turmas.add(turma);
				}
			}
			resp = Keyboard.readChar("Outra turma? (s/n): ");
		} while (resp == 's');
	}
	static void listarTurmas() {
		Keyboard.clrscr();
		System.out.println("CodDisc  Nome da Disciplina              Turma");
		System.out.println("-------  ------------------------------  --------");
		MyIterator<Turma> it = turmas.iterator();
		Turma p = it.getFirst();
		Turma[] arrayTurmas = new Turma[turmas.size() - 1];
		int cont = 0;
		while (p != null) {
			arrayTurmas[cont] = p;
			cont++;
			p = it.getNext();
		}
		Sort.quickSort(arrayTurmas, new Comparator<Turma>() {
			@Override
			public int compare(Turma o1, Turma o2) {
				return o1.getCodTurma().compareTo(o2.getCodTurma());
			}
		});
		for (int i = 0; i < arrayTurmas.length; i++) {
			Disciplina disc = disciplinas.retrieve(new Disciplina(
					arrayTurmas[i].getCodDisc()));
			System.out.printf("%7d  %-30s  %8s\n",
					disc != null ? disc.getCodDisc() : "-",
					disc != null ? disc.getNmDisc() : "-",
					arrayTurmas[i].getCodTurma());
		}
		Keyboard.waitEnter();
	}
	
	static void excluirTurmas() {
		char resp;

		do {
			Keyboard.clrscr();
			int codDisc = Keyboard.readInt("Informe o código da disciplina: ");
			Disciplina disciplina = disciplinas
					.retrieve(new Disciplina(codDisc));
			if (disciplina == null) {
				System.err.println("Disciplina não cadastrada");
			} else {
				String codTurma = Keyboard
						.readString("Informe o código da turma: ");
				Turma turma = turmas.retrieve(new Turma(codDisc, codTurma));
				if (turma == null) {
					System.err.println("Turma não cadastrada");
				} else if (!hasDisc(turma)) {
					char rem;
					System.out.println("CodDis  CodTurma  Nome");
					System.out.println("------  --------  ------------------");
					System.out.printf("%6d %8s  %-20s\n",
							disciplina.getCodDisc(), turma.getCodTurma(),
							disciplina.getNmDisc());
					rem = Keyboard.readChar("Deseja remover? (s/n): ");
					if (rem == 's') {
						turmas.remove(turma);
						System.err.println("Turma removida com sucesso");
					} else {
						System.err.println("Turma não removido");
					}
				} else {
					System.err.println("Turma possui disciplinas vinculadas.");
				}
			}
			resp = Keyboard.readChar("Outra turma? (s/n): ");
		} while (resp == 's');
	}
	
	
	
	
	public static void main(String[] args) {
		int opcao;
		do {
			Keyboard.clrscr();
			opcao = Keyboard
					.menu("Incluir Aluno/Listar Alunos/Excluir Alunos"
							+ "/Incluir Disciplina/Listar Disciplinas/Excluir Disciplinas"
							+ "/Incluir Turmas/Listar Turmas/Excluir Turmas/"
							+ "Matricular Aluno/Listar alunos matriculados/Desenhe/Terminar");

			switch (opcao) {
			case 1:
				incluirAluno();
				break;
			case 2:
				listarAlunos();
				break;
			case 3:
				excluirAlunos();
				break;
			case 4:
				incluirDisciplina();
				break;
			case 5:
				listarDisciplinas();
				break;
			case 6:
				excluirDisciplinas();
				break;
			case 7:
				incluirTurma();
				break;
			case 8:
				listarTurmas();
				break;
			case 9:
				excluirTurmas();
				break;
			case 10:
				matricularAluno();
				break;
			case 11:
				listarAlunosMatriculados();
				break;
			case 12:
				menuDesenhe();
				break;
			}

		} while (opcao < 13);
		System.out.println("\nFim do programa");
	}
}

