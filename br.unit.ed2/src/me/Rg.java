package me;

public class Rg implements Comparable<Rg> {

	private String rg;

	public Rg() {}

	public Rg(String rg) {
		this.setRg(rg);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public int compareTo(Rg o) {
		if (o.getRg().compareTo(rg) < 0) {
			return -1;
		} else if (o.getRg().compareTo(rg) > 0) {
			return 1;
		} else if (o.getRg().compareTo(rg) == 0) {
			return o.getRg().compareTo(rg);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Rg: " + getRg();
	}

}
