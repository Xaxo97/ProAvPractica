package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;

import org.junit.jupiter.api.Test;

class Test_Biblioteca {
	
	Biblioteca example = new Biblioteca (10, 20);

	@Test
	void test() {
		assertEquals(10, example.gethOpens());
		assertEquals(20, example.gethClose());
	}

}
