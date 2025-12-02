package exemplo3;

//Observer para notícias de tecnologia
public class TechEnthusiast implements Observer {
 private String name;
 
 public TechEnthusiast(String name) {
     this.name = name;
 }
 
 @Override
 public void update(String news, String category) {
     if ("TECNOLOGIA".equals(category)) {
         System.out.println(name + " recebeu notícia de TECNOLOGIA: " + news);
     }
 }
 
 public String getName() { return name; }
}

