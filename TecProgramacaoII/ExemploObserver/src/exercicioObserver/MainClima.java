package exercicioObserver;

import java.util.Random;

public class MainClima {
	public static void main(String[] args) {

		EstacaoMeteorologica estacao = new EstacaoMeteorologica();
		Inmet inmet = new Inmet(estacao);
		ClimaTempo climaTempo = new ClimaTempo(estacao);
		CamposUniversitarios camposUniversitarios = new CamposUniversitarios(estacao);

		int count = 0;

		while (count <= 10) {

			double umidade = new Random().nextDouble();
			double temperatura = new Random().nextDouble();
			double pressao = new Random().nextDouble();

			estacao.atualizarInformacoes(temperatura, pressao, umidade);

			if (count == 3) {
				estacao.remover(inmet);
			}

			if (count == 6) {
				estacao.remover(camposUniversitarios);
			}

			try {
				Thread.sleep(3000);

				if (count == 10) {
					System.out.println("Fim...");
					System.exit(0);
				}
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}