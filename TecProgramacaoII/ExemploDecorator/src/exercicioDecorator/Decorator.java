package exercicioDecorator;

public abstract class Decorator extends Acai {

    protected Acai acai;

    public Decorator(Acai acai, String descricao){
        super(descricao);
        this.acai = acai;
    }

    public abstract String getDescricao();
    
    public abstract double valor();

}
