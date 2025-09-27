package ocp;

public class Cliente {
    String nome;
    String tipoCliente; // "Regular", "VIP", "Estudante", etc.

    public Cliente(String nome, String tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }
}
