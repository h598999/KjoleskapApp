package Tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import Entiteter.Kj�leskap;
import Entiteter.Product;
import Entiteter.Vare;
import JPA.VareGetter;

public class Kj�leskapTest {

	Kj�leskap kj�leskap = new Kj�leskap();

	public Kj�leskapTest() {
		
	}
	
	@Test
	public void leggTilTest() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTil(2030);
		Product vare = VareGetter.getVare(2030);
		Product vare1 = VareGetter.getVare(2031);
		assertEquals(0,kj�leskap.inneholder(vare));
		kj�leskap.leggTil(2030);
		
		kj�leskap.leggTil(2031);
		assertEquals(1,kj�leskap.inneholder(vare1));
	
	}
	
	@Test
	public void leggTilFlereTest() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTilFlere(2030, 4);
		Product vare = VareGetter.getVare(2030);
		assertEquals(0,kj�leskap.inneholder(vare));
	
	}
	
	@Test
	public void fjernTest() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTil(2030);
		kj�leskap.leggTil(2031);
		Product vare = VareGetter.getVare(2030);
		Product vare1 = VareGetter.getVare(2031);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.inneholder(vare)<0);
		assertTrue(kj�leskap.inneholder(vare1)==0);
		kj�leskap.leggTil(2030);
		kj�leskap.leggTil(2030);
		kj�leskap.leggTil(2030);
		kj�leskap.leggTilFlere(2030, 3);
		assertTrue(kj�leskap.getAntal()==2);
		assertTrue(kj�leskap.getEntry(vare).getValue()==6);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.getEntry(vare).getValue()==5);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.getEntry(vare).getValue()==4);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.getEntry(vare).getValue()==3);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.getEntry(vare).getValue()==2);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.getEntry(vare).getValue()==1);
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.inneholder(vare)<0);
		assertTrue(kj�leskap.getAntal()==1);
	}
	
	@Test
	public void fjernFlereTest() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTilFlere(2030, 5);
		Product vare = VareGetter.getVare(2030);
		kj�leskap.fjernFlere(vare, 3);
		assertTrue(kj�leskap.getEntry(vare).getValue()==2);
		assertTrue(kj�leskap.getAntal()==1);
		assertEquals(2,kj�leskap.fjernFlere(vare, 3));
		assertTrue(kj�leskap.getAntal()==0);
		assertTrue(kj�leskap.inneholder(vare)<0);
		
	}

}
