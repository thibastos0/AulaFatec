package com.example.mongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoapp.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
