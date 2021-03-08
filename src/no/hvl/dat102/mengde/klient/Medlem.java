package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem(String navn) {
		this.navn = navn;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndeks = -1;
	}

	public boolean passerTil(Medlem medlem2) {
		return (hobbyer.equals(medlem2.getHobbyer()));
	}

	public String getNavn() {
		return navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

}
