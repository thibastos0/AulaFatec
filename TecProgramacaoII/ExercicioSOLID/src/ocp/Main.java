package ocp;

public class Main {

    public static void main(String[] args) {
        //Cliente cliente1 = new Cliente("Alice", "Regular");
        Cliente cliente2 = new Cliente("Bob", "VIP");
        Cliente cliente3 = new Cliente("Charlie", "Estudante");

        //double desconto1 = new ClienteRegular().liberarDesconto(cliente1);
        double desconto2 = new ClienteVIP().liberarDesconto(cliente2);
        double desconto3 = new ClienteEstudante().liberarDesconto(cliente3);

        //System.out.println("Desconto Alice: " + desconto1);
        System.out.println("Desconto Bob: " + desconto2);
        System.out.println("Desconto Charlie: " + desconto3);
    }

}
