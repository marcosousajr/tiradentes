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

	// MÉTODOS AUXILIARES//

	public Boolean contem(Object chave) {
		if (this.estrutura.containsKey(chave))
			return true;
		
		return false;
	}
	
	public int tamanho(){
		return this.estrutura.size();
	}

	// #################//

	// MÉTODOS PEDIDOS//

	public Boolean inserir(Object chave, Object valor) {
		if (!contem(chave)) { // ESSA VERIFICAÇÃO NÃO TA FUNCIONANDO!
			this.estrutura.put(chave, valor);
			return true;
		}
		return false;
	}

	public Object buscar(Object chave) {
		Object retorno = this.estrutura.get(chave);
		return retorno;
	}

	public void listar() {
		Enumeration<Object> keys = this.estrutura.keys();
		while (keys.hasMoreElements())
			System.out.println(this.estrutura.get(keys.nextElement()));
			}

	public Boolean remover(Object chave) {
		if (this.estrutura.containsKey(chave)) {
			this.estrutura.remove(chave);
		}
		return false;
	}

	public Boolean inserirBloco(Object[][] valores) {
		long temIni = System.currentTimeMillis();
		for (int i = 0; i < valores.length; i++) {
			this.inserir(valores[i][0], valores[i][1]);
		}
		long temFim = System.currentTimeMillis();
		System.out.println("Tempo total Inserção Bloco " + (temFim - temIni));
		return true;
	}

	// #################//
}