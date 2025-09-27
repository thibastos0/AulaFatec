package exemploDecorator.adicionais;
import exemploDecorator.Bebida;
import exemploDecorator.Decorator;

public class Acucar extends Decorator {

    public Acucar(Bebida bebida) {
        super(bebida, "Açúcar");
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " com açúcar";
    }

    @Override
    public double valor() {
        return bebida.valor() + 1.00;
    }

}
