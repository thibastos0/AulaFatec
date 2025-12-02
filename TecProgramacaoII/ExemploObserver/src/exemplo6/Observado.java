package exemplo6;

public interface Observado {

	void adicionarObservador(Observador observador);
	
	void removerObservador(Observador observador);
	
	void notificarObservadores();
	
}
