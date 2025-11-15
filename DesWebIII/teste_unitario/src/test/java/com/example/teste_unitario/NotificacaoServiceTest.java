package com.example.teste_unitario;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.teste_unitario.service.NotificacaoService;
import com.example.teste_unitario.util.EmailService;

public class NotificacaoServiceTest {

    @Test
    void deveChamarEmailServiceAoNotificar() {
        //Arrange
        EmailService mockEmail = Mockito.mock(EmailService.class);
        NotificacaoService notificacao = new NotificacaoService(mockEmail);

        //Act
        notificacao.notificarUsuario("teste@teste.com");

        //Assert
        Mockito.verify(mockEmail).enviar(Mockito.eq("teste@teste.com"), Mockito.eq("Assunto Importante"), Mockito.eq("Todo mundo tirou 10 no PI"));
    }
}
