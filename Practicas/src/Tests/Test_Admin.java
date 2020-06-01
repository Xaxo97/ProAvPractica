package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

import Clases.*;

class Test_Admin extends TestCase{
	
	Administrador admin = new Administrador("nombre", "password", "email", true);

	@Test
	void test() {
		
	}
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
