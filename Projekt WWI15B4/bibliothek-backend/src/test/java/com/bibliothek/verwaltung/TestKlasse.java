package com.bibliothek.verwaltung;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bibliothek.verwaltung.beans.Buch;
import com.bibliothek.verwaltung.controllers.BuchController;
import com.bibliothek.verwaltung.dao.BuchDAO;

public class TestKlasse {
	
	@Mock
	private BuchDAO buchDao;

	@Spy
	List<Buch> buchListe = new ArrayList<>();

	@InjectMocks
	BuchController controller;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		buchListe = getBuchListe();
	}
	
	
	@Test
	public void anlegen(){
		
		Buch b = new Buch(3, "Herr der Ringe", "Bla", "Bla", "Bal", 1, 2012, "roman");
		Assert.assertEquals(controller.speichern(b), new ResponseEntity<Integer>(3, HttpStatus.OK));
		
	}
	
	@Test
	public void suchenNachId(){
		
		Assert.assertEquals(controller.getBuch(1), new ResponseEntity<>(HttpStatus.OK));
		
	}
	
	@Test
	public void suchAlleBuecher(){
		
		Assert.assertEquals(controller.getListJson(), new ResponseEntity<>(new ArrayList<Buch>() ,HttpStatus.OK));
		
	}
	
	@Test
	public void loeschen(){
		
		Assert.assertEquals(controller.loeschen(1), new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
		Assert.assertEquals(controller.getBuch(1), new ResponseEntity<>(HttpStatus.OK));
		
	}
	
	
    public List<Buch> getBuchListe(){
		
    	Buch b = new Buch(2, "Herr der Ringe", "Bla", "Bla", "Bal", 1, 2012, "roman");
		Buch b2 = new Buch(2, "Herr der Ringe2", "asdasBla", "asdaBla", "asdaBal", 1, 2012, "roman");
         
		buchListe.add(b);
		buchListe.add(b2);
        return buchListe;
    }
	
	
}
