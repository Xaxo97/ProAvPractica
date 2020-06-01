package Clases;

public class Administrador extends Usuario{

	public Administrador(String _name, String _password, String _email, boolean _admin) {
		super(_name, _password, _email, _admin);
	}
	
	public void addBook(Libro value, Biblioteca library) {
		library.addBook(value);
	}
	
	public void removeBook(String title, Biblioteca library, int op) {
		library.removeBook(title, op);
	}

	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
