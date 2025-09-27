package exemplo;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private String nome;
    private List<Professor> professores; // Agregação

    public Universidade(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void listarProfessores() {
        System.out.println("Professores da " + nome + ":");
        for (Professor p : professores) {
            System.out.println("- " + p.getNome());
        }
    }
}

