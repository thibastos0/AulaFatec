package aulaAdapter;

public class Vendedor implements Funcionario {

    //private String nome;
    private double salarioMensal = 2500.0;
    private double comissaoMensal = 2000.0;

    /*public Vendedor(String nome, double salarioMensal, double comissaoMensal) {
        this.nome = nome;
        this.salarioMensal = salarioMensal;
        this.comissaoMensal = comissaoMensal;
    }*/

    @Override
    public double calcularSalarioMensal() {
        return salarioMensal + comissaoMensal;
    }

    @Override
    public double calcularSalarioAnual() {
        return (salarioMensal + comissaoMensal) * 12;
    }

}
