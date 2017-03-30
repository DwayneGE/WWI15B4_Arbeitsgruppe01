package com.bibliothek.verwaltung.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bibliothek.verwaltung.beans.Buch;
import com.bibliothek.verwaltung.dao.BuchDAO;

@RestController
@RequestMapping("/buches")
public class BuchController {

	@Autowired
	private BuchDAO buchDao;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Buch> getBuch(@PathVariable("id") Integer id ){
		
		Buch b = buchDao.buchLaden(id);
		
		return new ResponseEntity<>(b, HttpStatus.OK);
		
	}
	
	/**
	 * Alle Bücher aus der Datenbank holen und im JSON Format an Ember übertragen.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Buch>> getListJson(){
		
		List<Buch> buchListe = new ArrayList<>();

		buchListe = buchDao.alleBuecherLaden();
		
		return new ResponseEntity<List<Buch>>( buchListe , HttpStatus.OK);
	}
	
	/**
	 * Von Ember das Objekt Buch erhalten und in der Datenbank speichern.
	 * 
	 * @param b
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> speichern(@RequestBody Buch b){
		
		buchDao.anlegen(b);
		
		return new ResponseEntity<>(b.getId(), HttpStatus.OK);
		
	}
	
	/**
	 * Mithilfe der ID Buch ermitteln und aus der Datenbank löschen.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> loeschen(@PathVariable("id") Integer id ){
		
		buchDao.loeschen(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

	/**
	 * Verarbeitet die Änderungen von Ember in die Datenbank
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Void> bearbeiten(@PathVariable("id") Integer id, @RequestBody Buch b){
		
		Buch buchAusDb = buchDao.buchLaden(id);
		
		if(b.getAuflage() != 0)
			buchAusDb.setAuflage(b.getAuflage());
		
		if(!b.getKategorie().isEmpty())
			buchAusDb.setKategorie(b.getKategorie());
		
		if(!b.getTitel().isEmpty())
			buchAusDb.setTitel(b.getTitel());
		
		if(b.getErscheinungsjahr() != 0)
			buchAusDb.setErscheinungsjahr(b.getErscheinungsjahr());
		
		if(!b.getAutor().isEmpty())
			buchAusDb.setAutor(b.getAutor());
		
		if(!b.getIsbn().isEmpty())
			buchAusDb.setIsbn(b.getIsbn());
			
		if(!b.getVerlag().isEmpty())
			buchAusDb.setVerlag(b.getVerlag());
			
		buchDao.bearbeiten(buchAusDb);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
