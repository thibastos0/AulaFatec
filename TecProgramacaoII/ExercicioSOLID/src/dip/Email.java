package dip;

public class Email implements Mensagem {

    private String endereco;


    public Email(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void enviar(String msg) {
        System.out.println("Enviando email de " + endereco + " com a mensagem: " + msg);
    }

}
