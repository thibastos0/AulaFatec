package provaDecorator.decoradores;

import provaDecorator.Notificador;
import provaDecorator.NotificadorDecorator;

public class NotificadorComLog extends NotificadorDecorator{

    public NotificadorComLog(Notificador wrappee){
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem){
        wrappee.enviar(mensagem + " logging message:");

    }

}
