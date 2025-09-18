package com.atividade.atividade001.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Atividade001Service {

    public ResponseEntity<String> autenticarUsuario(String name, String email) {
        if("admin".equals(name) && "teste@teste.com".equals(email)) {
            return ResponseEntity.ok("Login ok");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou email inválidos");
        }
    }
}