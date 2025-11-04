package exemplos;


public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("C:/Users/admin/Documents/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com.br"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
