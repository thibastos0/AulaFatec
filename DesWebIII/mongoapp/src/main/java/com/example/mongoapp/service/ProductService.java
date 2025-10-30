package com.example.mongoapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoapp.model.Product;
import com.example.mongoapp.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listarTodos(){
        return productRepository.findAll();        
    }

    public Optional<Product> buscarPorId(String id){
        return productRepository.findById(id);
    }

    public Product salvar(Product product){
        return productRepository.save(product);
    }

    public Product atualizar(String id, Product productAtualizado){
        Optional<Product> productExistente = productRepository.findById(id);
        if(productExistente.isPresent()){
            Product product = productExistente.get();
            product.setName(productAtualizado.getName());
            product.setDescription(productAtualizado.getDescription());
            product.setPrice(productAtualizado.getPrice());
            product.setQuantity(productAtualizado.getQuantity());
            return productRepository.save(product);

        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }

    }

    public void deletar(String id){
        productRepository.deleteById(id);
    }

}
