package exercicioDecorator.adicionais;

import exercicioDecorator.Decorator;
import exercicioDecorator.Acai;

public class Granola extends Decorator{

    public Granola(Acai acai, int quantidade) {
        super(acai, "Granola", quantidade);
    }

    @Override
    public String getDescricao() {
        return acai.getDescricao() + " com " + this.quantidade + "x granola";
    }

    @Override
    public double getPreco() {
        return acai.getPreco() + (3.50*this.quantidade);
    }


}
