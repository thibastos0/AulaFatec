package logger;

import java.time.LocalTime;

public class Logger {

    private static Logger instance;
    public int numIntance;

    private Logger(int numIntance){
        // Construtor simulando a inicialização lenta
        try {
            Thread.sleep(1000); //aguarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.numIntance = numIntance;
        System.out.println("Novo Logger criado de número " + this.numIntance);
    }

    public static Logger getInstance(int numIntance){
        if (instance == null) {
            instance = new Logger(numIntance);
        }
        return instance;
    }

    public void log(String message) {
        LocalTime time = LocalTime.now();
        System.out.println(time + " - LOG:" + message);
        System.out.println("Instância: " + this.toString());
    }

    @Override
    public String toString() {
        return "Logger@" + Integer.toHexString(System.identityHashCode(this));
    }

}
