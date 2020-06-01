package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import Clases.*;

public class main {

	public static void main(String[] args) throws InterruptedException {

		// Iniciamos la internacionalizacion

		Scanner sn = new Scanner(System.in);

		String lang = "es";
		String country = "ES";

		Locale l = new Locale(lang, country);
		ResourceBundle res = ResourceBundle.getBundle("Main/Bundle", l);

		System.out.println("**Choose your language** ");
		System.out.println(" 1-English(EN)\t" + " 2-Español(ES)");

		int op;
		op = sn.nextInt();

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

		// Iniciamos todas las clases y variables importantes que usaremos

		Biblioteca library = new Biblioteca(10, 22);
		library.addUser(new Usuario("Nacho", "contrasena", "email@gmail.com", false));
		library.addBook("Libro", "editorial", "firstwords", 20, "book");

		String userName = "Nacho";
		String userPassword = "contrasena";

		// Ahora comenzamos con el login y el registro de usuarios

		char option;

		System.out.println(res.getString("options"));
		System.out.println("a." + res.getString("register"));
		System.out.println("b." + res.getString("login"));

		option = sn.next().charAt(0);

		if (option == 'a') {
			String name;
			String pass;
			String email;
			String admin;
			boolean aux = false;

			while (aux == false) {
				System.out.println(res.getString("name"));
				name = sn.next();
				aux = library.findUser(name);
				if (library.findUser(name)) {
					System.out.println(res.getString("password"));
					pass = sn.next();
					System.out.println(res.getString("email"));
					email = sn.next();
					System.out.println(res.getString("admin"));
					admin = sn.next();
					if (admin.equals("admin")) {
						System.out.println("Hola");
						userName = name;
						userPassword = pass;
						library.addUser(new Administrador(name, pass, email, true));
						aux = true;
					} else {
						userName = name;
						userPassword = pass;
						library.addUser(new Usuario(name, pass, email, false));
						aux = true;
					}

				} else {
					System.out.println(res.getString("regError"));
				}
			}

		} else if (option == 'b') {
			boolean aux = true;
			while (aux) {
				System.out.println(res.getString("name"));
				userName = sn.next();
				if (library.findUser(userName) == false) {
					System.out.println(res.getString("password"));
					userPassword = sn.next();
					if (library.searchUser(userName).getPassword().equals(userPassword)) {
						System.out.println(res.getString("logged"));
						aux = false;
					} else {
						aux = true;
						System.out.println(res.getString("wrongPass"));
					}
				} else {
					System.out.println(res.getString("wrongUser"));
				}

			}
		}

		char loop = 'z';

		while (loop != 'e') {

			if (library.searchUser(userName).isAdmin()) {

				System.out.println(res.getString("options"));
				System.out.println("a. " + res.getString("addLibrary"));
				System.out.println("b. " + res.getString("remLibrary"));
				System.out.println("c. " + res.getString("printBooks"));
				System.out.println("d. " + res.getString("howMany"));
				System.out.println("e. " + res.getString("exit1"));
				loop = sn.next().charAt(0);

				if (loop == 'a') {
					String type = "holi";
					String title = "null";
					String editorial = "null";
					String firstWords = "null";
					int pages = 0;
					System.out.println(res.getString("wichAdd"));
					System.out.println("book");
					System.out.println("novel");
					System.out.println("magazine");

					type = sn.next();
					if (type.equals("book") || type.equals("novel") || type.equals("magazine")) {
						System.out.println(res.getString("tittle") + "\n" + res.getString("editorial") + "\n"
								+ res.getString("firstWords") + "\n" + res.getString("pages"));
						title = sn.next();
						editorial = sn.next();
						firstWords = sn.next();
						pages = sn.nextInt();
					}

					if (type.equals("book")) {

						library.addBook(new Libro(title, editorial, firstWords, pages));

					} else if (type.equals("novel")) {
						System.out.println(res.getString("wichNov"));
						String nov = sn.next();
						Novela novelita;
						novelita = Novela.getInstancia(title, editorial, firstWords, pages, nov);
						library.addBook(novelita);

					} else if (type.equals("magazine")) {
						System.out.println(res.getString("wichMag"));
						String mag = sn.next();
						library.addBook(new Revista(title, editorial, firstWords, pages, mag));

					} else {
						System.out.println(res.getString("error"));
					}

					loop = 'z';

				} else if (loop == 'b') {
					System.out.println(res.getString("wichRem"));
					String aux = sn.next();
					library.removeBook(aux, op);
					loop = 'z';
				} else if (loop == 'c') {
					library.printBooks(op);
					loop = 'z';
				} else if (loop == 'd') {
					library.Percent(op);
					loop = 'z';
				} else if (loop == 'e') {
					System.out.println(res.getString("exit"));
				} else {
					System.out.println(res.getString("error"));
					loop = 'z';
				}

			}else {

					System.out.println(res.getString("options"));
					System.out.println("a. " + res.getString("addLibrary"));
					System.out.println("b. " + res.getString("remLibrary"));
					System.out.println("c. " + res.getString("printBooks"));
					System.out.println("e. " + res.getString("exit"));
					
					loop = sn.next().charAt(0);
					
					if(loop == 'a') {
						System.out.println(res.getString("addUser"));
						String auxTitulo = sn.next();
						if(library.searchByTitle(auxTitulo)!=null) {
							library.searchUser(userName).addBook(new LibroPrestado(library.searchByTitle(auxTitulo),24, 12, 2004));
						}else {
							System.out.println(res.getString("error"));
						}
					}else if( loop == 'b') {
						System.out.println(res.getString("remUser"));
						String auxTitulo = sn.next();
						library.addBook(library.searchUser(userName).devolveBook(auxTitulo));						
					}else if (loop == 'c') {
						library.searchUser(userName).showBooks();
					}else if (loop == 'e') {
						System.out.println(res.getString("exit"));
					}else {
						System.out.println(res.getString("error"));
						loop = 'z';
					}
				
				
			}

		}

	}

}
