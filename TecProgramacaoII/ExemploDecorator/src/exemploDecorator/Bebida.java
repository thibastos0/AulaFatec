package exemploDecorator;

public abstract class Bebida {

	private String descricao;
	
	public Bebida(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public abstract double valor();

}