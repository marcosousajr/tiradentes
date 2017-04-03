package arvoreBin;

@SuppressWarnings("hiding")
public class NoBin<Chave extends Comparable<Chave> , Valor> implements Comparable<Chave>{
	
	private NoBin<Chave, Valor> pai;
	private NoBin<Chave, Valor> esquerdo;
	private NoBin<Chave, Valor> direito;
	private Chave chave;
	private Valor valor;
	
	public NoBin(){ }
	
	public NoBin(Chave chave, Valor valor, LadoBin lado) {
		this.setPai(null);
		this.setEsquerdo(null);
		this.setDireito(null);
		this.setChave(chave);
		this.setValor(valor);
	}
	
	public NoBin(Chave chave, Valor valor, NoBin<Chave, Valor> pai, NoBin<Chave, Valor> esquerdo, NoBin<Chave, Valor> direito) {
		this.setChave(chave);
		this.setValor(valor);
		this.setPai(pai);
		this.setEsquerdo(esquerdo);
		this.setDireito(direito);
	}

	public NoBin<Chave, Valor> getPai() {
		return pai;
	}

	public void setPai(NoBin<Chave, Valor> pai) {
		this.pai = pai;
	}

	public NoBin<Chave, Valor> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NoBin<Chave, Valor> esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoBin<Chave, Valor> getDireito() {
		return direito;
	}

	public void setDireito(NoBin<Chave, Valor> direito) {
		this.direito = direito;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Chave o) {
		if (this.getChave().compareTo(o) < 0) {
			return -1;
		} else if (this.getChave().compareTo(o) > 0) {
			return 1;
		} else if (this.getChave().compareTo(o) == 0) {
			return this.getChave().compareTo(o);
		} else {
			return 0;
		}
	}

}