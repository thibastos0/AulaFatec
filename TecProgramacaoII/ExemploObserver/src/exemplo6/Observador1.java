package exemplo6;

public class Observador1 implements Observador {

	@Override
	public void atualizacao(Observado observado) {
		ObservadoConcreto observadoConcreto = (ObservadoConcreto) observado;
		System.out.println(String.format("Observador 1: %d", observadoConcreto.getEstado()));
	}

}