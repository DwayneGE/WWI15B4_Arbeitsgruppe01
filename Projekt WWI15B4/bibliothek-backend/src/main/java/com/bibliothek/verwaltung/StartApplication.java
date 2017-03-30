package com.bibliothek.verwaltung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


/**
 * Die Startklasse für die Anwendung.
 * 
 * @author Vitali Zeiser
 *
 */
@EnableZuulProxy
@SpringBootApplication
@ComponentScan("com.bibliothek.verwaltung")
@PropertySource("application.properties")
public class StartApplication {
	
	public static void main(String[] args) {

		SpringApplication.run(StartApplication.class, args);
		
	}
	
}
