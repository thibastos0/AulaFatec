package dip;

public class Main {

    public static void main(String[] args) {
        Mensagem email = new Email("exemplo@dominio.com");
        //Notificacao notificacao = new Notificacao(email);
        //notificacao.notificar("Olá, esta é uma mensagem de teste via e-mail!");
    
        Mensagem sms = new SMS("19-9999-9999");
        //Notificacao notificacaoSMS = new Notificacao(sms);
        //notificacaoSMS.notificar("Olá, esta é uma mensagem de teste via SMS!");

        String comunicado = "Alerta de segurança: Sistema fora do ar!";

        transmitirMensagem(email, comunicado);
        transmitirMensagem(sms, comunicado);
        transmitirMensagem(new Email("fatec@fatec.com"), comunicado);
        transmitirMensagem(new SMS("19-8888-8888"), comunicado);
    
    }

    static void transmitirMensagem(Mensagem mensagem, String texto) {
        Notificacao notificacao = new Notificacao(mensagem);
        notificacao.notificar(texto);
    }

}
