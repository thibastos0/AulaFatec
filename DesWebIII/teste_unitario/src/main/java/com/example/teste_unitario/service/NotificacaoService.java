package com.example.teste_unitario.service;

import com.example.teste_unitario.util.EmailService;

public class NotificacaoService{
    
    private final EmailService emailService;

    public NotificacaoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notificarUsuario(String email) {
        emailService.enviar(email, "Assunto Importante", "Todo mundo tirou 10 no PI");
    }

}
