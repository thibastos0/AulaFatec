package logger;

public class MainLogger {

    public static void main(String[] args) {
        //Logger logger1 = new Logger(1);
        //Logger logger1 = Logger.getInstance(1);
        //logger1.log("Primeira mensagem");

        Thread threadLog1 = new Thread(new ThreadLog1());

        //Logger logger2 = new Logger(2);
        //Logger logger2 = Logger.getInstance(2);
        //logger2.log("Segunda mensagem");

        Thread threadLog2 = new Thread(new ThreadLog2());

        threadLog1.start();
        threadLog2.start();

    }

    //simulando processo multithread

    static class  ThreadLog1 implements Runnable {
    
        @Override
        public void run(){
            Logger logger = Logger.getInstance(1);
            logger.log("Primeira mensagem");
        }
        
    }

    static class  ThreadLog2 implements Runnable {
    
        @Override
        public void run(){
            Logger logger = Logger.getInstance(2);
            logger.log("Segunda mensagem");
        }
        
    }
}
