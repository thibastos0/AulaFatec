package com.example.mongoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoapp.model.Product;
import com.example.mongoapp.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/mongoapp/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listar")
    public List<Product> listarTodos(){
        return productService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Product> buscarPorId(@PathVariable String id) {
        return productService.buscarPorId(id);
    }
    
    @PostMapping("/salvar")
    public Product salvar(@RequestBody Product product){
        return productService.salvar(product);
    }
    
    @PutMapping("/{id}")
    public Product atualizarProduct(@PathVariable String id, @RequestBody Product product){
        return productService.atualizar(id, product);
    }

    @DeleteMapping("/{id}")
    public void deletarProduct(@PathVariable String id){
        productService.deletar(id);
    }

}
