package dip;

public class Main {

    public static void main(String[] args) {
        Mensagem email = new Email("exemplo@dominio.com");
        Notificacao notificacao = new Notificacao(email);
        notificacao.notificar("Olá, esta é uma mensagem de teste via e-mail!");
    
        Mensagem sms = new SMS("19-9999-9999");
        Notificacao notificacaoSMS = new Notificacao(sms);
        notificacaoSMS.notificar("Olá, esta é uma mensagem de teste via SMS!");
    
    }

}
