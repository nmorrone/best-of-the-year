package it.org.lessons.spring.model;


public class Movie {

	private int id;
	private String titolo;
	public Movie(int i, String m){
		
		this.titolo = m;
		this.id = i;
	}
	
	public Movie() {
		
	}
	
	public void setTitolo(String a) {
		this.titolo = a;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public void setId(int n) {
		this.id = n;
	}
	
	public int getId() {
		return this.id;
	}
}


