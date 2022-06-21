package HjelpeKlasser;

public class BarCodeSaver {
	
	private TableEntry<String,Integer>[] barCodes;
	private int antall;
	private static final int STANDARD_VALUE = 50;
	
	@SuppressWarnings("unchecked")
	public BarCodeSaver() {
		barCodes = new TableEntry[STANDARD_VALUE];
		antall = 0;
	}

	
	public void add(String barCode) {
		int posisjon = inneholder(barCode);
		if (posisjon>=0) {
			int temp = barCodes[posisjon].getValue();
			barCodes[posisjon] = new TableEntry<String,Integer>(barCode, temp+1);
		} else {
			barCodes[antall] = new TableEntry<String,Integer>(barCode,1);
			antall++;
		}
	}
	
	public int inneholder(String barCode) {
		int inneholder = -1;
		int i = 0;
		while(i<antall&&inneholder<0) {
			if (barCodes[i].getKey().equals(barCode))
				inneholder = i;
			else 
				i++;
		}
		return inneholder;
		
	}
	
	
	public TableEntry<String, Integer>[] getBarCodes() {
		return barCodes;
	}

	public void setBarCodes(TableEntry<String, Integer>[] barCodes) {
		this.barCodes = barCodes;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}
	

}
