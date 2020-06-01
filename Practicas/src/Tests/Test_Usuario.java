package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;

import org.junit.jupiter.api.Test;

class Test_Usuario {
	
	Usuario user = new Usuario("nombre", "password", "email", false);

	@Test
	void test() {
		assertEquals("nombre", user.getName());
		assertEquals("password", user.getPassword());
		assertEquals("email", user.getEmail());
		assertFalse(user.isAdmin());
	}

}
