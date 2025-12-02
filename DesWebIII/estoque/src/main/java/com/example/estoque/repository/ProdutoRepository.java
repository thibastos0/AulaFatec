package com.example.estoque.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.estoque.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

}
