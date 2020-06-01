package Clases;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.math.*;
import java.util.Scanner;

public class Biblioteca implements PrintNovela, PrintRevista{

	int hOpens, hClose;
	ArrayList<ArrayList<Libro>> books;
	ArrayList<Usuario> users;

	public Biblioteca(int hOpens, int hClose) {
		this.hOpens = hOpens;
		this.hClose = hClose;
		users = new ArrayList<Usuario>();
		books = new ArrayList<ArrayList<Libro>>();
		for (int i = 0; i < 3; i++)
			books.add(new ArrayList<Libro>());
	}

	public void addUser(Usuario value) {
		users.add(value);
	}

	public boolean findUser(String value) {
		if (users.isEmpty()) {
			return true;
		} else {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getName().equals(value)) {
					return false;
				}
			}
		}
		return true;
	}

	public Usuario searchUser(String value) {
		if (users.isEmpty()) {
			return null;
		} else {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getName().equals(value)) {
					return users.get(i);
				}
			}
		}
		return null;
	}

	public Libro searchByTitle(String value) {
		if (books.isEmpty()) {
			return null;
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < books.get(i).size(); j++) {
					if (value.equals(books.get(i).get(j).getTitle())) {
						return books.get(i).get(j);
					}
				}
			}
		}
		return null;
	}

	public void addBook(Libro value) {
		Libro aux;
		aux = searchByTitle(value.getTitle());
		if (aux == null) {
			if (value.getiAm() == "Novel") {

				books.get(1).add(value);

			} else if (value.getiAm() == "Magazine") {

				books.get(2).add(value);

			} else {

				books.get(0).add(value);

			}
		} else {
			searchByTitle(value.getTitle()).addUnits();
		}
	}

	public void addBook(String title, String editorial, String firstwords, int pages, String tipo) {
		Libro newLibro;
		Libro aux;
		aux = searchByTitle(title);
		if (aux == null) {
			if (tipo.equals("Novel")) {
				Novela novel;
				novel = Novela.getInstancia(title, editorial, firstwords, pages, tipo);
				newLibro = novel;
				books.get(1).add(newLibro);
			} else if (tipo.equals("Magazine")) {
				newLibro = new Revista(title, editorial, firstwords, pages, null);
				books.get(2).add(newLibro);
			} else {
				newLibro = new Libro(title, editorial, firstwords, pages);
				books.get(0).add(newLibro);
			}
		} else {
			searchByTitle(title).addUnits();
			;
		}
	}

	public void removeBook(String title, int op) {
		// Esto es para que funcione en los idiomas que tenga el programa
		String lang, country;
		lang = "es";
		country = "ES";
		Locale l = new Locale(lang, country);
		ResourceBundle res = ResourceBundle.getBundle("Main/Bundle", l);
		if (op == 1) {
			lang = "en";
			country = "EN";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_en_EN", l);
		} else if (op == 2) {
			lang = "es";
			country = "ES";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_es_ES", l);
		}

		if (searchByTitle(title) != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < books.get(i).size(); j++) {
					if (title.equals(books.get(i).get(j).getTitle())) {
						books.get(i).remove(j);
						System.out.println(res.getString("remove"));
					}
				}
			}
		} else {
			System.out.println(res.getString("removeFail"));
		}
	}

	public void printBooks(int op) throws InterruptedException {

		// Esto es para que funcione en los idiomas que tenga el programa
		String lang, country;
		lang = "es";
		country = "ES";
		Locale l = new Locale(lang, country);
		ResourceBundle res = ResourceBundle.getBundle("Main/Bundle", l);
		if (op == 1) {
			lang = "en";
			country = "EN";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_en_EN", l);
		} else if (op == 2) {
			lang = "es";
			country = "ES";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_es_ES", l);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < books.get(i).size(); j++) {
				System.out.println(res.getString("tittle") + books.get(i).get(j).getTitle());
				Thread.sleep(1000);
				System.out.println(res.getString("editorial") + books.get(i).get(j).getEditorial());
				Thread.sleep(1000);
				System.out.println(res.getString("pages") + books.get(i).get(j).getPages());
				Thread.sleep(1000);
				if(books.get(i).get(j).getiAm().equals("Magazine")) {
					print();
				}
				else if(books.get(i).get(j).getiAm().equals("Novel")) {
					printNovela();
				}

			}
		}
	}

	public void Percent(int op) throws InterruptedException {
		// Esto es para que funcione en los idiomas que tenga el programa
		String lang, country;
		lang = "es";
		country = "ES";
		Locale l = new Locale(lang, country);
		ResourceBundle res = ResourceBundle.getBundle("Main/Bundle", l);
		if (op == 1) {
			lang = "en";
			country = "EN";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_en_EN", l);
		} else if (op == 2) {
			lang = "es";
			country = "ES";

			l = new Locale(lang, country);
			res = ResourceBundle.getBundle("Main/Bundle_es_ES", l);
		}

		int aux = 0;
		int novela = 0;
		int revista = 0;
		int libro = 0;

		// Aqui recorro todo el array de libros para saber cuantos libros tengo en total
		try {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < books.get(i).size(); j++) {
					if (i == 0) {
						libro++;
					} else if (i == 1) {
						novela++;
					} else if (i == 2) {
						revista++;
					}
					aux++;
				}
			}
		}catch (Exception e) {
			System.out.println("Something whent wrong.");
		}

		// Imprimpe por pantalla los porcentajes de los diferentes libros en la
		// biblioteca
		System.out.println(
				res.getString("percentage") + res.getString("book") + res.getString("is") + ((libro / aux) * 100) + "%");
		Thread.sleep(1000);
		System.out.println(
				res.getString("percentage") + res.getString("novel") + res.getString("is") + ((novela / aux) * 100) + "%");
		Thread.sleep(1000);
		System.out.println(res.getString("percentage") + res.getString("magazine") + res.getString("is")
				+ ((revista / aux) * 100) + "%");
		Thread.sleep(1000);

		// Imprime por pantalla el ripo libro con menor y mayor cantidad de libros;

		if (Math.min(libro, revista) == libro) {
			if (Math.min(libro, novela) == libro) {
				System.out.println(res.getString("min") + res.getString("book"));
			} else {
				System.out.println(res.getString("min") + res.getString("novel"));
			}
		} else {
			if (Math.min(revista, novela) == libro) {
				System.out.println(res.getString("min") + res.getString("magazine"));
			} else {
				System.out.println(res.getString("min") + res.getString("novel"));
			}
		}

		if (Math.max(libro, revista) == libro) {
			if (Math.max(libro, novela) == libro) {
				System.out.println(res.getString("max") + res.getString("book"));
			} else {
				System.out.println(res.getString("max") + res.getString("novel"));
			}
		} else {
			if (Math.max(revista, novela) == libro) {
				System.out.println(res.getString("max") + res.getString("magazine"));
			} else {
				System.out.println(res.getString("max") + res.getString("novel"));
			}
		}

	}

	public int gethOpens() {
		return hOpens;
	}

	public void sethOpens(int hOpens) {
		this.hOpens = hOpens;
	}

	public int gethClose() {
		return hClose;
	}

	public void sethClose(int hClose) {
		this.hClose = hClose;
	}

	public ArrayList<ArrayList<Libro>> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<ArrayList<Libro>> books) {
		this.books = books;
	}

	public ArrayList<Usuario> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Usuario> users) {
		this.users = users;
	}

	@Override
	public void print() {
		System.out.println("Magazine");
	}

	@Override
	public void printNovela() {
		System.out.println("Novel");
	}

}
