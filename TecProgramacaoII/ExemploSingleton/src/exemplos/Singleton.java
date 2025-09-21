package exemplos;

public final class Singleton {
    //private static Singleton instance;
    private static volatile Singleton instance; // Usar 'volatile' para garantir visibilidade entre threads
    public String value;

    private Singleton(String value) {
    /*    // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }*/
        this.value = value;
    }

    public static Singleton getInstance(String value) {
    /*    if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }*/
        Singleton result = instance;
        if (result != null) { // First check (no locking)
            return result;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

}
