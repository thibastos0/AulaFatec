package exercicioDecorator.adicionais;

import exercicioDecorator.Decorator;
import exercicioDecorator.Acai;

public class Ninho extends Decorator {

    public Ninho(Acai acai){
        super(acai, "Leite Ninho");
    }

    @Override
    public String getDescricao() {
        return acai.getDescricao() + " com leite ninho";
    }

    @Override
    public double valor() {
        return acai.valor() + 2.75;
    }

}
