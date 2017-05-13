package prova1;


public class Comprador {

	private Cpf cpf;
    private String nome;
    
    public Comprador(){}
    
	public Comprador(Cpf Cpf, String nome) {
		this.setCpf(Cpf);
		this.setNome(nome);
	}
	public Cpf getCpf() {
		return cpf;
	}
	public void setCpf(Cpf Cpf) {
		this.cpf = Cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Comprador: "+getCpf()+" - "+getNome();
	}
}
