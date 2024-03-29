package Tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import Entiteter.Kj�leskap;
import Entiteter.Product;
import HjelpeKlasser.BarCodeSaver;
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
	
	@Test
	public void leggTilTestBar() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTil("7610848337010");
		Product vare = VareGetter.getVare("7610848337010");
		Product vare1 = VareGetter.getVare("7610849657797");
		assertEquals(0,kj�leskap.inneholder(vare));
		kj�leskap.leggTil("7610848337010");
		
		kj�leskap.leggTil("7610849657797");
		assertEquals(1,kj�leskap.inneholder(vare1));
	
	}
	
	@Test
	public void leggTilFlereTestBar() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTilFlere("7610848337010", 4);
		Product vare = VareGetter.getVare("7610848337010");
		assertEquals(0,kj�leskap.inneholder(vare));
	
	}
	
	@Test
	public void fjernTestBar() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTil("7610848337010");
		kj�leskap.leggTil("7610849657797");
		Product vare = VareGetter.getVare("7610848337010");
		Product vare1 = VareGetter.getVare("7610849657797");
		kj�leskap.fjern(vare);
		assertTrue(kj�leskap.inneholder(vare)<0);
		assertTrue(kj�leskap.inneholder(vare1)==0);
		kj�leskap.leggTil("7610848337010");
		kj�leskap.leggTil("7610848337010");
		kj�leskap.leggTil("7610848337010");
		kj�leskap.leggTilFlere("7610848337010", 3);
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
	public void fjernFlereTestBar() throws URISyntaxException, IOException, InterruptedException {
		kj�leskap.leggTilFlere("7610848337010", 5);
		Product vare = VareGetter.getVare("7610848337010");
		kj�leskap.fjernFlere(vare, 3);
		assertTrue(kj�leskap.getEntry(vare).getValue()==2);
		assertTrue(kj�leskap.getAntal()==1);
		assertEquals(2,kj�leskap.fjernFlere(vare, 3));
		assertTrue(kj�leskap.getAntal()==0);
		assertTrue(kj�leskap.inneholder(vare)<0);
		
	}
	
	@Test
	public void leggTilFlereBar2() throws URISyntaxException, IOException, InterruptedException {
		BarCodeSaver saver = new BarCodeSaver();
		saver.add("7610848337010");
		saver.add("7610849657797");
		saver.add("7610848337010");
		saver.add("7610849657797");
		
		VareGetter.getVarer(kj�leskap, saver);
		
		//assertTrue(kj�leskap.inneholder(VareGetter.getVare("7610848337010"))>=0);
		//assertTrue(kj�leskap.inneholder(VareGetter.getVare("7610849657797"))==1);
		assertTrue(kj�leskap.getAntal()==2);
		assertTrue(kj�leskap.getAlle()[0].getValue()==2);
		assertTrue(kj�leskap.getAlle()[1].getValue()==2);
		
	}

}
