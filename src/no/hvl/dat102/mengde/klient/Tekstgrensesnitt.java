package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

// klientprogram for å teste klassen Datakontakt
public class Tekstgrensesnitt {

	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		Datakontakt arkiv = new Datakontakt();

		leggTilMedlemmer(arkiv);

		// Leser inn 1 person fra bruker
		arkiv.leggTilMedlem(lesMedlem());

		finnPartnere(arkiv);
		skrivParListe(arkiv);

		// Tilbakestiller statusIndeks for Ole Olsen (og Trine Trinesen)
		arkiv.tilbakestillStatusIndeks("Ole Olsen");
		skrivParListe(arkiv);
	}

	public static void leggTilMedlemmer(Datakontakt arkiv) {
		Medlem m1 = new Medlem("Ole Olsen");
		m1.leggTilHobby("asdf");
		m1.leggTilHobby("zxcv");
		arkiv.leggTilMedlem(m1);

		Medlem m2 = new Medlem("Jens Jensen");
		m2.leggTilHobby("qwer");
		arkiv.leggTilMedlem(m2);

		Medlem m3 = new Medlem("Hans Hansen");
		m3.leggTilHobby("asdf");
		arkiv.leggTilMedlem(m3);

		Medlem m4 = new Medlem("Lene Lenesen");
		m4.leggTilHobby("qwer");
		arkiv.leggTilMedlem(m4);

		Medlem m5 = new Medlem("Trine Trinesen");
		m5.leggTilHobby("zxcv");
		m5.leggTilHobby("asdf");
		arkiv.leggTilMedlem(m5);

	}

	public static void finnPartnere(Datakontakt arkiv) {
		int antall = arkiv.getAntall();
		Medlem[] medlemTab = arkiv.getMedlemTab();

		for (int i = 0; i < antall; i++) {
			if (medlemTab[i].getStatusIndeks() == -1) {
				String navn = medlemTab[i].getNavn();
				arkiv.finnPartnerFor(navn);
			}
		}
	}

	public static void skrivHobbyListe(Medlem m) {
		System.out.println(m.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		int antall = arkiv.getAntall();
		Medlem[] medlemTab = arkiv.getMedlemTab();
		int antallPar = 0;

		System.out.println("\nPARNAVN\t\t\t\t\tHOBBYER");

		for (int indeks1 = 0; indeks1 < antall; indeks1++) {
			int indeks2 = medlemTab[indeks1].getStatusIndeks();

			if (indeks2 != -1 && indeks2 > indeks1) {
				Medlem m1 = medlemTab[indeks1];
				Medlem m2 = medlemTab[indeks2];
				antallPar++;

				System.out.format("%s og %s\t\t%s%n", m1.getNavn(), m2.getNavn(), m1.getHobbyer());
			}
		}

		System.out.println("Antall par funnet: " + antallPar);
	}

	public static Medlem lesMedlem() {
		System.out.print("Oppgi navn: ");
		String navn = kb.nextLine();
		System.out.print("Oppgi hobbyer (separert med mellomrom): ");
		String hobbyer = kb.nextLine();

		Medlem nyMedlem = new Medlem(navn);

		for (String hobby : hobbyer.split("\\s+")) {
			nyMedlem.leggTilHobby(hobby);
		}

		return nyMedlem;
	}

}
