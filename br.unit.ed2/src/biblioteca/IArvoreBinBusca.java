package biblioteca;

import java.util.Collection;

public interface IArvoreBinBusca<Chave extends Comparable<Chave>, Valor> {

public boolean inserir(Chave chave, Valor valor);
	
	public NoBinBusca<Chave, Valor> obterNo(Chave chave);
	
	public boolean remover(Chave chave);
	
	Collection<Valor> obterValores();
}
