package it.org.lessons.spring.model;

import java.util.Random;

public class Movie {

	private int id;
	private String titolo;
	
	
	Movie(String m){
		
		this.titolo = m;
		setId();
	}
	
	public void setTitolo(String a) {
		this.titolo = a;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public void setId() {
		Random code = new Random();
		this.id = code.nextInt(1 + 100000);
	}
	
	public int getId() {
		return this.id;
	}
}


