package exemplo6;

import java.util.ArrayList;
import java.util.List;

public class ObservadoConcreto implements Observado {

	// Variável responsável por guardar os observadores
	private List<Observador> observadores = new ArrayList<Observador>();
	
	// Estado do meu observado
	private int estado;
	
	@Override
	public void adicionarObservador(Observador observador) {
		observadores.add(observador);
	}

	@Override
	public void removerObservador(Observador observador) {
		observadores.remove(observador);
	}

	@Override
	public void notificarObservadores() {
		for(Observador observador : observadores) {
			observador.atualizacao(this);
		}
	}

  // Métodos responsáveis pela alteração do estado	
	public void setEstado(int estado) {
		this.estado = estado;
		notificarObservadores();
	}
	
	public int getEstado() {
		return this.estado;
	}

}

