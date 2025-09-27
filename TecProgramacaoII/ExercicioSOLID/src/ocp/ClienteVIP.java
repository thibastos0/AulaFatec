package ocp;
/*
public class ClienteVIP extends Cliente implements CalculadoraDesconto {

    public ClienteVIP(String nome, String tipoCliente) {
        super(nome, tipoCliente);
    }
*/
public class ClienteVIP implements CalculadoraDesconto {
    @Override
    public boolean verificaCliente(Cliente cliente) {
        return cliente.tipoCliente.equals("VIP");
    }
    
    @Override
    public double liberarDesconto(Cliente cliente) {
        if(verificaCliente(cliente)) return 0.8; // desconto para clientes VIP
        return 1.0; // sem desconto
    }

}
