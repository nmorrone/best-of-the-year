package it.org.lessons.spring.model;


public class Movie {

	private int id;
	private String titolo;
	private String regista;
	private int durata;
	public Movie(int i, String m, String r, int d){
		
		this.titolo = m;
		this.id = i;
		this.regista = r;
		this.durata = d;
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
	
	public void setRegista(String r) {
		this.regista=r;
	}
	
	public String getRegista() {
		return this.regista;
	}
	
	public int getDurata() {
		return this.durata;
	}
	public void setDurata (int d) {
		this.durata = d;
	}
}


