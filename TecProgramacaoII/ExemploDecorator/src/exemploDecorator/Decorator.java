package exemploDecorator;

public abstract class Decorator extends Bebida {

    protected Bebida bebida;
    
    public Decorator(Bebida bebida, String descricao) {
        super(descricao);
        this.bebida = bebida;
    }
    
    public abstract String getDescricao();
    
    public abstract double valor();

}
