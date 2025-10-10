package aulaAdapter;

public class Administrativo implements Funcionario {

    //private String nome;
    private double salarioMensal = 5000.0;
    private double adicionalNoturnoMensal = 500.0;

    /*public Administrativo(String nome, double salarioMensal, double adicionalNoturnoMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
        this.adicionalNoturnoMensal = adicionalNoturnoMensal;
    }*/

    @Override
    public double calcularSalarioMensal() {
        return salarioMensal + adicionalNoturnoMensal;
    }

    @Override
    public double calcularSalarioAnual() {
        return (salarioMensal + adicionalNoturnoMensal) * 12;
    }

}
