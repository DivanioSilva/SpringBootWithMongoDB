package com.ds.mongo.mongoDB.repository;

import com.ds.mongo.mongoDB.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {

    Optional<Person> findByName(String name);
    //soutws
}
