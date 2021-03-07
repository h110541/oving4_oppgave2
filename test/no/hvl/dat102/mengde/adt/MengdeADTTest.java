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
	private String[] data3 = { "en", "tre", "fem", "sju", "ni", "tolv" };

	protected abstract MengdeADT<String> reset();

	@BeforeEach
	public void setup() {
		m1 = reset();
		m2 = reset();
		m3 = reset();
		fasitMengde = reset();

		for (String s : data1)
			m1.leggTil(s);

		for (String s : data2)
			m2.leggTil(s);

		for (String s : data3)
			m3.leggTil(s);
	}

	@Test
	public void testUnion1() {
		String[] fasitData = { "en", "to", "tre", "fire", "fem", "sju", "ni", "tolv" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.union(m3);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testUnion2() {
		String[] fasitData = { "en", "to", "tre", "fire", "fem", "seks", "sju", "aatte", "ni", "ti" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.union(m2);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testSnitt1() {
		String[] fasitData = { "en", "tre", "fem" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.snitt(m3);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testSnitt2() {
		MengdeADT<String> resultat = m1.snitt(m2);

		assertTrue(resultat.equals(fasitMengde));
		assertTrue(resultat.erTom());
	}

	@Test
	public void testDifferens1() {
		String[] fasitData = { "to", "fire" };

		for (String s : fasitData)
			fasitMengde.leggTil(s);

		MengdeADT<String> resultat = m1.differens(m3);

		assertTrue(resultat.equals(fasitMengde));
	}

	@Test
	public void testDifferens2() {
		MengdeADT<String> resultat = m1.differens(m2);

		assertTrue(resultat.equals(m1));
	}

}
