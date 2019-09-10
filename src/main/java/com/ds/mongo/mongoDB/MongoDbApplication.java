package com.ds.mongo.mongoDB;

import com.ds.mongo.mongoDB.domain.Person;
import com.ds.mongo.mongoDB.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.deleteAll();

		Person p;
		p = new Person();
		p.setAge(29);
		p.setName("Divanio");
		p = personRepository.save(p);

		System.out.println(p);
	}
}
