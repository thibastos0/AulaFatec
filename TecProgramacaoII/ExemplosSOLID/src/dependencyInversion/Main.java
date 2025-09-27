package dependencyInversion;

public class Main {

    public static void main(String[] args) {
        Pedido pedido = new Pedido("123", 250.75);
        Carrinho carrinho = new PedidoRepository();
        PedidoService pedidoService = new PedidoService(carrinho);
        pedidoService.processarPedido(pedido);
           
    }

}
