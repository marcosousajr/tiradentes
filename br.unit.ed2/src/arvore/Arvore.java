package arvore;

import java.util.ArrayList;
import java.util.Collection;


public class Arvore<Chave extends Comparable<Chave>, Valor> implements IArvore<Chave, Valor> {
	
	private No<Chave, Valor> raiz;
	private ArrayList<Valor> list;

	@Override
	public boolean inserir(Chave chave, Valor valor, Lado lado) {
		No<Chave, Valor> no = new No<Chave, Valor>(chave, valor,lado);
		if (raiz == null) {
			raiz = no;
			list.add(valor);
			return true;
		} else {
			return inserir(no, raiz);
		}
	}
	
	public boolean inserir(No<Chave, Valor> no, No<Chave, Valor> raiz) {
		if (raiz.getChave().compareTo(no.getChave()) < 0) {
			No<Chave, Valor> esquerdo = raiz.getEsquerdo();
			if (esquerdo == null) {
				raiz.setEsquerdo(no);
				no.setPai(raiz);
				list.add(no.getValor());
				return true;
			} else {
				return this.inserir(no, esquerdo);
			}
		} else if (raiz.compareTo(no.getChave()) == 0) {
			No<Chave, Valor> meio = raiz.getMeio();
			if (meio == null) {
				raiz.setMeio(no);
				no.setPai(raiz);
				list.add(no.getValor());
				return true;
			} else {
				return this.inserir(no, meio);
			}
		} else if (raiz.compareTo(no.getChave()) > 0) {
			No<Chave, Valor> direito = raiz.getDireito();
			if (direito == null) {
				raiz.setDireito(no);
				no.setPai(raiz);
				list.add(no.getValor());
				return true;
			} else {
				return this.inserir(no, direito);
			}
		}
		return false;
	}

	@Override
	public No<Chave, Valor> obterNo(Chave chave) {
		return obterNo(chave, this.raiz);
	}
	
	// obter nó
	private No<Chave, Valor> obterNo(Chave chave, No<Chave, Valor> no) {
		if (no == null) {
			return null;
		} else if (chave.compareTo(no.getChave()) > 0) {
			return obterNo(chave, no.getEsquerdo());
		}else if (chave.compareTo(no.getChave()) == 0) {
			return obterNo(chave, no.getMeio());
		} else {
			return obterNo(chave, no.getDireito());
		}
	}
	
	// limpando árvore
		public void limpar() {
			raiz.setEsquerdo(null);
			raiz.setDireito(null);
			raiz.setMeio(null);
			raiz = null;
		}

	@Override
	public Collection<Valor> listarValores() {
		return list;
	}

	@Override
	public boolean remover(Chave chave) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
