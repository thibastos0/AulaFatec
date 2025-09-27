package exercicioDecorator.coposAcai;

import exercicioDecorator.Acai;

public class Acai700ml extends Acai{

    public Acai700ml(){
        super("Acaí no copinho de 700ml");
    }

    @Override
    public double getPreco(){
        return 25.00;
    }

}
