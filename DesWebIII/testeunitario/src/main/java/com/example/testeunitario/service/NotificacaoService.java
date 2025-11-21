package com.example.testeunitario.service;

import org.springframework.stereotype.Service;

import com.example.testeunitario.util.EmailService;

@Service
public class NotificacaoService {

    private final EmailService emailService;

    public NotificacaoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notificarUsuario(String email){

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("E-mail inválido");
        }

        emailService.enviar(email, "Bem-Vindo!", "Sua conta foi criada com sucesso!");
    }

}
