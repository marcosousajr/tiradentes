package aula1;

public class Arvore<chave, valor> {
	
	 private No raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	private No inserir(Chave chave,Valor valor) {
        No novoNo = new No<Chave, Valor>();
        
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else {
            novoNo.setPai(null);
            
            if(valor < novoNo.getValor()) {
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
