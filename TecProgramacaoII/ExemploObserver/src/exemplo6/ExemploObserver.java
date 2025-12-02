package exemplo6;

import java.util.Scanner;

public class ExemploObserver {

	public static void main(String[] args) {

	
		// Instanciando o observado
		ObservadoConcreto observado = new ObservadoConcreto();

		// Adicionando os observadores
		observado.adicionarObservador(new Observador1());
		observado.adicionarObservador(new Observador2());
		
		// Criar um scanner para caputurar valores do terminal
		Scanner scanner = new Scanner(System.in);
		
		int numero = 0;
		
		while(numero != -1) {
			System.out.print("Digite um número inteiro: ");
			numero = scanner.nextInt();
			
			// Vamos fazer a mudança de estado do nosso observado
			observado.setEstado(numero);
		}

		// fechar o scanner
		scanner.close();
	}
}
