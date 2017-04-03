package arvoreBin;

import java.util.Collection;

@SuppressWarnings("hiding")
public interface IArvoreBin<Chave extends Comparable<Chave>, Valor> {
	
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor, NoBin<Chave, Valor> pai, LadoBin lado);
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor, int indice);
	public NoBin<Chave, Valor> inserir(Chave chave, Valor valor);
	public NoBin<Chave, Valor> obterFilho(NoBin<Chave, Valor> pai, LadoBin lado);
	public NoBin<Chave, Valor> obterFilho(Chave chave, LadoBin lado);
	public NoBin<Chave, Valor> obterNo(int indice);
	public NoBin<Chave, Valor> remover(NoBin<Chave, Valor> no);
	public NoBin<Chave, Valor> remover(NoBin<Chave, Valor> pai, LadoBin lado);
	public NoBin<Chave, Valor> remover(int indice);
	public NoBin<Chave, Valor> remover(Chave chave);
	public Collection<Valor> obterValores();	

}
