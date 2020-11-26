package com.ds.mongo.mongoDB;

import com.ds.mongo.mongoDB.domain.Parent;
import com.ds.mongo.mongoDB.domain.ParentBuilder;
import com.ds.mongo.mongoDB.domain.Person;
import com.ds.mongo.mongoDB.domain.TYPE;
import com.ds.mongo.mongoDB.repository.ParentRepository;
import com.ds.mongo.mongoDB.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ParentRepository parentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.deleteAll();
		parentRepository.deleteAll();

		Parent parent = new ParentBuilder().setName("Mariano").setType(TYPE.FATHER).createParent();

		Person p;
		p = new Person();
		p.setAge(29);
		p.setName("Divanio");
		p.setNationality("PT/BR");
		p = personRepository.save(p);

		p = new Person();
		p.setNationality("PT/IT/BR");
		p.setAge(2);
		p.setName("Marianna Liberati");
		p.setParent(parent);
		personRepository.save(p);
		parent = parentRepository.save(parent);

		System.out.println(parent);
		System.out.println(p);

		List<Parent> parents = this.parentRepository.findByName("Mariano");
		System.out.println(parents);
	}
}
