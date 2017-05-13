package prova1;

public class Motocicleta extends Produto{
	ArvoreBinBusca<NumChass, Motocicleta> avenda;
    ArvoreBinBusca<NumChass, Motocicleta> vendido;
    
    public Motocicleta(){}
    
    public Motocicleta(String nome, int anoFab, NumChass numChass, Categoria categ, Comprador comp,
			ArvoreBinBusca<NumChass, Motocicleta> avenda, ArvoreBinBusca<NumChass, Motocicleta> vendido) {
		this.setNome(nome);
		this.setAnoFab(anoFab);
		this.setNumChass(numChass);
		this.setCateg(categ);
		this.setComp(comp);
		this.avenda = new ArvoreBinBusca<NumChass,Motocicleta>();
		this.vendido = new ArvoreBinBusca<NumChass,Motocicleta>();
	}

	public ArvoreBinBusca<NumChass, Motocicleta> getAvenda() {
		return avenda;
	}
	public void setAvenda(ArvoreBinBusca<NumChass, Motocicleta> avenda) {
		this.avenda = avenda;
	}
	public ArvoreBinBusca<NumChass, Motocicleta> getVendido() {
		return vendido;
	}
	public void setVendido(ArvoreBinBusca<NumChass, Motocicleta> vendido) {
		this.vendido = vendido;
	}

}
