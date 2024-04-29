package com.develhope.crudtest1;
//scrivi una applicazione web Spring Boot con le dipendenze neccessarie che:
//ha una entità Student con le seguenti colonne:
//primary key
//name
//surname
//boolean isWorking
//ha un Service di base per cambiare il valore di isWorking
//ha un Controller per le operazioni CRUD:
//(1) per creare un nuovo Student
//(2) per ottenere la lista di tutti gli Student
//(3) per prendere uno Student specifico passando primary key come path variable
//(4) per aggiornare uno Student:
//passando primary key come path variable
//passando Student in request body *aggiornando il name e il surname
//(5) per aggiornare il valore isWorking value:
//passando primary key come path variable
//passando request param con nome working
//(6) per cancellare uno Student
//fai i test usando la mock base dati H2 con profilo test:
//(a) test del controller
//(b) test del service
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudTest1Application.class, args);
	}

}
