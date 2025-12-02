package com.example.demo_testes_pratica.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo_testes_pratica.util.EmailService;

public class UsuarioServiceTest {

    EmailService mockEmail = Mockito.mock(EmailService.class);
    private final UsuarioService usuario = new UsuarioService(mockEmail);

    @Test
    void testeSaudacao() {
        assertEquals("Olá, Ana!", usuario.saudacao("Ana")); //inicialmente correto

    }

    @Test
    void testeValidarIdade() {
        assertFalse(usuario.validarIdade(16));

    }

    @Test
    void deveNotificarUsuario() {

        //Act
        usuario.notificaUsuario("testes_praticos@mail.com");

        //Assert
        Mockito.verify(mockEmail).enviar(
            Mockito.eq("testes_praticos@mail.com"), Mockito.anyString()
        );

    }


    @Test
    void deveAlertarEmailInvalido() {

        String emailInvalido = "email-invalido";

        // Act & Assert
        Exception exception = assertThrows(
            IllegalArgumentException.class, 
            () -> {usuario.notificaUsuario(emailInvalido);}
        );
    
        assertEquals("Email inválido", exception.getMessage());
    
        // Verifica que o email NÃO foi enviado
        Mockito.verify(mockEmail, Mockito.never()).enviar(
            Mockito.anyString(), //e-mail
            Mockito.anyString() //mensagem
        );

    }

}
