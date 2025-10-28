package provaDecorator;

import provaDecorator.decoradores.NotificadorComLog;
import provaDecorator.decoradores.NotificadorEmail;
import provaDecorator.notificaBase.NotificadorSimples;

public class MainProva22 {

    public static void main(String[] args) {
        
        Notificador notificador = new NotificadorComLog(
            new NotificadorEmail(new NotificadorSimples()));
        
            notificador.enviar("Promoção de outubro!");

    }

}

/*
 * Foi seguido o padrão do Decorator de envelopamento.
 * O decorator reduz a necessidade de criarmos subclasses e segue o princípio  open-closed, evitando modificações no código através de novas interfaces e extends.
 * 
 */