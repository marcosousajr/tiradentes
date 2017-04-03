package arvoreBin;

import java.util.Collection;

import arvore.No;

@SuppressWarnings("hiding")
public class ArvoreBin<Chave extends Comparable <Chave>, Valor> implements IArvoreBin<Chave, Valor> {
	
	private NoBin<Chave, Valor> raiz;
	
	public ArvoreBin() {}
	
	public ArvoreBin(NoBin<Chave, Valor> raiz){
		this.setRaiz(raiz);
	}
	
	public NoBin<Chave, Valor> getRaiz() {
		return raiz;
	}
	public void setRaiz(NoBin<Chave, Valor> raiz) {
		this.raiz = raiz;
	}

	@Override
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor, NoBin<Chave, Valor> pai, LadoBin lado) {
		NoBin<Chave, Valor> noBin = new NoBin<Chave, Valor>(chave, valor, lado);
		if (raiz == null) {
			raiz = noBin;
		} else if (raiz.getChave().compareTo(noBin.getChave())< 0) {
			NoBin<Chave, Valor> esquerdo = raiz.getEsquerdo();
			if (esquerdo == null) {
				raiz.setEsquerdo(noBin);
				noBin.setPai(raiz);
				return noBin;
			} else {
				return this.inserir(chave, valor, pai, lado);
			}
		}	
		return noBin;
	}

	@Override
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor, int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> obterFilho(NoBin<Chave, Valor> pai, LadoBin lado) {
		NoBin<Chave, Valor> noBin = new NoBin<Chave,Valor>();
		if (pai == null) {
			return null;
		} else if (pai.getEsquerdo().getChave().compareTo(noBin.getChave()) == 0) {
			return pai;
			
		}
		return null;
		
		
	}

	@Override
	public NoBin<Chave, Valor> obterFilho(Chave chave, LadoBin lado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> obterNo(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> remover(NoBin<Chave, Valor> no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> remover(NoBin<Chave, Valor> pai, LadoBin lado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> remover(int indice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoBin<Chave, Valor> remover(Chave chave) {
		return null;
	}

	@Override
	public Collection<Valor> obterValores() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
