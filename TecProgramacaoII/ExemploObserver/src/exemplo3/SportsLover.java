package exemplo3;

//Observer para notícias de esportes
public class SportsLover implements Observer {
private String name;

public SportsLover(String name) {
   this.name = name;
}

@Override
public void update(String news, String category) {
   if ("ESPORTES".equals(category)) {
       System.out.println(name + " recebeu notícia de ESPORTES: " + news);
   }
}

public String getName() { return name; }
}

