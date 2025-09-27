package ocp;

public interface CalculadoraDesconto {

    boolean verificaCliente(Cliente cliente);

    double liberarDesconto(Cliente cliente);
}
