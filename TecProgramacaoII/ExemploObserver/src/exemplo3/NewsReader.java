package exemplo3;

//Observer universal que recebe todas as notícias
public class NewsReader implements Observer {
private String name;

public NewsReader(String name) {
 this.name = name;
}

@Override
public void update(String news, String category) {
 System.out.println(name + " recebeu notícia de " + category + ": " + news);
}

public String getName() { return name; }
}

