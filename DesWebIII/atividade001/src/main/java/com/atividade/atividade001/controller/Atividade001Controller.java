package com.atividade.atividade001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.atividade001.domain.User;
import com.atividade.atividade001.service.Atividade001Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController //indica que é um controller REST e não mantém estado (sem sessão)
@RequestMapping("/autenticacao") //é um rest controller que responde na rota /autenticacao as requisições
public class Atividade001Controller {

    @Autowired //substitui o constructor
    private Atividade001Service atividade001Service;

    @PostMapping("") //mapeia o método para requisições POST
    public ResponseEntity<String> autenticarUsuario(@RequestBody User user) { //indica que o corpo da requisição será convertido para o objeto User
        String name = user.getName();
        String email = user.getEmail();
        return this.atividade001Service.autenticarUsuario(name, email);
    }

}
