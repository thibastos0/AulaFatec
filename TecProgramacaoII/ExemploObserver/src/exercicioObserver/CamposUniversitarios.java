package exercicioObserver;

public class CamposUniversitarios implements Observer {

	public EstacaoMeteorologica estacao;

	public CamposUniversitarios(EstacaoMeteorologica estacao) {
		this.estacao = estacao;
		this.estacao.adicionar(this);
	}

	public void update() {
		System.out.println("CamposUniversitarios: dados atualizados -> pressão = "
				+ String.format("%.2f", estacao.pressao) + " temperatura= " + String.format("%.2f", estacao.temperatura)
				+ " umidade= " + String.format("%.2f", estacao.umidade));
	}
}
