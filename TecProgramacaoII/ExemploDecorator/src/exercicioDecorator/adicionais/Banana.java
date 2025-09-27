package exercicioDecorator.adicionais;

import exercicioDecorator.Acai;
import exercicioDecorator.Decorator;

public class Banana extends Decorator{

    public Banana(Acai acai, int quantidade){
        super(acai, "Banana", quantidade);

    }

    @Override
    public String getDescricao(){
        return acai.getDescricao() + " com " + this.quantidade + "x banana";
    }

    @Override
    public double getPreco(){
        return acai.getPreco() + 3.50*this.quantidade;
    }

}
