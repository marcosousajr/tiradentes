package me;

public class Aluno {

    private Rg rg;
    private String nome;
    
    public Aluno(){}
    
	public Aluno(Rg rg, String nome) {
		this.setRg(rg);
		this.setNome(nome);
	}
	public Rg getRg() {
		return rg;
	}
	public void setRg(Rg rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Aluno: "+getRg()+" - "+getNome();
	}

	
   
}
