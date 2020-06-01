package Clases;

import java.util.ArrayList;

public class Usuario {
	String name, password, email;
	boolean admin;
	ArrayList <ArrayList<LibroPrestado>> books;
	
	public Usuario (String _name, String _password, String _email, boolean _admin){
		name = _name;
		password = _password;
		email = _email;
		admin = _admin;
		books = new ArrayList<ArrayList<LibroPrestado>>();
		for (int i = 0; i < 3; i++)
			books.add(new ArrayList<LibroPrestado>());
	}
	
	public Usuario (Usuario value) {
		name = value.getName();
		password = value.getPassword();
		email = value.getEmail();
		books = value.getBooks();
	}
	
	
	public void addBook(Libro value, Biblioteca library) {
		if (admin == true) {
			library.addBook(value);
		}
	}
	
	public void removeBook(String title, Biblioteca library, int op) {
		if(admin == true) {
			library.removeBook(title, op);
		}

	}

	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	//Añade un libro a la lista de libros del usuario
	
	public void addBook(LibroPrestado value) {
		if (value.getBook().getiAm().equals("Novel")) {
			books.get(1).add(value);
		}else if(value.getBook().getiAm().equals("Magazine")) {
			books.get(2).add(value);
		}else {
			books.get(0).add(value);
		}
	}
	
	//Elimina un libro de la lista de libros del usuario y devuelve el libro, para que la biblioteca lo añada a su lista
	
	public Libro devolveBook(String value) {
		
		Libro aux;
		
		for (int i=0; i<3; i++) {
			for(int j=0; j<books.get(i).size(); j++) {
				if(value.equals(books.get(i).get(j).getBook().getTitle())) {
					aux = books.get(i).get(j).getBook();
					books.get(i).remove(j);
					return aux;
				}
			}
		}
		
		return null;
		
	}
	
	public void showBooks() throws InterruptedException {
		for (int i=0; i<3; i++) {
			for(int j=0; j<books.get(i).size(); j++) {
				System.out.println(books.get(i).get(j).getBook().getTitle());
				Thread.sleep(1000);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<ArrayList<LibroPrestado>> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<ArrayList<LibroPrestado>> books) {
		this.books = books;
	}
	
	
	

}
