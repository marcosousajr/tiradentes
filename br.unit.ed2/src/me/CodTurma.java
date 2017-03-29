package me;

public class CodTurma implements Comparable<CodTurma> {

	private String codTurma;
	
	public CodTurma(){}
	
	public CodTurma(String codTurma) {
		this.setCodTurma(codTurma);
	}
	
	public String getCodTurma() {
		return codTurma;
	}
	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	@Override
	public int compareTo(CodTurma o) {
		if (o.getCodTurma().compareTo(codTurma) < 0) {
			return -1;
		} else if (o.getCodTurma().compareTo(codTurma) > 0) {
			return 1;
		} else if (o.getCodTurma().compareTo(codTurma) == 0) {
			return o.getCodTurma().compareTo(codTurma);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "CodTurma: " + getCodTurma();
	}

}
