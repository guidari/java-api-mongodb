package com.psjava.oceantech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.psjava.oceantech.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
