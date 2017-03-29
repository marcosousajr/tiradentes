package me;

import java.util.Collection;

public interface IArvoreBinBusca<Chave extends Comparable<Chave>, Valor> {

	boolean insert(Chave chave, Valor valor);

	public NoBinBusca<Chave, Valor> getNode(Chave chave);

	Collection<Valor> getValue();

	boolean remove(Chave chave);




	

}
