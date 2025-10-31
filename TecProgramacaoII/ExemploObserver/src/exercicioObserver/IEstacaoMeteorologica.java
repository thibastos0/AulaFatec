package exercicioObserver;

public interface IEstacaoMeteorologica {
	public void adicionar(Observer observer);

	public void remover(Observer observer);

	public void notificacao();
}
