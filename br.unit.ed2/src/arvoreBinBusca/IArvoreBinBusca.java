package arvoreBinBusca;

import java.util.Collection;

public interface IArvoreBinBusca<Chave extends Comparable<Chave>, Valor> {

	public boolean insert(Chave chave, Valor valor);

	public NoBinBusca<Chave, Valor> getNode(Chave chave);

	public Collection<Valor> getValue();

	public boolean remove(Chave chave);




	

}
