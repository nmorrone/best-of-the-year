package it.org.lessons.spring.model;


public class Song {

	
	private int id;
	private String titolo;
	
	
	public Song(int i, String s) {
		this.id = i;
		this.titolo = s;
	}
	
	
	public void setId(int n) {
		this.id = n;
	}
	public int getId() {
		return this.id;
	}
	
	public void setTitolo(String a) {
		this.titolo = a;
	}
	public String getTitolo() {
		return this.titolo;
	}
}
