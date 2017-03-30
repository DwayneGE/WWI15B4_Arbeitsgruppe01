package com.bibliothek.verwaltung;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bibliothek.verwaltung.beans.Buch;
import com.bibliothek.verwaltung.dao.BuchDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataBaseConfigTest.class})
@ComponentScan("com.bibliothek.verwaltung")
@PropertySource("application.properties")
public class TestKlasse {
	
	@Autowired 
	private static BuchDAO buchDao;

	@Test
	public void test1(){
		
		Buch b = new Buch(2, "Herr der Ringe", "Bla", "Bla", "Bal", 1, 2012, "roman");
		
		Buch b2 = new Buch(2, "Herr der Ringe2", "asdasBla", "asdaBla", "asdaBal", 1, 2012, "roman");
		
		
		buchDao.anlegen(b);
		
		List<Buch> buchListe = new ArrayList<>();

		buchListe = buchDao.alleBuecherLaden();
		
		for(Buch b3 : buchListe){
		
			System.out.println(b3.getTitel());
			
		}
		
		buchDao.bearbeiten(b2);
		
		buchListe = buchDao.alleBuecherLaden();
		
		for(Buch b4 : buchListe){
		
			System.out.println(b4.getTitel());
			
		}
		
	}
	
}
