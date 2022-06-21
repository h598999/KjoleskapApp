package Entiteter;

import java.io.IOException;
import java.net.URISyntaxException;

import HjelpeKlasser.TableEntry;
import JPA.VareGetter;

public class Kjøleskap {

	private int antall;
	private TableEntry<Product, Integer>[] varer;
	private final int STANDARD_VALUE = 15;
	
	@SuppressWarnings("unchecked")
	public Kjøleskap() {
		varer = new TableEntry[STANDARD_VALUE];
		antall = 0;
	}
	
	@SuppressWarnings("unchecked")
	public Kjøleskap(int size) {
		varer = new TableEntry[size];
		antall = 0;
	}
	
	public void leggTil(int id) throws URISyntaxException, IOException, InterruptedException {
		utvid();
		Product vare = VareGetter.getVare(id);
		int finnes = inneholder(vare);
		if (finnes>=0) {
			TableEntry<Product, Integer> temp = varer[finnes];
			varer[finnes] = new TableEntry<Product, Integer>(temp.getKey(), temp.getValue()+1);
		} else {
			varer[antall] = new TableEntry<Product,Integer>(vare,1);
			antall++;
		}
	}
	
	public void leggTilFlere(int id, int antall) throws URISyntaxException, IOException, InterruptedException {
		for (int i = 0; i<antall; i++) {
			leggTil(id);
		}
	}
	
	public boolean fjern(Product vare) {
		if (erTom())
			return false;
		boolean fjernet = false;
		int finnes = inneholder(vare);
		if (finnes>=0) {
			if (varer[finnes].getValue()==1) {
				varer[finnes] = null;
				for (int i = finnes; i<antall-1; i++) {
					varer[i] = varer[i+1];
				}
				fjernet = true;
				antall--;
			} else {
				int tidligereVerdi = varer[finnes].getValue();
				varer[finnes] = new TableEntry<Product, Integer>(varer[finnes].getKey(), tidligereVerdi-1);
				fjernet = true;
			}
		}
		return fjernet;
	}
	
	public int fjernFlere(Product vare, int antall) {
		int fjernet = 0;
		int finnes = inneholder(vare);
		int i = 0;
		while(finnes>=0&&i<antall) {
			fjern(vare);
			fjernet++;
			i++;
			finnes = inneholder(vare);
			
		}
		return fjernet;
	}
	
	
	public int inneholder(Product vare) {
		
		if (erTom())
		return -1;
		
		int funnet = -1;
		int i = 0;
		while(funnet<0&&i<antall) {
			if (varer[i].getKey().equals(vare)) {
				funnet = i;
			} else {
				i++;
			}
		}
		return funnet;
	}
	
	public TableEntry<Product, Integer> getEntry(Product vare) {
		int finnes = inneholder(vare);
		if (finnes>=0) {
		TableEntry<Product,Integer> temp = varer[finnes];
		return temp;
		}
		return null;
		
	}
	
	private void utvid() {
		if (varer.length-1==antall) {
			@SuppressWarnings("unchecked")
			TableEntry<Product, Integer>[] temp = new TableEntry[(varer.length)*2];
			for (int i = 0; i<antall; i++) {
				temp[i] = varer[i];
			}
			varer = temp;
		}
	}
	public boolean erTom() {
		return antall==0;
	}
	
	public int getAntal() {
		return antall;
	}
	
	public TableEntry<Product,Integer>[] getAlle(){
		return varer;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i<antall; i++) {
			str+= varer[i].toString() + "\n";
		}
		return str;
	}
	
}
