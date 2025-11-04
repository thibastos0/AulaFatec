package exemplo6;

public class Observador2 implements Observador {

	@Override
	public void atualizacao(Observado observado) {
		ObservadoConcreto observadoConcreto = (ObservadoConcreto) observado;
		System.out.println(String.format("Observador 2: %d", observadoConcreto.getEstado()));
	}

}