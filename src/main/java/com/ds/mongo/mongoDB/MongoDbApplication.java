package com.ds.mongo.mongoDB;

import com.ds.mongo.mongoDB.domain.Person;
import com.ds.mongo.mongoDB.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//personRepository.deleteAll();

		Person p;
		p = new Person();
		p.setAge(29);
		p.setName("Divanio");
		System.out.println(personRepository.save(p));

		p = new Person();
		p.setAge(20);
		p.setName("Arianna");
		personRepository.save(p);
		System.out.println(personRepository.save(p));

		System.out.println("Find by person's name...");

		//p = personRepository.findByName("Arianna").get();

		System.out.println(p);

			List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			p = new Person();
			persons.add(p);
		}

		personRepository.saveAll(persons);

		List<Person> personss = personRepository.findAll();


		System.out.println();

	}
}
