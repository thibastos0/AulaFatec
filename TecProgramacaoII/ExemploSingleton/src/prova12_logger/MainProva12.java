package prova12_logger;

public class MainProva12 {

public static void main(String[] args) {
    
    PedidoService pedidoService = new PedidoService();
    UsuarioService usuarioService = new UsuarioService();

    pedidoService.processarPedido();
    usuarioService.processarPedido();

}

/*
 * a) criado arquivo UsuarioService.java apenas com uma pequena difereça no Syso para facilitar a visualização no console.
 * b) Para demonstrar o uso da mesma instância foi evidênciado no código do Logger (em seu contrutor) quando a instância é executada. É possível observar que somente uma é criada, apesar dos objetos usuarioService e pedidoService usarem o logger.
 * c) Num cenário multithread em que haja concorrência de acesso, bem como com o escalonamento do programa.
 * d) O princípio SRP é ferido, na medida que é criada uma classe com a responsabilidade de logger e controle de suas próprias instâncias ao mesmo tempo. Embora esse recuso permite economia de recursos e cria um acesso global à instância.
 */

}
