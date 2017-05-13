package prova1;

public class NoBinBusca<Chave extends Comparable<Chave>, Valor> implements Comparable<Chave> {

	private NoBinBusca<Chave, Valor> root;
	private NoBinBusca<Chave, Valor> left;
	private NoBinBusca<Chave, Valor> right;
	private Valor value;
	private Chave key;
	
	
	public NoBinBusca(Chave key, Valor value) {
		this.setRoot(null);
		this.setLeft(null);
		this.setRight(null);
		this.setValue(value);
		this.setKey(key);
	}
	
	public NoBinBusca(Valor valor) {
		this.setRoot(null);
		this.setLeft(null);
		this.setRight(null);
		this.setValue(value);
		this.setKey(null);
	}

	public NoBinBusca<Chave, Valor> getRoot() {
		return root;
	}

	public void setRoot(NoBinBusca<Chave, Valor> root) {
		this.root = root;
	}

	public NoBinBusca<Chave, Valor> getLeft() {
		return left;
	}

	public void setLeft(NoBinBusca<Chave, Valor> left) {
		this.left = left;
	}

	public NoBinBusca<Chave, Valor> getRight() {
		return right;
	}

	public void setRight(NoBinBusca<Chave, Valor> right) {
		this.right = right;
	}

	public Valor getValue() {
		return value;
	}

	public void setValue(Valor value) {
		this.value = value;
	}

	public Chave getKey() {
		return key;
	}

	public void setKey(Chave key) {
		this.key = key;
	}

	@Override
	public int compareTo(Chave o) {
		if (this.getKey().compareTo(o) < 0) {
			return -1;
		} else if (this.getKey().compareTo(o) > 0) {
			return 1;
		} else if (this.getKey().compareTo(o) == 0) {
			return this.getKey().compareTo(o);
		} else {
			return 0;
		}
	}
}
