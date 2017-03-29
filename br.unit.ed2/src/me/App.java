package me;

public class App {

	static ArvoreBinBusca<CodTurma, Turma> turmas = new ArvoreBinBusca<CodTurma, Turma>();
	static ArvoreBinBusca<Rg, Aluno> alunos = new ArvoreBinBusca<Rg, Aluno>();
	
	public static void main(String[] args) {
		int opcao;
		do {
			Keyboard.clrscr();
			opcao = Keyboard.menu("Incluir turma/Remover turma/Listar alunos turma/Listar turmas/"
					+ "Incluir Aluno/Incluir reserva/Cancelar reservas");

			switch (opcao) {
			case 1:
				incluirTurma();
				break;
			case 2:
				removerTurma();
				break;
			case 3:
				listarAlunosTurma();
				break;
			case 4:
				listarTurmas();
				break;
			case 5:
				incluirAluno();
				break;
			case 6:
				incluirReserva();
				break;
			case 7:
				cancelarReserva();
				break;

			}
		} while (opcao < 8);
		System.out.println("\nFim do programa");
	}

	static void incluirTurma() {
		char resp;
		do {
			Keyboard.clrscr();
			String codTurma = Keyboard.readString("Informe o código da turma: ");
			int nrMaxAlunos = Keyboard.readInt("Informe o número máx. de alunos: ");
			CodTurma cod = new CodTurma(codTurma);
			Turma turma = new Turma(cod, nrMaxAlunos);
			if (turmas.getNode(cod) != null) {
				System.err.println("Turma já cadastrada!");
			}
			turmas.insert(cod, turma);

			resp = Keyboard.readChar("Outra turma? (s/n): ");
		} while (resp == 's');
	}

	static void removerTurma() {
		char resp;
		do {
			Keyboard.clrscr();
			String codTurma = Keyboard.readString("Informe o código da turma: ");
			CodTurma cod = new CodTurma(codTurma);
			if (turmas.remove(cod)) {
				System.out.println("Turma " + codTurma + "removida.");
			} else
				System.out.println("Turma não encontrada.");
			resp = Keyboard.readChar("Remover outra turma? (s/n): ");
		} while (resp == 's');
	}

	static void listarAlunosTurma() {
		char resp;
		do {
			Keyboard.clrscr();
			String codTurma = Keyboard.readString("Informe o código da turma: ");
			CodTurma cod = new CodTurma(codTurma);
			if (turmas.getNode(cod) != null) {
				System.out.println(turmas.getNode(cod).getValue().getAlunos().getValue());
			} else
				System.out.println("Turma não encontrada.");

			resp = Keyboard.readChar("Listar outra turma? (s/n): ");
		} while (resp == 's');
	}

	static void listarTurmas() {
		if (turmas.getValue() != null) {
			System.out.println(turmas.getValue());
		} else {
			System.out.println("não há turmas.");
		}
		System.out.println("\n\n\n");
	}

	static void incluirAluno() {
		char resp;
		do {
			Keyboard.clrscr();
			String rgAluno = Keyboard.readString("Informe o número de Rg: ");
			Rg rg = new Rg(rgAluno);
			String nmAluno = Keyboard.readString("Informe o nome do aluno: ");
			Aluno aluno = new Aluno();
			aluno.setRg(rg);
			aluno.setNome(nmAluno);
			if (alunos.getNode(rg) != null) {
				System.err.println("Aluno já cadastrado.");
			} else
				alunos.insert(rg, aluno);
			resp = Keyboard.readChar("Outro aluno? (s/n): ");
		} while (resp == 's');
	}

	static void incluirReserva() {
		char resp;
		do {
			Keyboard.clrscr();
			String rgAluno = Keyboard.readString("Informe o número de Rg: ");
			Rg rg = new Rg(rgAluno);
			String codTurma = Keyboard.readString("Informe o código da turma: ");
			CodTurma cod = new CodTurma(codTurma);
			if (turmas.getNode(cod) != null && alunos.getNode(rg) != null) {
				if (turmas.getNode(cod).getValue().reservar(alunos.getNode(rg).getValue())) {
					System.out.println("Reservado!");
				} else if (turmas.getNode(cod).getValue().enfileirar(alunos.getNode(rg).getValue())) {
					System.out.println(alunos.getNode(rg).getValue().getNome() + " está aguanrdando vaga.");
				}
				System.out.println("Não reservado.");
			} else
				System.out.println("Turma não encontrada");
			resp = Keyboard.readChar("Outra reserva? (s/n): ");
		} while (resp == 's');
	}

	static void cancelarReserva() {
		char resp;
		do {
			Keyboard.clrscr();
			String rgAluno = Keyboard.readString("Informe o número de Rg: ");
			Rg rg = new Rg(rgAluno);
			String codTurma = Keyboard.readString("Informe o código da turma: ");
			CodTurma cod = new CodTurma(codTurma);
			if (turmas.getNode(cod) != null) {
				if (turmas.getNode(cod).getValue().cancelar(alunos.getNode(rg).getValue())) {
					System.out.println("Cancelada!");
				}
				System.out.println("não cancelada.");
			} else
				System.out.println("Turma não encontrada");
			resp = Keyboard.readChar("Cancelar outra reserva? (s/n): ");
		} while (resp == 's');
	}

	
}
