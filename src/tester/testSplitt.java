package tester;

import java.io.File;
import klasser.Splitt;

public class testSplitt extends junit.framework.TestCase{
	
	public void testgetFile(){
		Splitt string = new Splitt("pakkeTest.txt");
		File fil = new File ("pakkeTest.txt");
		assertEquals(fil, string.getFile());
		
		string.dele(fil);
		assertNotNull(string.getSkiltGruppe().size());
	}
}
