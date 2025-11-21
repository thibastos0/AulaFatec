import br.com.loja.CalculadoraDePedidos;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        CalculadoraDePedidos calc = new CalculadoraDePedidos();
        double resultado = calc.calcularTotal(4, 2, 10.0);
        System.out.println(resultado);
    }
}
