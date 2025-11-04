package exemplo3;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers;
    private String latestNews;
    private String category;
    
    public NewsAgency() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Novo observador adicionado!");
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observador removido!");
    }
    
    @Override
    public void notifyObservers(String news, String category) {
        System.out.println("Notificando " + observers.size() + " observadores sobre: " + category);
        for (Observer observer : observers) {
            observer.update(news, category);
        }
    }
    
    public void publishNews(String news, String category) {
        this.latestNews = news;
        this.category = category;
        notifyObservers(news, category);
    }
    
    // Getters
    public String getLatestNews() { return latestNews; }
    public String getCategory() { return category; }
}