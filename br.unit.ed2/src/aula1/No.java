package aula1;

public class No<Chave extends Comparable<Chave>, Valor> {
	
	No<Chave, Valor> pai;
	No<Chave, Valor> filhoEsquerdo;
	No<Chave, Valor> filhoMeio;
	No<Chave, Valor> filhoDireito;

	Chave chave;
	Valor valor;
	
	public No(){ }
	
	
	public No(No<Chave, Valor> pai, No<Chave, Valor> filhoEsquerdo, No<Chave, Valor> filhoMeio,
			No<Chave, Valor> filhoDireito, Chave chave, Valor valor) {
		this.pai = pai;
		this.filhoEsquerdo = filhoEsquerdo;
		this.filhoMeio = filhoMeio;
		this.filhoDireito = filhoDireito;
		this.chave = chave;
		this.valor = valor;
	}

	public No<Chave, Valor> getPai() {
		return pai;
	}

	public void setPai(No<Chave, Valor> pai) {
		this.pai = pai;
	}

	public No<Chave, Valor> getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(No<Chave, Valor> filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public No<Chave, Valor> getFilhoMeio() {
		return filhoMeio;
	}

	public void setFilhoMeio(No<Chave, Valor> filhoMeio) {
		this.filhoMeio = filhoMeio;
	}

	public No<Chave, Valor> getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(No<Chave, Valor> filhoDireito) {
		this.filhoDireito = filhoDireito;
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
