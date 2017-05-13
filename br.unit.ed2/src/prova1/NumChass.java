package prova1;


public class NumChass implements Comparable<NumChass> {

private String numChass;
	
	public NumChass(){}
	
	public NumChass(String numChass) {
		this.setNumChass(numChass);
	}
	
	public String getNumChass() {
		return numChass;
	}
	public void setNumChass(String numChass) {
		this.numChass = numChass;
	}

	@Override
	public int compareTo(NumChass o) {
		if (o.getNumChass().compareTo(numChass) < 0) {
			return -1;
		} else if (o.getNumChass().compareTo(numChass) > 0) {
			return 1;
		} else if (o.getNumChass().compareTo(numChass) == 0) {
			return o.getNumChass().compareTo(numChass);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "numChass: " + getNumChass();
	}

}
