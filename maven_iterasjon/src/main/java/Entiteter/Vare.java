package Entiteter;

import java.util.Objects;

public class Vare {
	
	private int id;
	private String barcode;
	
	public Vare(int id, String barcode) {
		this.id = id;
		this.barcode = barcode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barcode, id);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vare other = (Vare) obj;
		return Objects.equals(barcode, other.barcode) && id == other.id;
	}
	
	public String toString() {
		return id + " " + barcode;
	}
	
	

}
