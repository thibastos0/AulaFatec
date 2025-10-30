package prova12_logger;

public class PedidoService {

    private Logger logger = Logger.getInstancia();

    public void processarPedido() {
        //Lógica fictícia
        logger.log("Peddo processado com sucesso.");
    }

}
