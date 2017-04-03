package arvore;

public class principal {
	public static void main(String[] args) {
		Arvore<Chave, Valor> arvore = new Arvore<Chave, Valor>();
		arvore.inserir(new Chave("Cidade"), new Valor("Aracaju"), Lado.Direito);
		arvore.inserir(new Chave("Cidade2"), new Valor("Aracaju2"), Lado.Meio);
		arvore.inserir(new Chave("Cidade3"), new Valor("Aracaju3"), Lado.Esquerdo);
	
	}
	
}
