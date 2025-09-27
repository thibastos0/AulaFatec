package logger;

import java.time.LocalTime;

public class Logger {

    private static Logger instance;

    private Logger(){
        System.out.println("Novo Logger criado");
    }

    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
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
