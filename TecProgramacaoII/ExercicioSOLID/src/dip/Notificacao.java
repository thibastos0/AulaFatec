package dip;

public class Notificacao {
    
    private Mensagem mensagem;

    public Notificacao(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public void notificar(String msg) {
        this.mensagem.enviar(msg);
    }

}
