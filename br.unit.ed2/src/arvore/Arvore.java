package arvore;

import java.util.Collection;

public class Arvore<Chave extends Comparable<Chave>, Valor> implements IArvore<Chave, Valor> {

	@Override
	public boolean inserir(Chave chave, Valor valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public No<Chave, Valor> obterNo(Chave chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Valor> obterValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(Chave chave) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
