package dependencyInversion;

public class PedidoService {

    private PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public void processarPedido(Pedido pedido) {
        // Lógica para processar o pedido
        repository.salvarPedido(pedido);
    }

}
