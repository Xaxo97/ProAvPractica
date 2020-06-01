package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

class Test_Novela extends TestCase{
	
	Novela novel = new Novela("titulo", "editorial", "palabras", 50, "Aventuras");

	@Test
	void test() {
		assertEquals("Aventuras", novel.getType());
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
