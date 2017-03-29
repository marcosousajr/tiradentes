package arvore;

import java.util.Collection;

import arvoreBinBusca.NoBinBusca;

public interface IArvore<Chave extends Comparable<Chave>, Valor> {
	
	public boolean inserir(Chave chave, Valor valor);

	public No<Chave, Valor> obterNo(Chave chave);

	public Collection<Valor> obterValor();

	public boolean remover(Chave chave);

}
