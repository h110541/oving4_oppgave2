package no.hvl.dat102.mengde.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public abstract class MengdeADTTest {

	private MengdeADT<String> m1;
	private MengdeADT<String> m2;
	private MengdeADT<String> m3;
	private MengdeADT<String> fasitMengde;

	private String[] data1 = { "en", "to", "tre", "fire", "fem" };
	private String[] data2 = { "seks", "sju", "aatte", "ni", "ti" };
	private String[] data3 = { "en", "tre", "fem", "sju", "ni" };

	protected abstract MengdeADT<String> reset();

	@BeforeEach
	public void setup() {
		m1 = reset();
		m2 = reset();
		m3 = reset();
		fasitMengde = reset();
	}

	@Test
	public void testUnion1() {
		for (String s : data1)
			m1.leggTil(s);

		for (String s : data3)
			m2.leggTil(s);

		String[] fasitData = { "en", "to", "tre", "fire", "fem", "sju", "ni" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.union(m2);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testUnion2() {
		for (String s : data1)
			m1.leggTil(s);

		for (String s : data2)
			m2.leggTil(s);

		String[] fasitData = { "en", "to", "tre", "fire", "fem", "seks", "sju", "aatte", "ni", "ti" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.union(m2);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testSnitt() {
		fail("Not yet implemented");
	}

	@Test
	public void testDifferens() {
		fail("Not yet implemented");
	}

}
