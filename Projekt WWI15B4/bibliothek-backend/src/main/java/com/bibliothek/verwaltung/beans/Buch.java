package com.bibliothek.verwaltung.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Klasse mit allen Paramtern eines Buches.
 * 
 * @author Vitali Zeiser
 *
 */
@JsonRootName("buch")
@Entity
@Table(name = "Buch")
public class Buch {

	// --- Variablen ---
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titel;
	
	private String autor;
	
	private String verlag;
	
	private String isbn;
	
	private int auflage;
	
	private int erscheinungsjahr;
	
	private String kategorie;

	// --- Konstruktoren ---
	public Buch(){
		
	}
	
	public Buch(Integer id, String titel, String autor, String verlag, String isbn, int auflage, int erscheinungsjahr, String kategorie){
		this.id = id;
		this.titel = titel;
		this.autor = autor;
		this.verlag = verlag;
		this.isbn = isbn;
		this.auflage = auflage; 
		this.erscheinungsjahr = erscheinungsjahr;
		this.kategorie = kategorie;
	}
	

	// --- Getter und Setter ---
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getVerlag() {
		return verlag;
	}

	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAuflage() {
		return auflage;
	}

	public void setAuflage(int auflage) {
		this.auflage = auflage;
	}

	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}

	public void setErscheinungsjahr(int erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
}
