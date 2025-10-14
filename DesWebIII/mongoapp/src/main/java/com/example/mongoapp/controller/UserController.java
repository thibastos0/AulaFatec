package com.example.mongoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoapp.model.User;
import com.example.mongoapp.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/mongoapp/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public List<User> listarTodos(){
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<User> buscarPorId(@PathVariable String id){
        return userService.buscarPorId(id);
    }

    @PostMapping("/salvar")
    public User salvar(@RequestBody User usuario){
        return userService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public User atualizaUser(@PathVariable String id, @RequestBody User user) {
        return userService.atualizar(id, user);
    }

    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable String id){
        userService.deletar(id);
    }

}
