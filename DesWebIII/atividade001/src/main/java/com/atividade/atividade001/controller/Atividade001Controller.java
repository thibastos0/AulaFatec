package com.atividade.atividade001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.atividade001.domain.User;
import com.atividade.atividade001.service.Atividade001Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController //indica que é um controller REST e não mantém estado (sem sessão)
@RequestMapping("/autenticacao") //é um rest controller que responde na rota /autenticacao as requisições
public class Atividade001Controller {

    @Autowired //substitui o constructor
    private Atividade001Service atividade001Service;

    @GetMapping("")
    public String helloWorld() {
        return atividade001Service.heloWorld("Thiago");
    }
    

    @PostMapping("") //mapeia o método para requisições POST
    public ResponseEntity<String> autenticarUsuario(@RequestBody User user) { //indica que o corpo da requisição será convertido para o objeto User
        String name = user.getName();
        String email = user.getEmail();
        if("admin".equals(name) && "teste@teste.com".equals(email)) {
            return ResponseEntity.ok("Login ok");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou email inválidos!");
        }
        
    }

}
