package com.atividade002.acessoSistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade002.acessoSistema.model.Usuario;
import com.atividade002.acessoSistema.service.UsuarioService;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("") //mapeia o método para requisições POST
    public ResponseEntity<String> autenticarUsuario(@RequestBody Usuario user) { //indica que o corpo da requisição será convertido para o objeto Usuario
        String nome = user.getNome();
        String email = user.getEmail();
        if(usuarioService.autenticar(nome, email)!=null){
        //if("admin".equals(nome) && "teste@teste.com".equals(email)) {
            return ResponseEntity.ok("Login ok");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou email inválidos!");
        }
        
    }


}
