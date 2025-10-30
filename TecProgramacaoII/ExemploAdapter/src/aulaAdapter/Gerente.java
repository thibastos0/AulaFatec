package aulaAdapter;

public class Gerente implements Funcionario {

    //private String nome;
    private double salarioMensal = 10000.0;

    /*public Gerente(String nome, double salarioMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
    }*/

    @Override
    public double calcularSalarioMensal() {
        return salarioMensal;
    }

    @Override
    public double calcularSalarioAnual() {
        return salarioMensal * 12;
    }


}
