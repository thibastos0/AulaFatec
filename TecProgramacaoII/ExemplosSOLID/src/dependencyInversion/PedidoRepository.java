package dependencyInversion;

public class PedidoRepository implements Carrinho {

    @Override
    public void salvarPedido(Pedido pedido) {
        // Lógica para salvar o pedido no banco de dados
        System.out.println("Pedido " + pedido.getId() + " salvo com sucesso!");
    }

}
