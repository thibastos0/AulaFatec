package dependencyInversion;

public class PedidoService {

    private Carrinho carrinho;

    public PedidoService(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void processarPedido(Pedido pedido) {
        // Lógica para processar o pedido
        System.out.println("Processando pedido: " + pedido.getId() + " com valor: " + pedido.getValor());
        carrinho.salvarPedido(pedido);
    }

}
