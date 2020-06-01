package Tests;

import static org.junit.jupiter.api.Assertions.*;
import Clases.*;

import org.junit.jupiter.api.Test;

class Test_LibroPrestado {
	
	Libro book = new Libro("titulo", "editorial", "palabras", 50);
	LibroPrestado libro = new LibroPrestado(book, 2020, 05, 14);

	@Test
	void test() {
		assertEquals("titulo", libro.getBook().getTitle());
		assertEquals("editorial", libro.getBook().getEditorial());
		assertEquals("palabras", libro.getBook().getFirstWords());
		assertEquals(50, libro.getBook().getPages());
		assertEquals(2020, libro.getYear());
		assertEquals(05, libro.getMonth());
		assertEquals(14, libro.getDay());
	}

}
