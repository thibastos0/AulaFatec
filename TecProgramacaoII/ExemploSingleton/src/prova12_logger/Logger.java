package prova12_logger;

public class Logger {
    private static Logger instancia;

    private Logger(){
        //Construtor privado para evitar instâncias externas
        System.out.println("instância de Logger criada.");
    }

    public static Logger getInstancia() {
        if (instancia == null){
            instancia = new Logger();
        }
        return instancia;
    }

    public void log(String mensagem) {
        System.out.println("[LOG] " + mensagem);
    }

}
