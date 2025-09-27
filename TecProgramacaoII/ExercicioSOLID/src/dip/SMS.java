package dip;

public class SMS implements Mensagem {

    private String numero;

    public SMS(String numero) {
        this.numero = numero;
    }

    @Override
    public void enviar(String msg) {
        System.out.println("Enviando SMS do " + numero + " com a mensagem: " + msg);
    }

}
