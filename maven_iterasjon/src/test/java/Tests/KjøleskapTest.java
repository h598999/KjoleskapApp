package Tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import Entiteter.Kjøleskap;
import Entiteter.Product;
import Entiteter.Vare;
import JPA.VareGetter;

public class KjøleskapTest {

	Kjøleskap kjøleskap = new Kjøleskap();

	public KjøleskapTest() {
		
	}
	
	@Test
	public void leggTilTest() throws URISyntaxException, IOException, InterruptedException {
		kjøleskap.leggTil(2030);
		Product vare = VareGetter.getVare(2030);
		Product vare1 = VareGetter.getVare(2031);
		assertEquals(0,kjøleskap.inneholder(vare));
		kjøleskap.leggTil(2030);
		
		kjøleskap.leggTil(2031);
		assertEquals(1,kjøleskap.inneholder(vare1));
	
	}
	
	@Test
	public void leggTilFlereTest() throws URISyntaxException, IOException, InterruptedException {
		kjøleskap.leggTilFlere(2030, 4);
		Product vare = VareGetter.getVare(2030);
		assertEquals(0,kjøleskap.inneholder(vare));
	
	}
	
	@Test
	public void fjernTest() throws URISyntaxException, IOException, InterruptedException {
		kjøleskap.leggTil(2030);
		kjøleskap.leggTil(2031);
		Product vare = VareGetter.getVare(2030);
		Product vare1 = VareGetter.getVare(2031);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.inneholder(vare)<0);
		assertTrue(kjøleskap.inneholder(vare1)==0);
		kjøleskap.leggTil(2030);
		kjøleskap.leggTil(2030);
		kjøleskap.leggTil(2030);
		kjøleskap.leggTilFlere(2030, 3);
		assertTrue(kjøleskap.getAntal()==2);
		assertTrue(kjøleskap.getEntry(vare).getValue()==6);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.getEntry(vare).getValue()==5);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.getEntry(vare).getValue()==4);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.getEntry(vare).getValue()==3);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.getEntry(vare).getValue()==2);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.getEntry(vare).getValue()==1);
		kjøleskap.fjern(vare);
		assertTrue(kjøleskap.inneholder(vare)<0);
		assertTrue(kjøleskap.getAntal()==1);
	}
	
	@Test
	public void fjernFlereTest() throws URISyntaxException, IOException, InterruptedException {
		kjøleskap.leggTilFlere(2030, 5);
		Product vare = VareGetter.getVare(2030);
		kjøleskap.fjernFlere(vare, 3);
		assertTrue(kjøleskap.getEntry(vare).getValue()==2);
		assertTrue(kjøleskap.getAntal()==1);
		assertEquals(2,kjøleskap.fjernFlere(vare, 3));
		assertTrue(kjøleskap.getAntal()==0);
		assertTrue(kjøleskap.inneholder(vare)<0);
		
	}

}
