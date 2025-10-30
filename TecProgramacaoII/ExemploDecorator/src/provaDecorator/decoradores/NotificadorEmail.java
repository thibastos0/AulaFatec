package provaDecorator.decoradores;

import provaDecorator.Notificador;
import provaDecorator.NotificadorDecorator;

public class NotificadorEmail extends NotificadorDecorator {


    public NotificadorEmail(Notificador wrappee){
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem){
        wrappee.enviar(mensagem + " enviado via e-mail");

    }


}
