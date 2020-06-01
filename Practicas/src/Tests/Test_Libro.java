package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;

import org.junit.jupiter.api.Test;

class Test_Libro {
	
	Libro book = new Libro("titulo", "editorial", "palabras", 50);

	@Test
	void test() {
		assertEquals("titulo", book.getTitle());
		assertEquals("editorial", book.getEditorial());
		assertEquals("palabras", book.getFirstWords());
		assertEquals(50, book.getPages());
	}

}
