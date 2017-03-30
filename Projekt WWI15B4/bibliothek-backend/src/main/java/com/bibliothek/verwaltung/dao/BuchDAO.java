package com.bibliothek.verwaltung.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bibliothek.verwaltung.beans.Buch;

/**
 * Klasse zur Kommunikation zwischen Datenbank und Java.
 * 
 * @author Edeka
 *
 */
@Repository
@Transactional
public class BuchDAO {
	
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }
	  
	/**
	 * Das Objekt Buch wird in der Datenbank angelegt.
	 * 
	 * @param b Objekt vom Typ Buch, dass angelegt wird.
	 */
	public void anlegen(Buch b) {
		getSession().save(b);
	}
	
	/**
	 * Es werden alle Bücher aus der Datenbank geladen und in einer Liste 
	 * gespeichert. Diese Liste wird mit allen Büchern zurück gegeben.
	 * 
	 * @return Liste mit allen Büchern
	 */
	@SuppressWarnings("unchecked")
	public List<Buch> alleBuecherLaden() {
		
		return getSession().createQuery("from Buch").list();
	}

	/**
	 * Ein einzelenes Buch wird mit der ID aus der Datenbank gesucht.
	 * Das gefundene Objekt wird zurück gegeben.
	 * 
	 * @param id vom Typ Integer
	 * @return ausgewähle Buch
	 */
	public Buch buchLaden(int id) {

		Session session = this.sessionFactory.openSession();

		Buch b = (Buch) session.get(Buch.class, id);
				
		session.close();
		
		return b;
	}

	/**
	 * Das zu löschende Objekt wird anhand einer ID ausgesucht und gelöscht.
	 * 
	 * @param id vom Typ Integer
	 * @return status der Löschung
	 */
	public boolean loeschen(int id) {

		Session session = this.sessionFactory.openSession();
		
		Query query = session.createQuery("delete Buch where id =:ID");
		query.setParameter("ID", id);

		int result = query.executeUpdate();
		
		session.close();
		
		if(result == 1)
			return true;
		else
			return false;
	}

	/**
	 * Das Objekt Buch b wird übergeben mit den neuen Daten. Dieses wird
	 * automatisch geändert.
	 * 
	 * @param b Objekt vom Typ Buch
	 */ 
	public void bearbeiten(Buch b) {

		Session session = this.sessionFactory.openSession();
		
		Query query = session.createQuery("update Buch b SET b.titel=:titel, "
				+ "b.autor=:autor, "
				+ "b.erscheinungsjahr=:erscheinungsjahr,"
				+ "b.auflage=:auflage,"
				+ "b.kategorie=:kategorie,"
				+ "b.verlag=:verlag,"
				+ "b.isbn=:isbn where b.id =:ID");
		query.setParameter("ID", b.getId());
		query.setParameter("titel", b.getTitel());
		query.setParameter("autor", b.getAutor());
		query.setParameter("erscheinungsjahr", b.getErscheinungsjahr());
		query.setParameter("auflage", b.getAuflage());
		query.setParameter("isbn", b.getIsbn());
		query.setParameter("kategorie", b.getKategorie());
		query.setParameter("verlag", b.getVerlag());
		
		query.executeUpdate();
		
		session.close();
		
	}

	
}
