package exercicioObserver;

public class Inmet implements Observer {

	public EstacaoMeteorologica estacao;

	public Inmet(EstacaoMeteorologica estacao) {
		this.estacao = estacao;
		this.estacao.adicionar(this);
	}

	public void update() {
		System.out.println("Inmet: dados atualizados -> pressão = " + String.format("%.2f", estacao.pressao)
				+ " temperatura= " + String.format("%.2f", estacao.temperatura) + " umidade= "
				+ String.format("%.2f", estacao.umidade));
	}
}