package it.org.lessons.spring.model;


public class Song {	
	private int id;
	private String titolo;
	private String gruppo;
	private String album;
	
	
	public Song(int i, String s, String g, String a) {
		this.id = i;
		this.titolo = s;
		this.gruppo = g;
		this.album = a;
	}
	
	public Song () {
		
	}
	
	public void setAlbum(String a) {
		this.album = a;
	}
	public String getAlbum() {
		return this.album;
	}
	public void setGruppo(String g) {
		this.gruppo = g;
	}
	public String getGruppo() {
		return this.gruppo;
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
