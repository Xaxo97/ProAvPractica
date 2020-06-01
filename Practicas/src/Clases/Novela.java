package Clases;

public class Novela extends Libro implements PrintNovela{
	String type ;	
	private static Novela instancia =null;
	
	/*public Novela(String _title, String _editorial, String _firstWords, int _pages, String _type) {
		super(_title, _editorial, _firstWords, _pages);
		iAm = "Novel";
		type = _type;
	}*/
	
	private Novela(String _title, String _editorial, String _firstWords, int _pages, String _type) {
		super(_title, _editorial, _firstWords, _pages);
		iAm = "Novel";
		type = _type;
	}
	
	public static synchronized Novela getInstancia(String _title, String _editorial, String _firstWords, int _pages, String _type) {
		if (instancia == null)
			instancia = new Novela(_title, _editorial, _firstWords, _pages, _type);
		return instancia;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getFirstWords() {
		return firstWords;
	}
	public void setFirstWords(String firstWords) {
		this.firstWords = firstWords;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void printNovela() {
		System.out.println(type);
	}

}
