package no.hvl.dat102.mengde.tabell;

import no.hvl.dat102.mengde.adt.MengdeADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;

class TabellMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<String> reset() {
		return new TabellMengde<String>();
	}

}
