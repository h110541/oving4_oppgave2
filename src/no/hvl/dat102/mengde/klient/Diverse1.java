package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;

// klientprogram for å teste klassen Medlem
public class Diverse1 {

	public static void main(String[] args) {
		String sep = "##########";

		Medlem m1 = new Medlem("Ole Olsen");
		Medlem m2 = new Medlem("Jens Jensen");

		MengdeADT<Hobby> m1Hob = m1.getHobbyer();
		MengdeADT<Hobby> m2Hob = m2.getHobbyer();

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.passerTil(m2));
		System.out.println(sep);

		m1Hob.leggTil(new Hobby("Asdf"));
		m2Hob.leggTil(new Hobby("Asdf"));

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.passerTil(m2));
		System.out.println(sep);

		m1Hob.leggTil(new Hobby("Qwer"));

		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.passerTil(m2));
		System.out.println(sep);
	}

}
