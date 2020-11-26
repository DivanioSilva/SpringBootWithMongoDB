package com.ds.mongo.mongoDB.repository;

import com.ds.mongo.mongoDB.domain.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {
    List<Parent> findByName(String name);
}
