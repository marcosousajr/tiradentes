package prova1;

public class Automovel extends Produto{
	
	private Comprador comp;
	ArvoreBinBusca<NumChass, Automovel> avenda;
    ArvoreBinBusca<NumChass, Automovel> vendido;
	
    public Automovel(){}
    
	public Automovel(String nome, int anoFab, NumChass numChass, Categoria categ, Comprador comp,
			ArvoreBinBusca<NumChass, Automovel> avenda, ArvoreBinBusca<NumChass, Automovel> vendido) {
		this.setNome(nome);
		this.setAnoFab(anoFab);
		this.setNumChass(numChass);
		this.setCateg(categ);
		this.setComp(comp);
		this.avenda = new ArvoreBinBusca<NumChass,Automovel>();
		this.vendido = new ArvoreBinBusca<NumChass,Automovel>();
	}

	public ArvoreBinBusca<NumChass, Automovel> getAvenda() {
		return avenda;
	}
	public void setAvenda(ArvoreBinBusca<NumChass, Automovel> avenda) {
		this.avenda = avenda;
	}
	public ArvoreBinBusca<NumChass, Automovel> getVendido() {
		return vendido;
	}
	public void setVendido(ArvoreBinBusca<NumChass, Automovel> vendido) {
		this.vendido = vendido;
	}

}
