package prova1;


public class Cpf implements Comparable<Cpf> {

private String cpf;
	
	public Cpf(){}
	
	public Cpf(String Cpf) {
		this.setCpf(Cpf);
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String Cpf) {
		this.cpf = Cpf;
	}

	@Override
	public int compareTo(Cpf o) {
		if (o.getCpf().compareTo(cpf) < 0) {
			return -1;
		} else if (o.getCpf().compareTo(cpf) > 0) {
			return 1;
		} else if (o.getCpf().compareTo(cpf) == 0) {
			return o.getCpf().compareTo(cpf);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Cpf: " + getCpf();
	}

}
