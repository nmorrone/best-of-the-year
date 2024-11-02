package it.org.lessons.spring.model;

import java.util.Random;

public class Song {

	
	private int id;
	private String titolo;
	
	
	public Song(String s) {
		setId();
		this.titolo = s;
	}
	
	
	public void setId() {
		Random code = new Random();
		this.id = code.nextInt(1 + 100000);
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
