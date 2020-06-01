package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

class Test_Revista extends TestCase{
	
	Revista magazine = new Revista("titulo", "editorial", "palabras", 50, "Bravo");

	@Test
	void test() {
		assertEquals("Bravo", magazine.getMagazine());
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
