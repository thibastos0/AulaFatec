package aulaAdapter.lojaNova;

public class EmpregadoConcreto implements Empregado {

    @Override
    public double calcularSalario(int periodo) {

        double salario = 0.0;
        
        switch (periodo) {
            case 1: // mensal
                salario = 3000.0;
                break;
            case 12: // anual
                salario = 3000.0 * 12;
                break;
            case 3: // trimestral
                salario = 3000.0 * 3;
                break;
            default:
                throw new IllegalArgumentException("Período inválido");
        }
        return salario;
    }

}
