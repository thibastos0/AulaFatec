package dependencyInversion;

public class Pedido {
    private String id;
    private double valor;

    public Pedido(String id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

}
