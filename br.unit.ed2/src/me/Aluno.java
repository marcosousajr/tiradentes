package me;

public class Aluno implements Comparable<Aluno> {

    private String rgAluno;
    private String nmAluno;
    private ArvoreBusca<Turma> turmas = new ArvoreBusca<>();

    public Aluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getRgAluno() {
		return rgAluno;
	}

	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}

	public String getNmAluno() {
		return nmAluno;
	}

	public void setNmAluno(String nmAluno) {
		this.nmAluno = nmAluno;
	}

	public ArvoreBusca<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArvoreBusca<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public int compareTo(Aluno o) {
        if (o.rgAluno.compareTo(getRgAluno()) < 0) {
            return -1;
        }
        if (o.rgAluno.compareTo(getRgAluno()) == 0) {
            return 0;
        }
        return 1;
    }    
}
