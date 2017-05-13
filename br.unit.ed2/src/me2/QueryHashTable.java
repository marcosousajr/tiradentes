package me2;

import java.util.Enumeration;
import java.util.Hashtable;

public class QueryHashTable {

	private Hashtable<Object, Object> estrutura;

	public QueryHashTable() {
		this.estrutura = new Hashtable<>();
	}

	public Boolean inserir(Object chave, Object valor) {
		long temIni = System.currentTimeMillis();
		
		if (!this.estrutura.containsKey(chave)) {
			this.estrutura.put(chave, valor);
		}
		
		long temFim = System.currentTimeMillis();
		
		System.out.println("Tempo total Inserir " + (temFim - temIni));
		
		return true;
	}

	public Object buscar(Object chave) {
		long temIni = System.currentTimeMillis();
		
		Object retorno = this.estrutura.get(chave);
		
		long temFim = System.currentTimeMillis();
		
		System.out.println("Tempo total Buscar " + (temFim - temIni));
		
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
}