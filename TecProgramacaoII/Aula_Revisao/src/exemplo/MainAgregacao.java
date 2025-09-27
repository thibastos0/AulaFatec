package exemplo;

public class MainAgregacao {
    public static void main(String[] args) {
        Professor p1 = new Professor("Carlos");
        Professor p2 = new Professor("Mariana");

        Universidade univ = new Universidade("USP");
        univ.adicionarProfessor(p1);
        univ.adicionarProfessor(p2);

        univ.listarProfessores();
    }
}
