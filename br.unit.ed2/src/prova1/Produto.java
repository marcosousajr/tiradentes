package prova1;

public class Produto {
	private String nome;
	private int anoFab;
	private NumChass numChass;
	private Categoria categ;
	private Comprador comp;
	ArvoreBinBusca<NumChass, Produto> avenda;
    ArvoreBinBusca<NumChass, Produto> vendido;
    
public Produto(){}
    
    public Produto(String nome, int anoFab, NumChass numChass, Categoria categ) {
		this.setNome(nome);
		this.setAnoFab(anoFab);
		this.setNumChass(numChass);
		this.setCateg(categ);
	}

    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoFab() {
		return anoFab;
	}
	public void setAnoFab(int anoFab) {
		this.anoFab = anoFab;
	}
	public NumChass getNumChass() {
		return numChass;
	}
	public void setNumChass(NumChass numChass) {
		this.numChass = numChass;
	}
	public Categoria getCateg() {
		return categ;
	}
	public void setCateg(Categoria categ) {
		this.categ = categ;
	}
	public Comprador getComp() {
		return comp;
	}
	public void setComp(Comprador comp) {
		this.comp = comp;
	}
}
