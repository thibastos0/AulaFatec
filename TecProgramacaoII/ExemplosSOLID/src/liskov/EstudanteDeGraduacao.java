package liskov;

public class EstudanteDeGraduacao extends Estudante {

    public EstudanteDeGraduacao(String nome) {
        super(nome);
    }

    @Override
    public void estudar() {
        System.out.println(nome + " está estudando na graduação.");
    }

    public void entregarTCC(){
        //...
    }
}
