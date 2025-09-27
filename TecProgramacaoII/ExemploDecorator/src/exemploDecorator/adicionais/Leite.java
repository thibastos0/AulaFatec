package exemploDecorator.adicionais;

import exemploDecorator.Bebida;
import exemploDecorator.Decorator;

public class Leite extends Decorator {

    public Leite(Bebida bebida){
        super(bebida, "Leite");
    }

    @Override
    public String getDescricao(){

        return bebida.getDescricao() + " com leite";
    }

    @Override
    public double valor(){
        return bebida.valor() + 6.00;
    }


}
