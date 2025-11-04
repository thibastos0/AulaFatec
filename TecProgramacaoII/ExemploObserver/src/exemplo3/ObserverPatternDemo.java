package exemplo3;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Criando a agência de notícias
        NewsAgency agency = new NewsAgency();
        
        // Criando observadores
        TechEnthusiast techObserver = new TechEnthusiast("João");
        SportsLover sportsObserver = new SportsLover("Maria");
        NewsReader generalObserver = new NewsReader("Carlos");
        
        // Adicionando observadores
        agency.addObserver(techObserver);
        agency.addObserver(sportsObserver);
        agency.addObserver(generalObserver);
        
        System.out.println("\n=== Publicando notícias ===");
        
        // Publicando notícias
        agency.publishNews("Lançamento do novo iPhone 16", "TECNOLOGIA");
        System.out.println();
        
        agency.publishNews("Brasil vence a Copa do Mundo", "ESPORTES");
        System.out.println();
        
        agency.publishNews("Nova descoberta em inteligência artificial", "TECNOLOGIA");
        System.out.println();
        
        // Removendo um observador
        agency.removeObserver(techObserver);
        System.out.println("\n=== Após remover observador de tecnologia ===");
        
        agency.publishNews("Lançamento do framework Spring Boot 4.0", "TECNOLOGIA");
    }
}