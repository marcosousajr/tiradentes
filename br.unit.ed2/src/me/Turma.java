package me;

public class Turma {
    
    private CodTurma codTurma;
    private int nrMaxAlunos;
    private int nrAlunos;
    ArvoreBinBusca<Rg, Aluno> alunos;
    ArvoreBinBusca<Rg, Aluno> reservas;

    public Turma(CodTurma codTurma, int nrMaxAlunos) {

    	this.setCodTurma(codTurma);
		this.setNrMaxAlunos(nrMaxAlunos);
		this.setNrAlunos(0);
		this.alunos = new ArvoreBinBusca<Rg, Aluno>();
		this.reservas = new ArvoreBinBusca<Rg, Aluno>();
	}
	
    public CodTurma getCodTurma() {
		return codTurma;
	}
	public void setCodTurma(CodTurma codTurma) {
		this.codTurma = codTurma;
	}
	public int getNrMaxAlunos() {
		return nrMaxAlunos;
	}
	public void setNrMaxAlunos(int nrMaxAlunos) {
		this.nrMaxAlunos = nrMaxAlunos;
	}
	public int getNrAlunos() {
		return nrAlunos;
	}
	public void setNrAlunos(int nrAlunos) {
		this.nrAlunos = nrAlunos;
	}
	public ArvoreBinBusca<Rg, Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArvoreBinBusca<Rg, Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArvoreBinBusca<Rg, Aluno> getReservas() {
		return reservas;
	}
	public void setReservas(ArvoreBinBusca<Rg, Aluno> reservas) {
		this.reservas = reservas;
	}
    
	@Override
	public String toString() {
		return "\n Turma: "+getCodTurma()+" possui "+getNrAlunos()+" reservas de alunos.";
	}
	
	public boolean reservar(Aluno novoAl){
		if(this.nrAlunos < this.nrMaxAlunos){
			if(alunos.insert(novoAl.getRg(), novoAl)){
				this.setNrAlunos(nrAlunos + 1);
				return true;
			}
		}
		return false;
	}
	
	public boolean enfileirar(Aluno novoAl){
		if(reservas.insert(novoAl.getRg(), novoAl)){
			return true;
		}
		return false;
	}

	public boolean conferir(){
		if(this.nrAlunos < this.nrMaxAlunos && reservas.getRoot()!=null){
			if(alunos.insert(reservas.getRoot().getValue().getRg(), reservas.getRoot().getValue())){
				reservas.remove(reservas.getRoot().getKey());
				return true;
			}		
		}
		return false;
	}
	
	public boolean cancelar(Aluno novoAl){
		if(alunos.remove(novoAl.getRg())){
			this.setNrAlunos(getNrAlunos() - 1);
			while(conferir()){
				this.conferir();
			}
			return true;
		}else if(reservas.remove(novoAl.getRg())){
			return true;
		}
		return false;
	}
   
}
