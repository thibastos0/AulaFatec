package com.example.mongoapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongoapp.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
    
}