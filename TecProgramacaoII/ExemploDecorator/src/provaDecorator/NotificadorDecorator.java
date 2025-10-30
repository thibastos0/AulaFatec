package provaDecorator;

public abstract class NotificadorDecorator implements Notificador {

    protected Notificador wrappee;

    public NotificadorDecorator(Notificador wrappee) {
        this.wrappee = wrappee;
    }

    public void enviar(String mensagem){
        wrappee.enviar(mensagem);
    }

}
