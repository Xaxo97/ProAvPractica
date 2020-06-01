package Clases;


public class LibroPrestado {
	Libro book;
	int year, month, day;
	
	public LibroPrestado(Libro _book, int _year, int _month, int _day){
		book = _book;
		year = _year;
		month = _month;
		day = _day;
	}
	
	public Libro getBook() {
		return book;
	}
	public void setBook(Libro book) {
		this.book = book;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	

}
