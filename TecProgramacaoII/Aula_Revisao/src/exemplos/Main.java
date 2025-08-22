package exemplos;

public class Main {
    public static void main(String[] args) {
        Aluno objAluno1 = new Aluno();
        objAluno1.ra = 1234;
        objAluno1.nome = "Lucas";
        objAluno1.idade = 21;
        
        Aluno objAluno2 = new Aluno();
        objAluno2.ra = 4321;
        objAluno2.nome = "Thiago";
        objAluno2.idade = 43;

        objAluno1.OlaMundo();
        objAluno1.mostrarDados();
        objAluno2.OlaMundo();
        objAluno2.mostrarDados();
    }

}
