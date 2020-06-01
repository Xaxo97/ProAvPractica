package Clases;

public class Libro {
	String title, editorial, firstWords, iAm;
	int units, pages;
	
	public Libro (String _title, String _editorial, String _firstWords, int _pages){
		title = _title;
		editorial = _editorial;
		firstWords = _firstWords;
		units = 1;
		iAm = "Book";
		pages = _pages;
	}
	
	public Libro(Libro value) {
		title = value.getTitle();
		editorial = value.getEditorial();
		firstWords = value.getFirstWords();
		units = value.getUnits();
		iAm = value.getiAm();
		pages = value.getPages();
	}
	
	public void read() {
		System.out.println(firstWords);
	}
	
	public void printBook() {
		System.out.println(title + "\n" + editorial + "\n" + pages + "\n" + firstWords);
	}
	
	public void addUnits() {
		units++;
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
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public String getiAm() {
		return iAm;
	}
	public void setiAm(String iAm) {
		this.iAm = iAm;
	}
	

		
}
