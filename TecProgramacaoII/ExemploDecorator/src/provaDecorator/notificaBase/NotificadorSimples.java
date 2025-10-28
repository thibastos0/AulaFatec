package provaDecorator.notificaBase;

import provaDecorator.Notificador;

public class NotificadorSimples implements Notificador {

    public void enviar(String mensagem){
        System.out.println("Enviando: " + mensagem);
    }

}
