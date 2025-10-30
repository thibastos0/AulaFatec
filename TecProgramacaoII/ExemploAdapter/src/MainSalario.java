import java.util.ArrayList;
import java.util.List;

import aulaAdapter.*;
import aulaAdapter.lojaNova.*;

public class MainSalario {

    public static void main(String[] args) {
        
        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario administrativo = new Administrativo();

        Empregado empregado = new EmpregadoConcreto();
        //Empregado empregado2 = new EmpregadoConcreto();
        Funcionario empregadoAdapter = new EmpregadoAdapter(empregado);
        //Funcionario empregadoAdapter2 = new EmpregadoAdapter(empregado2);
        //System.out.println("Salário mensal: " + empregadoAdapter.calcularSalarioMensal());
        //System.out.println("Salário anual: " + empregadoAdapter.calcularSalarioAnual());

        List<Funcionario> lista = new ArrayList<Funcionario>();
        lista.add(empregadoAdapter);
        //lista.add(empregadoAdapter2);
        lista.add(gerente);
        lista.add(vendedor);
        lista.add(administrativo);

        for (Funcionario f : lista) {
            System.out.println("Salário mensal: R$" +f.calcularSalarioMensal());
            System.out.println("Salário anual: R$" +f.calcularSalarioAnual());
        
        }

    }

}
