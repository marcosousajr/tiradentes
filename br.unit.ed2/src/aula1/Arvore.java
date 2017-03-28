package aula1;


public class Arvore<chave, valor> {
	
	 private No raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	private No inserir(Chave chave,Valor valor, No pai, Lado lado) {
		No novoNo = new No ();
        
        if(pai == null) {
            pai = novoNo;
        } else {
            novoNo.setPai(null);
            
            if(novoNo.getValor()) {
            	novoNo.setEsquerdo(novoNo);
            } else {
                if(valor > novoNo.getValor()) {
                	novoNo.setDireito(novoNo);
                }
            }
        }
        
        return novoNo;
    }


	
	
}
