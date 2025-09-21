package exercicioDecorator.adicionais;
import exercicioDecorator.Decorator;
import exercicioDecorator.Acai;

public class Granola extends Decorator{

    public Granola(Acai acai) {
        super(acai, "Granola");
    }

    @Override
    public String getDescricao() {
        return acai.getDescricao() + " com granola";
    }

    @Override
    public double valor() {
        return acai.valor() + 2.50;
    }

}
