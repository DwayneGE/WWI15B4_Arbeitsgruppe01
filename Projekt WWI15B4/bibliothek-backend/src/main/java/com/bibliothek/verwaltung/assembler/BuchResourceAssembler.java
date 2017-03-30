package com.bibliothek.verwaltung.assembler;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.bibliothek.verwaltung.beans.Buch;

/**
 * Klasse zur Kommunikation mit Ember.
 * 
 * @author Edeka
 *
 */
@Component
public class BuchResourceAssembler implements ResourceAssembler<Buch, Resource<Buch>>{

	/**
	 * Methode verarbeitet den Link eines einzelnen Buchs aus Ember.
	 * 
	 * @param buch -> Objekt vom Typ Buch
	 * 
	 * return resource --> Die Zieladresse von einem bestimmten Buch
	 */
	@Override
	public Resource<Buch> toResource(Buch buch) {

		Resource<Buch> resource = new Resource<Buch>(buch);
		
		resource.add(new Link("http://buch/" + buch.getId()).withSelfRel());
		
		return resource;
	}
	
	
	/**
	 * Methode veratbeitet den Link einer Liste von Büchern.
	 * 
	 * @param buch --> Liste vom Typ Buch
	 * @return resource --> Zieladresse von mehreren Büchern
	 */
	public Resource<List<Buch>> toResource(List<Buch> buch) {

		Resource<List<Buch>> resource = new Resource<List<Buch>>(buch);
		
		for(Buch b : buch)
			resource.add(new Link("http://buch/" + b.getId()).withSelfRel());
		
		return resource;
	}
}
