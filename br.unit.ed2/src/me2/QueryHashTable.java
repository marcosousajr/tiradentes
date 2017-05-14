package me2;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author marcosousajr
 *
 */
public class QueryHashTable {

	private Hashtable<Object, Object> estrutura;

	public QueryHashTable() {
		this.estrutura = new Hashtable<>();
	}
	
	//MÉTODOS AUXILIARES//
	
	public Boolean contem(Object chave){
		if (buscar(chave)!=null) {
			return true;
		}
		return false;
	}
	
	//#################//
	
	//MÉTODOS PEDIDOS//
	
	public Boolean inserir(Object chave, Object valor) {
		//long temIni = System.currentTimeMillis();
		if (!contem(chave)) { //ESSA VERIFICAÇÃO NÃO TA FUNCIONANDO!
			this.estrutura.put(chave, valor);
			return true;
		}
		//long temFim = System.currentTimeMillis();
		//System.out.println("Tempo total Inserir " + (temFim - temIni));
		return false;
	}

	public Object buscar(Object chave) {
		//long temIni = System.currentTimeMillis();
		Object retorno = this.estrutura.get(chave);
		//long temFim = System.currentTimeMillis();
		//System.out.println("Tempo total Buscar " + (temFim - temIni));
		return retorno;
	}

	public void listar() {
		long temIni = System.currentTimeMillis();
		Enumeration<Object> keys = this.estrutura.keys();
		while (keys.hasMoreElements())
			System.out.println(this.estrutura.get(keys.nextElement()));
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Listar " + (temFim - temIni));
	}

	public Boolean remover(Object chave) {
		long temIni = System.currentTimeMillis();
		if (this.estrutura.containsKey(chave)) {
			this.estrutura.remove(chave);
		}
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Remover " + (temFim - temIni));
		return false;
	}
	
	public Boolean inserirBloco(Object[][] valores){
		long temIni = System.currentTimeMillis();
		for(int i = 0; i < valores.length; i++){
			this.inserir(valores[i][0], valores[i][1]);
		}
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Inserção Bloco " + (temFim - temIni));
		return true;
	}
	
	//#################//
}