package exercicioDecorator;

public abstract class Decorator extends Acai {

    protected Acai acai;
    protected int quantidade = 0;

    public Decorator(Acai acai, String descricao, int quantidade){
        super(descricao);
        this.acai = acai;
        this.quantidade = quantidade;
    }

    public abstract String getDescricao();
    
    public abstract double getPreco();

}
