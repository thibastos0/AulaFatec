package ocp;
/* 
public class ClienteEstudante extends Cliente implements CalculadoraDesconto {

    public ClienteEstudante(String nome, String tipoCliente) {
        super(nome, tipoCliente);
    }
*/
public class ClienteEstudante implements CalculadoraDesconto {

    @Override
    public boolean verificaCliente(Cliente cliente) {
        //return "Estudante".equals(cliente.tipoCliente);
        return cliente.tipoCliente.equals("Estudante"); 
    }

    @Override
    public double liberarDesconto(Cliente cliente) {
        if(verificaCliente(cliente)) return 0.9; // desconto para clientes Estudante
        return 1.0; // sem desconto
    }



}
