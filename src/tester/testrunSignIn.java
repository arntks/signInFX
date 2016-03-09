package tester;

import java.io.ByteArrayInputStream;
import klasser.runSignIn;

public class testrunSignIn extends junit.framework.TestCase {

	public void testlesKort(){
		System.out.println("test kjører");
		ByteArrayInputStream in = new ByteArrayInputStream("023106447".getBytes());
		System.setIn(in);

		String nr = runSignIn.lesKort();
		assertEquals("023106447", nr);
	}

}
