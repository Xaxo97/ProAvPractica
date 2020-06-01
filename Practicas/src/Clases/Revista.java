package Clases;

public class Revista extends Libro implements PrintRevista{
	
	String magazine;

	public Revista(String _title, String _editorial, String _firstWords, int _pages, String _magazine) {
		super(_title, _editorial, _firstWords, _pages);
		iAm = "Magazine";
		magazine = _magazine;
	}
	public String getTitle() {
		return super.getTitle();
	}
	public void setTitle(String title) {
		super.setTitle(title);
	}
	public String getEditorial() {
		return super.getEditorial();
	}
	public void setEditorial(String editorial) {
		super.setEditorial(editorial);
	}
	public int getPages() {
		return super.getPages();
	}
	public void setPages(int pages) {
		super.setPages(pages);
	}
	public String getFirstWords() {
		return super.getFirstWords();
	}
	public void setFirstWords(String firstWords) {
		super.setFirstWords(firstWords);
	}
	public String getMagazine() {
		return magazine;
	}
	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}
	
	public void print() {
		System.out.println(magazine);
	}
	

}
