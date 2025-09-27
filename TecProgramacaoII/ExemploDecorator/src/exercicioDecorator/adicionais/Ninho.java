package exercicioDecorator.adicionais;

import exercicioDecorator.Decorator;
import exercicioDecorator.Acai;

public class Ninho extends Decorator {

    public Ninho(Acai acai, int quantidade){
        super(acai, "Leite Ninho", quantidade);
    }

    @Override
    public String getDescricao() {
        return acai.getDescricao() + " com " + this.quantidade + "x leite ninho";
    }

    @Override
    public double getPreco() {
        return acai.getPreco() + (5.00*this.quantidade);
    }

}
