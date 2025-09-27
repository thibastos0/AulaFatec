package logger;

public class Logger {

    public Logger(){
        System.out.println("Novo Logger criado");
    }

    public void log(String message) {
        System.out.println("LOG:" + message);
        System.out.println(this.toString());
    }

}
