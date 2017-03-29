package arvore;

public class Chave implements Comparable<Chave>{
	
	protected String chave;
	
	public Chave(){}

	public Chave(String chave) {
		this.setChave(chave);
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	@Override
	public int compareTo(Chave o) {
		if (o.getChave().compareTo(getChave()) < 0) {
			return -1;
		}else if (o.getChave().compareTo(getChave()) > 0) {
			return 1;
		}else if (o.getChave().compareTo(getChave()) == 0) {
			return o.getChave().compareTo(getChave());
		}else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Chave: " + getChave();
	}
	
	
}
