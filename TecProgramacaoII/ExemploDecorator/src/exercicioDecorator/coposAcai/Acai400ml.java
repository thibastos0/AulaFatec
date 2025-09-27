package exercicioDecorator.coposAcai;

import exercicioDecorator.Acai;

public class Acai400ml extends Acai{

    public Acai400ml(){
        super("Açaí no copinho de 400ml");
    }

    @Override
    public double getPreco(){
        return 15.00;
    }

}
