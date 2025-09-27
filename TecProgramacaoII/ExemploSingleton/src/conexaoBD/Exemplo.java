package conexaoBD;

public class Exemplo {

    private static Exemplo instance;

    private Exemplo() {
        // Construtor privado para evitar instância externa
    }

    public static Exemplo getInstance() {
        if (instance == null) {
            instance = new Exemplo();
        }
        return instance;
    }
}
