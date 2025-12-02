package com.example.demo_testes_pratica.service;

import org.springframework.stereotype.Service;

import com.example.demo_testes_pratica.util.EmailService;

@Service
public class UsuarioService {

    public final EmailService emailService;

    public UsuarioService(EmailService emailService){
        this.emailService = emailService;
    }

    public boolean validarIdade(int idade){
        return idade >= 18;
    }

    public String saudacao(String nome){
        return "Olá, " + nome +"!";
    }

    public void notificaUsuario(String email){
        if(email == "" || !email.contains("@") || !email.contains(".") || email.isBlank()){
            throw new IllegalArgumentException("Email inválido");
        }

        emailService.enviar(email, "Olá!");
    }

}
