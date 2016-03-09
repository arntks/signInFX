package tester;

import javafx.scene.image.Image;
import klasser.SkiltFart;
import klasser.Skilt_med_tekst;
import klasser.Skilt_uten_tekst;

public class testSkilt extends junit.framework.TestCase {
	
	public void testSkiltFart(){
		SkiltFart skilt = new SkiltFart(110);
		assertEquals (110, skilt.getSkiltnr());
		assertEquals (1, skilt.getSkiltgruppe());
	}

	public void testSkilt_med_tekst(){
		Skilt_med_tekst skilt = new Skilt_med_tekst(1, "Svært stor elgfare");
		assertEquals (1, skilt.getSkiltnr());
		assertEquals (2, skilt.getSkiltgruppe());
		assertEquals ("Svært stor elgfare", skilt.hentTekst());
	}
	
	public void testSkilt_uten_tekst(){
		Skilt_uten_tekst skilt = new Skilt_uten_tekst(8);
		assertEquals (8, skilt.getSkiltnr());
		assertEquals (3, skilt.getSkiltgruppe());
	}
	
}
