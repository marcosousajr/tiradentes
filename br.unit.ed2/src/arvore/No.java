package arvore;

public class No<Chave extends Comparable<Chave> , Valor> {
	
	No<Chave, Valor> pai;
	No<Chave, Valor> esquerdo;
	No<Chave, Valor> meio;
	No<Chave, Valor> direito;

	Chave chave;
	Valor valor;
	
	public No(){ }
	
	public No(Chave chave, Valor valor, Lado lado) {
		this.setChave(chave);
		this.setValor(valor);
		
	}
	
	public No(Chave chave, Valor valor, No<Chave, Valor> pai, No<Chave, Valor> esquerdo, No<Chave, Valor> meio,
			No<Chave, Valor> direito) {
		this.setChave(chave);
		this.setValor(valor);
		this.setPai(pai);
		this.setEsquerdo(esquerdo);
		this.setMeio(meio);
		this.setDireito(direito);
	}

	public int compareTo(Chave chv){
		return this.getChave().compareTo(chv);
	}
	
	public No<Chave, Valor> getPai() {
		return pai;
	}

	public void setPai(No<Chave, Valor> pai) {
		this.pai = pai;
	}

	public No<Chave, Valor> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No<Chave, Valor> esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No<Chave, Valor> getMeio() {
		return meio;
	}

	public void setMeio(No<Chave, Valor> meio) {
		this.meio = meio;
	}

	public No<Chave, Valor> getDireito() {
		return direito;
	}

	public void setDireito(No<Chave, Valor> direito) {
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

}