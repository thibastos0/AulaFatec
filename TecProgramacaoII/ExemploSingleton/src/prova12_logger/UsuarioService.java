package prova12_logger;

public class UsuarioService {

    private Logger logger = Logger.getInstancia();

    public void processarPedido(){
        //Lógica fictícia
        logger.log("Pedido do usuário processado com sucesso!");
    }


}
