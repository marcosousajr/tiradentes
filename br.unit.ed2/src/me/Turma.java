package me;

public class Turma implements Comparable<Turma> {
    
    private String codTurma;
    private Integer nrMaxAlunos;
    
    public Turma(String codTurma, int nrMaxAlunos) {

    	this.codTurma = codTurma;
    	this.nrMaxAlunos = nrMaxAlunos;
    }

    public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public int getNrMaxAlunos() {
		return nrMaxAlunos;
	}

	public void setNrMaxAlunos(int nrMaxAlunos) {
		this.nrMaxAlunos = nrMaxAlunos;
	}

	@Override
    public int compareTo(Turma o) {
        if (o.nrMaxAlunos < nrMaxAlunos) {
            return -1;
        }
        if (o.codTurma == codTurma) {
            return o.codTurma.compareTo(codTurma);
        }
        return 1;
    }
}
