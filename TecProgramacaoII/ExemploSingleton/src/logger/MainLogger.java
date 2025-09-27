package logger;

public class MainLogger {

    public static void main(String[] args) {
        //Logger logger1 = new Logger();
        Logger logger1 = Logger.getInstance();
        logger1.log("Primeira mensagem");

        //Logger logger2 = new Logger();
        Logger logger2 = Logger.getInstance();
        logger2.log("Segunda mensagem");

    }

}
