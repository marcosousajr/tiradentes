package me2;

import java.util.Hashtable;
import java.util.List;

public class QueryHashTable {

	private Hashtable<Object, Object> estrutura;

	public QueryHashTable() {
		this.estrutura = new Hashtable<>();
	}

	public Boolean inserir(Object chave, Object valor) {
		if (!this.estrutura.containsKey(chave)) {
			this.estrutura.put(chave, valor);
		}
		return false;
	}

	public Object buscar(Object chave) {
		return this.estrutura.get(chave);
	}

	public void listar() {
		List<Object> keys = (List<Object>) this.estrutura.keys();
		for (Object o : keys) {
			this.estrutura.get(o);
		}
	}

	public Boolean remover(Object chave) {
		if (this.estrutura.containsKey(chave)) {
			this.estrutura.remove(chave);
		}
		return false;
	}
}
